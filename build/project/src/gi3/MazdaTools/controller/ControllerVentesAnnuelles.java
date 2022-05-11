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

public class ControllerVentesAnnuelles implements Initializable {

    @FXML
    private BarChart<?, ?> annuellesChart;

    @FXML
    private CategoryAxis annees;

    @FXML
    private NumberAxis gain2;
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void initialize(URL url, ResourceBundle rb) {

        
        XYChart.Series set3 = new XYChart.Series<>();
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
	    	
	    	String query1 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '2015%'";
	    	String query2 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '2016%'";
	    	String query3 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '2017%'";
	    	String query4 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '2018%'";
	    	String query5 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '2019%'";
	    	String query6 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '2020%'";
	    	String query7 = ""
	    			+ " SELECT SUM(order_line.quantity * product.unit_price) AS SOMME"
	    			+ " FROM  myorder, product, order_line"
	    			+ " WHERE myorder.idOrder = order_line.idOrder "
	    			+ " AND order_line.idProduct = product.idProduct"
	    			+ " AND myorder.Date LIKE '2021%'";
	    
	    	
	    	statement1 =con.prepareStatement(query1);
	    	statement2 =con.prepareStatement(query2); 
	    	statement3 =con.prepareStatement(query3); 
	    	statement4 =con.prepareStatement(query4); 
	    	statement5 =con.prepareStatement(query5); 
	    	statement6 =con.prepareStatement(query6); 
	    	statement7 =con.prepareStatement(query7); 
	    	
	        ResultSet resultat1 = statement1.executeQuery(query1);
	        ResultSet resultat2 = statement2.executeQuery(query2);
	        ResultSet resultat3 = statement3.executeQuery(query3);
	        ResultSet resultat4 = statement4.executeQuery(query4);
	        ResultSet resultat5 = statement5.executeQuery(query5);
	        ResultSet resultat6 = statement6.executeQuery(query6);
	        ResultSet resultat7 = statement7.executeQuery(query7);
		     
	        
    		
	        resultat1.next();
	        resultat2.next();
	        resultat3.next();
	        resultat4.next();
	        resultat5.next();
	        resultat6.next();
	        resultat7.next();

    		set3.getData().add(new XYChart.Data("2015",resultat1.getFloat("SOMME")));
    		set3.getData().add(new XYChart.Data("2016",resultat2.getFloat("SOMME")));
            set3.getData().add(new XYChart.Data("2017",resultat3.getFloat("SOMME")));
            set3.getData().add(new XYChart.Data("2018",resultat4.getFloat("SOMME")));
            set3.getData().add(new XYChart.Data("2019",resultat5.getFloat("SOMME")));
            set3.getData().add(new XYChart.Data("2020",resultat6.getFloat("SOMME")));
            set3.getData().add(new XYChart.Data("2021",resultat7.getFloat("SOMME")));
            
            annuellesChart.getData().addAll(set3);	
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    } 
    public void produits(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/statistiques.fxml"));
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
