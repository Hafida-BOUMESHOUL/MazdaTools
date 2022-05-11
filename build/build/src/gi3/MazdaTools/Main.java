	package gi3.MazdaTools;
	
	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.stage.Stage;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.image.Image;
	
	
	public class Main extends Application {
		
		
		@Override
		public void start(Stage primaryStage) {
			try {
				Parent root =FXMLLoader.load(Main.class.getResource("view/Login.fxml"));
				Scene scene = new Scene(root);
				//root.getStylesheets().add(getClass().getResource("MazdaTools/view/Styles(interface1).css").toString());
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				primaryStage.show();
				primaryStage.setTitle("MazDa TooLs");
				primaryStage.getIcons().add(new Image("file:src/gi3/MazdaTools/view/Ressources/App_Icon/icon.png"));
	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		public static void main(String[] args) {
			launch(args);
			
		}
	
	}