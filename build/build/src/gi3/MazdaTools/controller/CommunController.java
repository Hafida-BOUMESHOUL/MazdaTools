package gi3.MazdaTools.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommunController {

	public void HomeRetour(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
		 Stage  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
}
