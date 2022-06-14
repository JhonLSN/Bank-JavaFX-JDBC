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
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
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
  private Button btnUpdateTable;
  
  @FXML
  private GridPane gpnAccount;

  @FXML
  private GridPane gpnSettings;

  @FXML
  private GridPane gpnTransfer;
  
  @FXML
  private ImageView imgCardBadai;
  
  @FXML
  private Label lblDateValid;

  @FXML
  private Label lblNameCard;

  @FXML
  private Label lblNumberCard;

  @FXML
  private Label lblStatus;

  @FXML
  private Label lblStatusMini;

  @FXML
  private Pane pnlStatus;
  
  @FXML
  private Pane pnlBalance;

  @FXML
  private Pane pnlCardBadai;
  
  @FXML
  private Pane pnlSettings;
  
  @FXML
  private Pane pnlTransfer;
  
  @FXML
  private VBox vbxStatus;
  
  @FXML
  private Label lblLogo;
  
  @FXML
  private TableView<?> tblExtract;

	@Override
	public void initialize(URL url, ResourceBundle rb) {		
	}
	
	@FXML
	private void handleClicks(ActionEvent event) {
		if (event.getSource() == btnAccount) {	
			lblStatusMini.setText("Home/Account");
			lblStatus.setText("Account");
			pnlStatus.setBackground(new Background(new BackgroundFill(Color.web("3fb0cc"), CornerRadii.EMPTY, Insets.EMPTY)));
			showElementsAccount();
			hideElementsTransfer();
			hideElementsSettings();
		} else if (event.getSource() == btnTransfer) {
			lblStatusMini.setText("Home/Transfer");
			lblStatus.setText("Transfer");
			pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43, 63, 99), CornerRadii.EMPTY, Insets.EMPTY)));
			showElementsTransfer();
			hideElementsAccount();	
			hideElementsSettings();
		} else if (event.getSource() == btnSettings) {
			lblStatusMini.setText("Home/Settings");
			lblStatus.setText("Settings");
			pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(57, 96, 165), CornerRadii.EMPTY, Insets.EMPTY)));
			showElementsSettings();
			hideElementsAccount();
			hideElementsTransfer();
		} else if (event.getSource() == btnExit) {
				Main.changeScreen("main");	
		}
	}
	
	private void hideElementsAccount() {
		pnlCardBadai.setDisable(true);
		pnlCardBadai.setOpacity(0);	
		pnlBalance.setDisable(true);
		pnlBalance.setOpacity(0);	
		tblExtract.setDisable(true);
		tblExtract.setOpacity(0);		
		btnUpdateTable.setDisable(true);
		btnUpdateTable.setOpacity(0);	
	}
	
	private void showElementsAccount() {
		pnlCardBadai.setDisable(false);
		pnlCardBadai.setOpacity(1);	
		pnlBalance.setDisable(false);
		pnlBalance.setOpacity(1);	
		tblExtract.setDisable(false);
		tblExtract.setOpacity(1);		
		btnUpdateTable.setDisable(false);
		btnUpdateTable.setOpacity(1);	
	}
	
	private void hideElementsTransfer() {
		pnlTransfer.setDisable(true);
		pnlTransfer.setOpacity(0);
	}
	
	private void showElementsTransfer() {
		pnlTransfer.setDisable(false);
		pnlTransfer.setOpacity(1);
	}
	
	private void hideElementsSettings() {
		pnlSettings.setDisable(true);
		pnlSettings.setOpacity(0);
	}
	
	private void showElementsSettings() {
		pnlSettings.setDisable(false);
		pnlSettings.setOpacity(1);
	}
}
