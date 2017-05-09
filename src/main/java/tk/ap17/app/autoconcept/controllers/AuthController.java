package tk.ap17.app.autoconcept.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.SQLException;
import tk.ap17.app.autoconcept.orm.Mysql;


public class AuthController extends Controller {
	private Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private Label msgErreurLabel;

	@FXML
	private TextField userTextField;

	@FXML
	private PasswordField passwordPasswordField;

	@FXML
	private Button connectButton;

	/**
	 * Initiazlize the auth controllers.
	 */

	public void initialize() {
	}

	@FXML
	protected void connect(ActionEvent event)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {

		Mysql mysql = new Mysql("localhost", userTextField.getText(), passwordPasswordField.getText());
		try {
			connectButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			mysql.connect();
			getApp().setConnector(mysql);
			this.getApp().showAccueil();
		} catch (SQLException e) {
			showFailedConnect();
			passwordPasswordField.setText("");
			connectButton.setContentDisplay(ContentDisplay.TEXT_ONLY);
		}
	}

	private void showFailedConnect() {
		msgErreurLabel.setVisible(true);
	}

	public void hideErrMsg(KeyEvent event) {
		msgErreurLabel.setVisible(false);
	}
}
