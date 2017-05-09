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
	private ImageView retourImageView;

	@FXML
	private ChoiceBox<String> categorieChoiceBox;

	@FXML
	private Label entrepriseLabel;

	@FXML
	private ChoiceBox<?> entrepriseChoiceBox;

	@FXML
	private TextField whereNomTextField;

	@FXML
	private TextField wherePrenomTextField;

	@FXML
	private TextField whereDdnTextField;

	@FXML
	private Label fsCatLabel;

	@FXML
	private Label fsAdresseLabel;

	@FXML
	private Label fsNomLabel;

	@FXML
	private Label fsPrenomLabel;

	@FXML
	private Label fsDdnLabel;

	@FXML
	private Label fsSexeLabel;

	@FXML
	private Label fsCourrielLabel;

	@FXML
	private Label fsTelephoneLabel;

	@FXML
	private Label fsInscriptionLabel;

	@FXML
	private Button nouveauButton;

	@FXML
	private Button editerButton;

	@FXML
	private Button supprimerButton;


	public void retourAccueil(MouseEvent event) {
		try {
			this.getApp().showAccueil();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void choixCategorie(){
		categorieChoiceBox.getItems().addAll("Tous", "Particuliers", "Professionnels", "Salariés" );
		categorieChoiceBox.setValue("Tous");

		 String choix = getChoice(categorieChoiceBox);
		 boolean nonParticulier = choix.equalsIgnoreCase("Salariés");

		 if(nonParticulier){
			 entrepriseLabel.setVisible(true);
			 entrepriseChoiceBox.setVisible(true);
		 }
	}

	public String getChoice(ChoiceBox<String> categorieChoiceBox) {
		String choix = categorieChoiceBox.getValue();
		return choix;
	}
}
