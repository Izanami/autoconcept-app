package tk.ap17.app.autoconcept.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	
	@FXML
	private ChoiceBox<?> choixCategorie;
	
	@FXML
	private Label entreprise;
	
	@FXML
	private ChoiceBox<?> choixEntreprise;
	
	@FXML
	private TextField whereNom;
	
	@FXML
	private TextField wherePrenom;
	
	@FXML
	private TextField whereDdn;
	
	@FXML
	private Label fsCat;
	
	@FXML
	private Label fsAdresse;
	
	@FXML
	private Label fsNom;
	
	@FXML
	private Label fsPrenom;
	
	@FXML
	private Label fsDdn;
	
	@FXML
	private Label fsSexe;
	
	@FXML
	private Label fsCourriel;
	
	@FXML
	private Label fsTelephone;
	
	@FXML
	private Label fsInscription;
	
	@FXML
	private Button nouveau;
	
	@FXML
	private Button editer;
	
	@FXML
	private Button supprimer;
	

	public void retourAccueil(MouseEvent event) {
		try {
			this.getApp().showAccueil();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}