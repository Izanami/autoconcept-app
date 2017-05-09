package tk.ap17.app.autoconcept.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.sql.SQLException;


public class AccueilController extends Controller {
	private Stage primaryStage;
	private String user= "test";

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@FXML
	public Label utilisateurLabel;

	@FXML
	private ImageView deconnexionImageView;

	@FXML
	private Button contactButton;
	
	/**
	 * Initiazlize the accueil controllers.
	 */

	public void initialize() {
	}

	public void disconnect(MouseEvent event) throws Exception, IllegalAccessException, InstantiationException {
		try {
			
			this.getApp().getConnector().close();
			this.getApp().showAuthentification();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void username() {
		try {
			user = this.getApp().getConnector().getUser();
			utilisateurLabel.setText(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contact(ActionEvent event) {
		this.getApp().showContact();
	}
}
