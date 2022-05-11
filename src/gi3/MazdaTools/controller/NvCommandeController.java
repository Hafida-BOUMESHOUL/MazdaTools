package gi3.MazdaTools.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.*;

import gi3.MazdaTools.controller.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NvCommandeController implements Initializable {
	
	
	@FXML private ComboBox product;
	@FXML private TextField qte;
	@FXML private TextField price;
	@FXML private TextField address;
	@SuppressWarnings("rawtypes")
	@FXML private ComboBox status;
	@FXML private TextField name;
	@FXML private TextField tel;
	@FXML private TextField mail;
	@SuppressWarnings("rawtypes")
	@FXML private ComboBox sexe;
	@FXML private Button addProduct;
	@FXML private Button addCommand;
	
	@FXML private Label numCommande1;
	@FXML private Label nomClient1;
	@FXML private Label totalCommande1;
	@FXML private Label productHist1;
	@FXML private Label dateCommande1;
	@FXML private Label statusCommande1;
	
	@FXML private Label numCommande2;
	@FXML private Label nomClient2;
	@FXML private Label totalCommande2;
	@FXML private Label productHist2;
	@FXML private Label dateCommande2;
	@FXML private Label statusCommande2;
	
	@FXML private Label numCommande3;
	@FXML private Label nomClient3;
	@FXML private Label totalCommande3;
	@FXML private Label productHist3;
	@FXML private Label dateCommande3;
	@FXML private Label statusCommande3;
	@FXML private Label Commande1;
    @FXML private Label Commande2;
    @FXML private Label Commande3;
    
	
	java.util.List<ProductBean> productList = new java.util.ArrayList<>();
	
	ConnectionDB connection= new ConnectionDB();
	@SuppressWarnings("static-access")
	Connection con =connection.getConnection();
	
	private String[] SEXE = {"Homme","Femme"};
	private String[] STATUS = {"livree","Annulee","En cours"};
	
	private ObservableList<String> products = FXCollections.observableArrayList();
	
	public void fillProductsBox() {
        try {
        	  ConnectionDB connection= new ConnectionDB();
        		Connection con =connection.getConnection();
        		PreparedStatement statement;
        		  String query = "SELECT * FROM product";
        		  statement =con.prepareStatement(query); 
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
            	String nom = resultSet.getString("Label").toString();
            	product.getItems().addAll(nom);
            }
         
        } catch (Exception e) {
            e.printStackTrace();
        }
		
    }
	
	
	
	
	public void HomeRetour(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
	
	public void addProduct(ActionEvent event) throws SQLException {
		/*Alert alert = new Alert( Alert.AlertType.INFORMATION );
	    alert.setTitle( "" );
	    alert.setHeaderText( null );
	    alert.setContentText( "Produit ajouté avec succés !!" );
		alert.showAndWait();*/
		
		ProductBean prd = new ProductBean(); 
		prd.setLabel((String)product.getValue());
		if(!price.getText().equals(""))
			prd.setPrice(Float.valueOf(price.getText()));
		else 
			prd.setPrice(0);
		if(!qte.getText().equals(""))
			prd.setQte(Integer.valueOf(qte.getText()));	
		else 
			prd.setQte(0);
	    productList.add(prd);
	    
	    qte.setText("");
	    price.setText("");
	    product.setValue("Nom du Produit");

	   
	}
	
	public void Enregistrer (ActionEvent event) throws IOException, SQLException {
		
		Alert alert = new Alert( Alert.AlertType.INFORMATION );
	    alert.setTitle( "Nouvelle Commande" );
	    alert.setHeaderText( null );
	    alert.setContentText( "Commande ajoutée avec succés !!" );
		alert.showAndWait();
		
	   
		Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
		Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		   ConnectionDB connection= new ConnectionDB();
		    Connection con =connection.getConnection();
			
		//********* ADD CLIENT**************
		String telephone = tel.getText();
	    String email = mail.getText();
	    String nom = name.getText();
	    String value = (String)sexe.getValue();
	    
	    
		PreparedStatement statement1;
		String query = "SELECT idClient FROM client WHERE phone='"+telephone+"'";
		statement1 =con.prepareStatement(query); 
		ResultSet resultSet = statement1.executeQuery(query);
		
		int idC;
		if(resultSet.next())
		{//tester si le client existe 
			idC = resultSet.getInt("idClient");
		}
		
		else 
		{
			    query = "INSERT INTO client (name, phone, email, gender) VALUES( ?, ?, ?, ?)";
				statement1 =con.prepareStatement(query); 
				statement1.setString(1, nom);
				statement1.setString(2, telephone);
				statement1.setString(3, email);
				statement1.setString(4, value);
				statement1.executeUpdate();
				
				//*******select last inserted idClient 
				
				
			    query = "SELECT MAX(idClient) FROM client";
				statement1 =con.prepareStatement(query); 
				resultSet = statement1.executeQuery(query);
				resultSet.next();

			   idC = resultSet.getInt("MAX(idClient)");
		}
		
		 
		//******* insert ORDER 
		java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		java.time.LocalDateTime now = java.time.LocalDateTime.now();
		
	    String Adress = address.getText();
	  
	    String statu = (String) status.getValue();
	    
		query = "INSERT INTO `myorder`  (Date, Adress, status, idClient, idManager) VALUES(?, ?, ?, ?, ?)";
		statement1 =con.prepareStatement(query); 
		statement1.setString(1, dtf.format(now));
		statement1.setString(2, Adress);
		statement1.setString(3, statu);
		statement1.setInt(4, idC);
		statement1.setInt(5, 1);
		statement1.executeUpdate();
		
		//*******select last inserted idClient 
	    query = "SELECT MAX(idOrder) FROM `myorder`";
		statement1 =con.prepareStatement(query); 
		resultSet = statement1.executeQuery(query);
		resultSet.next();

		int idCOMM = resultSet.getInt("MAX(idOrder)");
		
		//selectionner l id product 

		if(productList.size()==0)
		{
			ProductBean tmp = new ProductBean();
			tmp.setLabel((String)product.getValue());
			tmp.setPrice(Float.valueOf(price.getText()));
			tmp.setQte(Integer.valueOf(qte.getText()));	
			productList.add(tmp);
		
		}
		
		for(ProductBean prdtmp:productList)
		{
			
			query = "SELECT idProduct FROM product WHERE label='"+(String) prdtmp.getLabel()+"'";
			statement1 =con.prepareStatement(query); 
			resultSet = statement1.executeQuery(query);
			resultSet.next();
			int idProd = resultSet.getInt("idProduct");
			int qt= prdtmp.getQte();
			
			//******* insert ORDERLINE 
		    
			query = "INSERT INTO `order_line`  (idOrder, idProduct, soldPrice, quantity) VALUES(?, ?, ?, ?)";
			statement1 =con.prepareStatement(query); 
			statement1.setInt(1, idCOMM);
			statement1.setInt(2, idProd);
			statement1.setFloat(3, 0);
			statement1.setInt(4, qt);
			statement1.executeUpdate();
			
		}
		
		
		
		
		
		
		
				
		
		
		
		/*//**********ADD PRODUCT to order
		  int quantite = Integer.valueOf(qte.getText());
		  float prix = Float.valueOf(price.getText());
		  String produit = (String)product.getValue();  
		
		  //*******Traitemnet 2
			PreparedStatement statement3;
			String query3 = "SELECT * FROM product WHERE label = 'produit' ";
			statement3 =con.prepareStatement(query3); 
			ResultSet resultSet = statement3.executeQuery(query3);
			int idP = resultSet.getInt("idProduct");
			

			//selection du client
			
			//*******Traitemnet 2
			PreparedStatement statement4;
			String query4 = "SELECT * FROM client, order WHERE client.idClient= order.idClient";
			statement4 =con.prepareStatement(query4); 
			ResultSet resultSet1 = statement4.executeQuery(query4);
			int idC = resultSet1.getInt("idClient");
			
			
			//**********Add order****************
			 String adress= address.getText();
			 String statut = (String)status.getValue();
				PreparedStatement statement2;
			String query2 = "INSERT INTO order (Adress, status, idClient, idManager) VALUES( ?, ?, ?, ?)";
			statement2 =con.prepareStatement(query2); 
			statement2.setString(1, adress);
			statement2.setString(2, statut);
			statement2.setInt(3, idC);
			statement2.setInt(4, 1);
			statement2.executeUpdate();
		    
		//*******Traitemnet 1
		PreparedStatement statement;
		String query5 = "INSERT INTO order_line (idProduct, soldPrice, quantity) VALUES( ?, ?, ?)";
		statement =con.prepareStatement(query5);
		statement.setInt(1, idP);
	    statement.setFloat(2, prix);
	    statement.setInt(3, quantite);
	    statement.executeUpdate();*/
		
	    
	    
	    
	}
	
	public void Modifier(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("../view/ModifierCommande.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void Annulee(ActionEvent event ) {
		
		
	}
	
	public void Livree(ActionEvent event ) {
			
			
		}

	
	public void afficherHistorique() throws SQLException {
		try {
			
			PreparedStatement statement1;
	    	
	    	String query1 = ""
	    			+ " SELECT myorder.idOrder, myorder.Date, myorder.status, client.name, product.label"
	    			+ " FROM client, myorder, product, order_line"
	    			+ " WHERE client.idClient = myorder.idClient"
	    			+ " AND myorder.idOrder = order_line.idOrder"
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " ORDER BY myorder.idOrder  DESC LIMIT 3";
	    	
	    	statement1 =con.prepareStatement(query1); 
	        ResultSet resultat1 = statement1.executeQuery(query1);
	        
	        


	        	resultat1.next();
	        	
	        	nomClient1.setText(resultat1.getString("name").toUpperCase());
	        	numCommande1.setText(resultat1.getString("idOrder"));
	        	productHist1.setText(resultat1.getString("label"));
	        	dateCommande1.setText(resultat1.getString("Date"));
	        	statusCommande1.setText(resultat1.getString("status"));
	        	
	        	resultat1.next();
	        	
	        	nomClient2.setText(resultat1.getString("name").toUpperCase());
	        	numCommande2.setText(resultat1.getString("idOrder"));
	        	productHist2.setText(resultat1.getString("label"));
	        	dateCommande2.setText(resultat1.getString("Date"));
	        	statusCommande2.setText(resultat1.getString("status"));
	        
	        	resultat1.next();
	        	
	        	nomClient3.setText(resultat1.getString("name").toUpperCase());
	        	numCommande3.setText(resultat1.getString("idOrder"));
	        	productHist3.setText(resultat1.getString("label"));
	        	dateCommande3.setText(resultat1.getString("Date"));
	        	statusCommande3.setText(resultat1.getString("status"));
	        
        
        con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fillProductsBox();
		try {
			afficherHistorique();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Selected product
		product.setOnAction((event) -> {
			
			 ConnectionDB connection= new ConnectionDB();
			 Connection con =connection.getConnection();
				PreparedStatement statement;
				
		    int selectedIndex = product.getSelectionModel().getSelectedIndex();
		    Object selectedItem = product.getSelectionModel().getSelectedItem();
		  
		    String query = "SELECT unit_price FROM product WHERE label='"+product.getValue()+"'";
  		  	try {
				statement =con.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery(query);
				resultSet.next();
				String pricetmp = resultSet.getString("unit_price");
				price.setText(pricetmp);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            
      
      
		});
		sexe.getItems().addAll(SEXE);
		status.getItems().addAll(STATUS);
		
	}
	
	
	

}
