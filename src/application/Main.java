package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Stage stage;	
	private static Scene mainScene;
	private static Scene interfaceScene;
	
	@Override
	public void start(Stage stage) {
		Main.stage = stage;
		
		try {
			stage.setTitle("Login");
			// Remove buttons from window
			// stage.initStyle(StageStyle.UNDECORATED);

			Parent fxmlInterface = FXMLLoader.load(getClass().getResource("/gui/Interface.fxml"));
			interfaceScene = new Scene(fxmlInterface);
			
			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/gui/Main.fxml"));
			mainScene = new Scene(fxmlMain);
			
			// Disable custom window
			stage.setResizable(false);
			
			// Calling main screen
			stage.setScene(mainScene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Method to change screen
	public static void changeScreen(String src) {
		switch (src) {
			case "main":
				stage.setScene(mainScene);
				stage.setTitle("Login");
				break;
			case "interface":
				stage.setScene(interfaceScene);
				stage.setTitle("BankTCS");
				break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
