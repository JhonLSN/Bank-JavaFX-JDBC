package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class MainController implements Initializable {

	@FXML
	private Button btnLogin;
	
	 @FXML
   private Label btnSignUp;
	 
   @FXML
   private TextField inputEmail;

   @FXML
   private PasswordField inputPassword;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void accessAvailable(ActionEvent event) {
		if (event.getSource() == btnLogin) {
			
			// requiredFields
			if (inputEmail.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Inform your email", AlertType.ERROR);
				return;
			}
			
			if (inputPassword.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Inform your password", AlertType.ERROR);
				return;
			}
			
			// Compare data with database
			UserDao userDao = DaoFactory.createUserDao();
			User user = new User();
			
			user = userDao.getLogin(inputEmail.getText(), inputPassword.getText());
		}
	}
	
	@FXML
	private void signUp(javafx.scene.input.MouseEvent event) {
		if (event.getSource() == btnSignUp) {
			Main.changeScreen("signUp");
		}
	}
}
