package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainController implements Initializable {

	@FXML
	private Button btnLogin;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void accessAvailable(ActionEvent event) {
		if (event.getSource() == btnLogin) {
			Main.changeScreen("interface");
		}
	}
}
