package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController implements Initializable {

	@FXML
	private Button btnLogin;
	
	 @FXML
   private Label btnSignUp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void accessAvailable(ActionEvent event) {
		if (event.getSource() == btnLogin) {
			Main.changeScreen("interface");
		}
	}
	
	@FXML
	private void signUp(javafx.scene.input.MouseEvent event) {
		if (event.getSource() == btnSignUp) {
			Main.changeScreen("signUp");
		}
	}
}
