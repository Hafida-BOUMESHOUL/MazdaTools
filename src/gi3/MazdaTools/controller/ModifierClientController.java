package gi3.MazdaTools.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ModifierClientController implements Initializable {
	
	@FXML private Label name;
    @FXML private Label gender;
    @FXML private Label phone;
    @FXML private Label mail;
    
    public void afficher ()
    {
    	name.setText(ChercherClientController.getNameClient());
    	gender.setText(ChercherClientController.getSexeClient());
    	phone.setText(ChercherClientController.getNumClient());
    	mail.setText(ChercherClientController.getEmailClient());
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
		afficher();
		
	}
    

}
