package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private AnchorPane mainpage;
	private Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	private void initializeMainpage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			
			// Load the main page from the FXML file
			loader.setLocation(Main.class.getResource("/view/Mainpage.fxml"));
			
			mainpage = (AnchorPane) loader.load();
			
			// Create a new scene using the main page
			Scene scene = new Scene(mainpage);
			window.setScene(scene);
			
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setTitle("Shunting-yard algorithm");
		
		initializeMainpage();
	}
}