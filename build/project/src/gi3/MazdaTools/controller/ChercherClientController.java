package gi3.MazdaTools.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChercherClientController implements Initializable {
	
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
    @FXML private TextField tel;
	@FXML private TextField NomPrenom;
	@FXML private Label msg;
	@FXML private Label name;
	@FXML private Label gender;
	@FXML private Label phone;
	@FXML private Label mail;
	
    ConnectionDB connection= new ConnectionDB();
	@SuppressWarnings("static-access")
	Connection con =connection.getConnection();
	
	private static String nomClient;
	private static String numTeleClient;
	private static String clientSexe;
	private static String clientEmail;
	
	public void Chercher (ActionEvent event ) throws IOException,SQLException {
		

		 if(tel.getText().equals("") || NomPrenom.getText().equals("")){
				msg.setVisible(true);
			}
		 else{

			    Connection con =dbConnect.Connect();
				PreparedStatement stat =null;
				ResultSet rs=null;
				int fined=0;
				int leng=0;
				String sql="SELECT * FROM client";
				try {
					stat= con.prepareStatement(sql);
					rs=stat.executeQuery();
					while(rs.next())
					{ leng++;}
					rs=null;
					rs=stat.executeQuery();
					while(rs.next())
					{
						if(tel.getText().toString().equals(rs.getString("phone")) && NomPrenom.getText().toString().equals(rs.getString("name"))){
						 nomClient = rs.getString("name");
						 numTeleClient = rs.getString("phone");
						 clientSexe= rs.getString("gender");
						 clientEmail = rs.getString("email");
						 
						 Parent root = FXMLLoader.load(getClass().getResource("../view/ModifierClient.fxml"));
						 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						 Scene scene = new Scene(root);
						 stage.setScene(scene);
						 stage.show();
						 
						 
                        break;
						}
						else{
							fined++;
						}
					}
					if(fined==leng){


							Alert alert = new Alert( Alert.AlertType.WARNING);
							alert.setTitle( "Client not found!!!" );
							alert.setHeaderText( null );
					    	alert.setContentText( "Client not found!!!" );
					    	alert.showAndWait();

					}


				     mail.setVisible(false);
					con.close();
				}catch (Exception e) {

				}

		 }

	}
	
	public void HomeRetour(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
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
	
	public static String getNameClient() {
		return nomClient;
	}
	
	public static String getNumClient() {
		return numTeleClient;
	}
	
	public static String getEmailClient() {
		return clientEmail;
	}
	
	public static String getSexeClient() {
		return clientSexe;
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
		try {
			afficherHistorique();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
