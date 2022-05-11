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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeController implements Initializable{
	
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
	
	ConnectionDB connection= new ConnectionDB();
	@SuppressWarnings("static-access")
	Connection con =connection.getConnection();
	
	public void LogOut(ActionEvent event) throws IOException {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Deconnexion");
        alert.setHeaderText(null);
        alert.setContentText("Est-ce que vous voulez quitter ?!");
		alert.showAndWait();
        
		if (alert.getResult()==ButtonType.OK){
			
			Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			 Scene scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
		} else {
			
		}
		
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
	   
	
	public void Settings(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/Parametres.fxml"));
		Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void NvCommande(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/NouvelleCommande.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
	
	public void SearchCommande(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/ChercherCommande.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
	
	public void SearchClient(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/ChercherClient.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
	
	public void Statistiques(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/Statistiques.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			afficherHistorique();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}