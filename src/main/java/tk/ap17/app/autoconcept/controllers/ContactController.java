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
	private ChoiceBox<?> categorieChoiceBox;

	@FXML
	private Label EntrepriseLabel;

	@FXML
	private ChoiceBox<?> entrepriseChoiceBox;

	@FXML
	private TextField whereNom;

	@FXML
	private TextField wherePrenom;

	@FXML
	private TextField whereDdn;

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
		 choixCategorie.getItems().addAll("Tous", "Particuliers", "Professionnels", "Salariés" );
		 choixCategorie.setValue("tous");

		 String choix = getChoice(choixCategorie);
		 boolean nonParticulier = choix.equalsIgnoreCase("Salariés");

		 if(nonParticulier){
			 entreprise.setVisible(true);
			 choixEntreprise.setVisible(true);
		 }
	}

	public String getChoice(ChoiceBox<String> choixCategorie) {
		String choix = choixCategorie.getValue();
		return choix;
	}
}

}
