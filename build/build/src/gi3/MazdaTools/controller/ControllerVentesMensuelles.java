package gi3.MazdaTools.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerVentesMensuelles implements Initializable {

    @FXML
    private BarChart<?, ?> mensuellesChart;

    @FXML
    private CategoryAxis mois;

    @FXML
    private NumberAxis gain1;
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void initialize(URL url, ResourceBundle rb) {

      
        XYChart.Series set2 = new XYChart.Series<>();
        try {
            ConnectionDB connection= new ConnectionDB();
    		@SuppressWarnings("static-access")
    		Connection con =connection.getConnection();
    		
    		PreparedStatement statement1;
    		PreparedStatement statement2;
    		PreparedStatement statement3;
    		PreparedStatement statement4;
    		PreparedStatement statement5;
    		PreparedStatement statement6;
    		PreparedStatement statement7;
    		PreparedStatement statement8;
    		PreparedStatement statement9;
    		PreparedStatement statement10;
    		PreparedStatement statement11;
    		PreparedStatement statement12;
	    	
	    	String query1 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____01%'";
	    	String query2 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____02%'";
	    	String query3 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____03%'";
	    	String query4 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____04%'";
	    	String query5 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____05%'";
	    	String query6 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____06%'";
	    	String query7 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____07%'";
	    	String query8 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____08%'";
	    	String query9 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____09%'";
	    	String query10 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____10%'";
	    	String query11 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____11%'";
	    	String query12 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '_____12%'";
	    	
	    	statement1 =con.prepareStatement(query1);
	    	statement2 =con.prepareStatement(query2); 
	    	statement3 =con.prepareStatement(query3); 
	    	statement4 =con.prepareStatement(query4); 
	    	statement5 =con.prepareStatement(query5); 
	    	statement6 =con.prepareStatement(query6); 
	    	statement7 =con.prepareStatement(query7); 
	    	statement8 =con.prepareStatement(query8); 
	    	statement9 =con.prepareStatement(query9); 
	    	statement10 =con.prepareStatement(query10); 
	    	statement11 =con.prepareStatement(query11); 
	    	statement12 =con.prepareStatement(query12); 
	    	
	        ResultSet resultat1 = statement1.executeQuery(query1);
	        ResultSet resultat2 = statement2.executeQuery(query2);
	        ResultSet resultat3 = statement3.executeQuery(query3);
	        ResultSet resultat4 = statement4.executeQuery(query4);
	        ResultSet resultat5 = statement5.executeQuery(query5);
	        ResultSet resultat6 = statement6.executeQuery(query6);
	        ResultSet resultat7 = statement7.executeQuery(query7);
	        ResultSet resultat8 = statement8.executeQuery(query8);
	        ResultSet resultat9 = statement9.executeQuery(query9);
	        ResultSet resultat10 = statement10.executeQuery(query10);
	        ResultSet resultat11 = statement11.executeQuery(query11);
	        ResultSet resultat12 = statement12.executeQuery(query12);
	        
    		
	        resultat1.next();
	        resultat2.next();
	        resultat3.next();
	        resultat4.next();
	        resultat5.next();
	        resultat6.next();
	        resultat7.next();
	        resultat8.next();
	        resultat9.next();
	        resultat10.next();
	        resultat11.next();
	        resultat12.next();
	        
    		set2.getData().add(new XYChart.Data("Janvier",resultat1.getFloat("SOMME")));
    		set2.getData().add(new XYChart.Data("Fevrier",resultat2.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Mars",resultat3.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Avril",resultat4.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Mai",resultat5.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Juin",resultat6.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Juillet",resultat7.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Aout",resultat8.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Septembre",resultat9.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Octobre",resultat10.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Novembre",resultat11.getFloat("SOMME")));
            set2.getData().add(new XYChart.Data("Decembre",resultat12.getFloat("SOMME")));
            
    		mensuellesChart.getData().addAll(set2);	
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        

        
    }
     public void produits(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Statistiques.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ventesMensuelles(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/VentesMensuelles.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
   public void ventesAnnuelles(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/VentesAnnuelles.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

	public void HomeRetour(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
}
