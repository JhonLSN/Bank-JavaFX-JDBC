package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class InterfaceController implements Initializable {
	
  @FXML
  private Button btnAccount;

  @FXML
  private Button btnExit;

  @FXML
  private Button btnSettings;

  @FXML
  private Button btnTransfer;
  
  @FXML
  private GridPane gpnAccount;

  @FXML
  private GridPane gpnSettings;

  @FXML
  private GridPane gpnTransfer;

  @FXML
  private Label lblStatus;

  @FXML
  private Label lblStatusMini;

  @FXML
  private Pane pnlStatus;
  
  @FXML
  private VBox vbxStatus;
  
  @FXML
  private Label lblLogo;

	@Override
	public void initialize(URL url, ResourceBundle rb) {		
	}
	
	@FXML
	private void handleClicks(ActionEvent event) {
		if (event.getSource() == btnAccount) {	
			lblStatusMini.setText("Home/Account");
			lblStatus.setText("Account");
			pnlStatus.setBackground(new Background(new BackgroundFill(Color.web("#5c0e0e"), CornerRadii.EMPTY, Insets.EMPTY)));
			gpnAccount.toFront();
		} else if (event.getSource() == btnTransfer) {
			lblStatusMini.setText("Home/Transfer");
			lblStatus.setText("Transfer");
			pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43, 63, 99), CornerRadii.EMPTY, Insets.EMPTY)));
			gpnTransfer.toFront();
		} else if (event.getSource() == btnSettings) {
			lblStatusMini.setText("Home/Settings");
			lblStatus.setText("Settings");
			pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43, 99, 63), CornerRadii.EMPTY, Insets.EMPTY)));
			gpnSettings.toFront();
		} else if (event.getSource() == btnExit) {
				Main.changeScreen("main");	
		}
	}
}
