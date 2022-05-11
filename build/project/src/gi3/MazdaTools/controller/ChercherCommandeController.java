package gi3.MazdaTools.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;




public class ChercherCommandeController implements Initializable {
	
	ConnectionDB connection= new ConnectionDB();
	@SuppressWarnings("static-access")
	Connection con =connection.getConnection();
	@FXML private TextField status;
    @SuppressWarnings("rawtypes")
	@FXML private ComboBox product;
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
	
    @FXML
	public void Chercher (ActionEvent event ) throws IOException, SQLException {
		
		//Se connecter au dataBase
		ConnectionDB connection = new ConnectionDB();
		@SuppressWarnings("static-access")
		Connection con = connection.getConnection();
		
		try {
			PreparedStatement statement;
			String query = "SELECT client.name,myorder.status,myorder.Date,myorder.idOrder,"
					+ " product.label,order_line.quantity * order_line.soldPrice AS prix,"
					+ " order_line.quantity,order_line.soldPrice"
					+ " FROM client,myorder,product,order_line" 
					+ " WHERE (client.idClient = myorder.idClient "
					+ " AND myorder.idOrder = order_line.idOrder"
					+ " AND product.idProduct = order_line.idProduct)"
					+ " AND (status = '" + status.getText() +"' "
					+ " OR product.label = '" + product.getPromptText()+"')";

			statement =con.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery(query);
			
			resultSet.next();
			nomClient1.setText(resultSet.getString("client.name"));
            statusCommande1.setText(resultSet.getString("status"));
            numCommande1.setText("Commande #"+resultSet.getString("idOrder"));
            totalCommande1.setText(resultSet.getString("quantity")+" x Produit "+resultSet.getString("label")+"= "+resultSet.getString("prix"));
            dateCommande1.setText(resultSet.getString("Date"));
            resultSet.next();
            nomClient2.setText(resultSet.getString("client.name"));
            statusCommande2.setText(resultSet.getString("status"));
            numCommande2.setText("Commande #"+resultSet.getString("idOrder"));
            totalCommande2.setText(resultSet.getString("quantity")+" x Produit "+resultSet.getString("label")+"= "+resultSet.getString("prix"));
            dateCommande2.setText(resultSet.getString("Date"));
            resultSet.next();
            nomClient3.setText(resultSet.getString("client.name"));
            statusCommande3.setText(resultSet.getString("status"));
            numCommande3.setText("Commande #"+resultSet.getString("idOrder"));
            totalCommande3.setText(resultSet.getString("quantity")+" x Produit "+resultSet.getString("label")+"= "+resultSet.getString("prix"));
            dateCommande3.setText(resultSet.getString("Date"));
            
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
//		if(status.getValue().contentEquals("Status") && product.getValue().contains("Nom de produit")) {
//			Alert alert = new Alert(Alert.AlertType.ERROR);
//			alert.setTitle("Erreur!!");
//			alert.setContentText("Vous devez remplir au moins un champ!");
//			alert.show();
//		}
        
	  
	}
	
	public void HomeRetour(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
	
	public void modifierCommande(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/ModifierCommande.fxml"));
		Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
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
	public void refresh(MouseEvent event) throws SQLException,IOException{
		//clear search 1
		nomClient1.setText("---");
		numCommande1.setText("---");
		statusCommande1.setText("---");
		totalCommande1.setText("---");
		dateCommande1.setText("---");
		//clear search 2
		nomClient2.setText("---");
		numCommande2.setText("---");
		statusCommande2.setText("---");
		totalCommande2.setText("---");
		dateCommande2.setText("---");
		//clear search 3
		nomClient3.setText("---");
		numCommande3.setText("---");
		statusCommande3.setText("---");
		totalCommande3.setText("---");
		dateCommande3.setText("---");
		
		//refresh status BOX
		status.setText("Status");
		//refresh product BOX
		product.setPromptText("Nom de produit");
	}
	public void fillProductsBox() {
        try {
        	  ConnectionDB connection= new ConnectionDB();
        		@SuppressWarnings("static-access")
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
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			try {
				afficherHistorique();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
		}
	
}
