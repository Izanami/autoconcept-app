package tk.ap17.app.autoconcept.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ContactController extends Controller {
	private Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private ImageView retour;


	public void retourAccueil(MouseEvent event) {
		try {
			this.getApp().showAccueil();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}