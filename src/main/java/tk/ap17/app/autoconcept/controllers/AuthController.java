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
	private Label msgErreur;

	@FXML
	private TextField user;

	@FXML
	private PasswordField password;

	@FXML
	private Button connect_btn;

	/**
	 * Initiazlize the auth controllers.
	 */

	public void initialize() {
	}

	@FXML
	protected void connect(ActionEvent event)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {

		Mysql mysql = new Mysql("localhost", user.getText(), password.getText());
		try {
			connect_btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			mysql.connect();
			getApp().setConnector(mysql);
			this.getApp().showAccueil();
		} catch (SQLException e) {
			showFailedConnect();
			password.setText("");
			connect_btn.setContentDisplay(ContentDisplay.TEXT_ONLY);
		}
	}

	private void showFailedConnect() {
		msgErreur.setVisible(true);
	}

	public void hideErrMsg(KeyEvent event) {
		msgErreur.setVisible(false);
	}
}
