package gi3.MazdaTools.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController  implements Initializable {
		
		@FXML 
		private TextField identifiant;
		
		@FXML
		private Label emptyFields;
		
		@FXML
		private Label EmptyFields;
		
		@FXML
		private Label IncorrectInfo;
		
		@FXML 
		private Label IdInvalide;
		
		@FXML 
		private Label MdpInvalide;
		
		@FXML
		private PasswordField motDePasse;
		
		@FXML
		private Button seConnecter;
		
		@FXML
	    private Label MDPNonIdentiques;

	    @FXML
	    private PasswordField ancienMDP;

	    @FXML
	    private PasswordField newMDP;

	    @FXML
	    private PasswordField confirmMDP;

	    @FXML
	    private Label MDPIncorecct;

		
		
		
		public void Connecter(ActionEvent event) throws SQLException {
			Connection con =dbConnect.Connect();
			PreparedStatement stat =null;
			ResultSet rs=null;
			String sql="SELECT * FROM manager WHERE Login = ? AND password = ?";
			try {
				stat= con.prepareStatement(sql);
				stat.setString(1, identifiant.getText().toString());
				stat.setString(2, motDePasse.getText().toString());
				rs=stat.executeQuery();
				

				if(rs.next())
				{
					Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
					 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					 Scene scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
				}else {
					PreparedStatement stat1= con.prepareStatement("SELECT * FROM manager WHERE idManager = 1");
					ResultSet rs1=stat1.executeQuery();
					rs1.next();
					if(identifiant.getText().toString().equals("") || motDePasse.getText().toString().equals("") )
					{	
						
						IncorrectInfo.setVisible(false);
						emptyFields.setVisible(true);
						IdInvalide.setVisible(false);
						MdpInvalide.setVisible(false);
						
					}else if(identifiant.getText().toString().equals(rs1.getString("Login")) && motDePasse.getText().toString().equals(rs1.getString("password"))==false)
					{	
						MdpInvalide.setVisible(true);
						emptyFields.setVisible(false);
						IncorrectInfo.setVisible(false);
						IdInvalide.setVisible(false);
						
					}else if (motDePasse.getText().toString().equals(rs1.getString("password")) && identifiant.getText().toString().equals(rs1.getString("Login"))==false)
					{
						IdInvalide.setVisible(true);
						emptyFields.setVisible(false);
						IncorrectInfo.setVisible(false);
						MdpInvalide.setVisible(false);
					}
					else if(identifiant.getText().toString().equals(rs1.getString("Login"))==false && motDePasse.getText().toString().equals(rs1.getString("password"))==false)
					{
						IdInvalide.setVisible(false);
						MdpInvalide.setVisible(false);
						emptyFields.setVisible(false);
						IncorrectInfo.setVisible(true);
					}
				}
				con.close();
			}catch (Exception e) {
				
			}
		}
		
		public void Changer(ActionEvent event) throws IOException, SQLException {
			Connection con =dbConnect.Connect();
			PreparedStatement stat1= con.prepareStatement("SELECT * FROM manager WHERE idManager = 1");
			ResultSet rs1=stat1.executeQuery();
			rs1.next();
			
			String ActuelMDPBDD = rs1.getString("password");
			String ActuelMDP = ancienMDP.getText();
			String NewMDP = newMDP.getText();
			String NewMDP2 = confirmMDP.getText();
			
			
			if (ActuelMDP.equals("") || NewMDP.equals("") || NewMDP2.equals("")) {
				
				MDPIncorecct.setVisible(false);
				MDPNonIdentiques.setVisible(false);
				EmptyFields.setVisible(true);
			}else if(ActuelMDP.equals(ActuelMDPBDD)==false)
			{	
				EmptyFields.setVisible(false);
				MDPNonIdentiques.setVisible(false);
				MDPIncorecct.setVisible(true);
				
			}	
			else if (ActuelMDP.equals(ActuelMDPBDD) && NewMDP.equals(NewMDP2)==false )
			{
				MDPNonIdentiques.setVisible(true);
				MDPIncorecct.setVisible(false);
				EmptyFields.setVisible(false);
			}else {
				Connection con1 =dbConnect.Connect();
				PreparedStatement stat2= con1.prepareStatement("UPDATE manager SET password = ? WHERE idManager = 1");
				stat2.setString(1, newMDP.getText().toString());
				stat2.executeUpdate();
				
				
				
					Alert alert = new Alert( Alert.AlertType.INFORMATION );
					alert.setTitle( "" );
					alert.setHeaderText( null );
			    	alert.setContentText( "Mot De Passe Changé avec succée !!" );
			    	alert.showAndWait();
				
			   
			    	Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
			    	Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			    	Scene scene = new Scene(root);
			    	stage.setScene(scene);
			    	stage.show();
			}
			
		}
		
		public void HomeRetour(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
			 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			 Scene scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
			
		}


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}

}