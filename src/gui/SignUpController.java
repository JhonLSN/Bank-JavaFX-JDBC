package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class SignUpController implements Initializable {
	
	@FXML
  private Button btnBack;

  @FXML
  private Button btnFinish;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
	}
	
	@FXML
	private void finish(ActionEvent event) {		
		if (event.getSource() == btnFinish) {
			Main.changeScreen("main");
		}
	}
	
	@FXML
	private void back(ActionEvent event) {		
		if (event.getSource() == btnBack) {
			Main.changeScreen("main");
		}
	}
}
