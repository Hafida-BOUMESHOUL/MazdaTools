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

public class ControllerProduits  implements Initializable  {
    @FXML
    private BarChart<?, ?> prod;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void initialize(URL url, ResourceBundle rb) {
       
    	
        XYChart.Series set1 = new XYChart.Series<>();
        
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
    		PreparedStatement statement13;
    		PreparedStatement statement14;
    		PreparedStatement statement15;
    		PreparedStatement statement16;
    		PreparedStatement statement17;
    		PreparedStatement statement18;
    		PreparedStatement statement19;
    		PreparedStatement statement20;
    		
    		statement1 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =1 ");
    		statement2 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =2 ");
    		statement3 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =3 ");
    		statement4 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =4 ");
    		statement5 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =5 ");
    		statement6 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =6 ");
    		statement7 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =7 ");
    		statement8 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =8 ");
    		statement9 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =9 ");
    		statement10 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =10 ");
    		statement11 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =11 ");
    		statement12 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =12 ");
    		statement13	=con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =13 ");
    		statement14 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =14 ");
    		statement15 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =15 ");
    		statement16 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =16 ");
    		statement17 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =17 ");
    		statement18 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =18 ");
    		statement19 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =19 ");
    		statement20 =con.prepareStatement("SELECT SUM(quantity) AS somme FROM order_line WHERE idProduct =20 ");
    		
    		ResultSet resultSet1 = statement1.executeQuery();
    		ResultSet resultSet2 = statement2.executeQuery();
    		ResultSet resultSet3 = statement3.executeQuery();
    		ResultSet resultSet4 = statement4.executeQuery();
    		ResultSet resultSet5 = statement5.executeQuery();
    		ResultSet resultSet6 = statement6.executeQuery();
    		ResultSet resultSet7 = statement7.executeQuery();
    		ResultSet resultSet8 = statement8.executeQuery();
    		ResultSet resultSet9 = statement9.executeQuery();
    		ResultSet resultSet10 = statement10.executeQuery();
    		ResultSet resultSet11 = statement11.executeQuery();
    		ResultSet resultSet12 = statement12.executeQuery();
    		ResultSet resultSet13 = statement13.executeQuery();
    		ResultSet resultSet14 = statement14.executeQuery();
    		ResultSet resultSet15 = statement15.executeQuery();
    		ResultSet resultSet16 = statement16.executeQuery();
    		ResultSet resultSet17 = statement17.executeQuery();
    		ResultSet resultSet18 = statement18.executeQuery();
    		ResultSet resultSet19 = statement19.executeQuery();
    		ResultSet resultSet20 = statement20.executeQuery();
    		
    		resultSet1.next();
    		resultSet2.next();
    		resultSet3.next();
    		resultSet4.next();
    		resultSet5.next();
    		resultSet6.next();
    		resultSet7.next();
    		resultSet8.next();
    		resultSet9.next();
    		resultSet10.next();
    		resultSet11.next();
    		resultSet12.next();
    		resultSet13.next();
    		resultSet14.next();
    		resultSet15.next();
    		resultSet16.next();
    		resultSet17.next();
    		resultSet18.next();
    		resultSet19.next();
    		resultSet20.next();
    		
    		
    		set1.getData().add(new XYChart.Data("produit1",resultSet1.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit2",resultSet2.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit3",resultSet3.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit4",resultSet4.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit5",resultSet5.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit6",resultSet6.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit7",resultSet7.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit8",resultSet8.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit9",resultSet9.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit10",resultSet10.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit11",resultSet11.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit12",resultSet12.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit13",resultSet13.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit14",resultSet14.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit15",resultSet15.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit16",resultSet16.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit17",resultSet17.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit18",resultSet18.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit19",resultSet19.getFloat("somme")));
            set1.getData().add(new XYChart.Data("produit20",resultSet20.getFloat("somme")));
            
    			prod.getData().addAll(set1);
        }catch (SQLException e) {
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
	public void HomeRetour(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}

}
