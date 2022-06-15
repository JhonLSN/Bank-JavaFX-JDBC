package gui;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class SignUpController implements Initializable {
	
	@FXML
  private Button btnBack;

  @FXML
  private Button btnFinish;
  
  @FXML
  private PasswordField inputConfirmPassword;

  @FXML
  private TextField inputCpf;

  @FXML
  private TextField inputDay;

  @FXML
  private TextField inputEmail;

  @FXML
  private TextField inputFullName;

  @FXML
  private TextField inputMonth;

  @FXML
  private PasswordField inputPassword;

  @FXML
  private TextField inputYear;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
	}
	
	@FXML
	private void finish(ActionEvent event) {						
		if (event.getSource() == btnFinish) {			
			Calendar calendar = Calendar.getInstance();
			
			// requiredFields
			if (inputFullName.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Enter your full name", AlertType.ERROR);
				return;
			}
			
			if (inputEmail.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Inform your email", AlertType.ERROR);
				return;
			}
			
			if (inputCpf.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Inform your cpf", AlertType.ERROR);
				return;
			}
			
			if (inputDay.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Enter your birthday", AlertType.ERROR);
				return;
			}
			
			if (inputMonth.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Enter the month of your birthday", AlertType.ERROR);
				return;
			}
			
			if (inputYear.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Enter the year of your birthday", AlertType.ERROR);
				return;
			}
			
			if (inputPassword.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Inform your password", AlertType.ERROR);
				return;
			}
			
			if (inputConfirmPassword.getText().equals("")) {
				Alerts.showAlert("Required field", null, "Confirm your password", AlertType.ERROR);
				return;
			}
			
			if (!inputConfirmPassword.getText().equals(inputPassword.getText())) {
				Alerts.showAlert("Required field", null, "Passwords don't match", AlertType.ERROR);
				return;
			}
			
			if (calendar.get(Calendar.YEAR) - Integer.parseInt(inputYear.getText()) < 18) {
				Alerts.showAlert("You cannot register", null, "You are not of legal age", AlertType.ERROR);
				return;
			}				
			
			// Registering at the bank
			UserDao userDao = DaoFactory.createUserDao();			
			User user = new User();			
			String date = inputDay.getText() + "/" + inputMonth.getText() + "/" + inputYear.getText();
			
			user.setName(inputFullName.getText());
			user.setEmail(inputEmail.getText());
			user.setCpf(inputCpf.getText());
			user.setBirthDate(date);
			user.setPassword(inputPassword.getText());			
			userDao.insert(user);			
			System.out.println("User created");
			
			// Clearing the fields
			Alerts.showAlert("Registered user", null, "User registered successfully!", AlertType.INFORMATION);
			inputFullName.setText("");
			inputEmail.setText("");
			inputCpf.setText("");
			inputDay.setText("");
			inputMonth.setText("");
			inputYear.setText("");
			inputPassword.setText("");
			inputConfirmPassword.setText("");
			
		}
	}
	
	@FXML
	private void back(ActionEvent event) {		
		if (event.getSource() == btnBack) {
			Main.changeScreen("main");
		}
	}
}
