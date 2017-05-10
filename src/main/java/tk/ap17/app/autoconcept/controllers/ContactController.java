package tk.ap17.app.autoconcept.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import tk.ap17.app.autoconcept.models.Contacts;
import tk.ap17.app.autoconcept.*;
import tk.ap17.app.autoconcept.exceptions.ExceptionOrm;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

public class ContactController extends Controller {
	private Stage primaryStage;
	private String Tous="Tous", Particuliers="Particuliers", Professionnels="Professionnels", Salaries="Salaries";

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

	@FXML
	private TableView<Contacts> contactTable;

	@FXML
	private TableColumn<Contacts, String> nomColonne;

	@FXML
	private TableColumn<Contacts, String> prenomColonne;

	@FXML
	private TableColumn<Contacts, String> ddnColonne;

	private App App;

	@FXML
	public void initialize() {
		// Initialize the person table with the two columns.
		nomColonne.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		prenomColonne.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
		ddnColonne.setCellValueFactory(cellData -> cellData.getValue().dateDeNaissanceProperty());
	}

	public void afficherDonnees(App App) {
		this.App = App;
		contactTable.setItems(App.getContact());
	}

	public void choixCategorie() throws SQLException, ExceptionOrm {
		categorieChoiceBox.getItems().addAll(Tous, Particuliers, Professionnels, Salaries);
		categorieChoiceBox.setValue("Tous");

		String choix = getChoice(categorieChoiceBox);
		boolean Particulier = choix.equalsIgnoreCase(Particuliers);

		if (!Particulier) {
			entrepriseLabel.setVisible(true);
			entrepriseChoiceBox.setVisible(true);
		}
	}

	public void retourAccueil(MouseEvent event) {
		try {
			this.getApp().showAccueil();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getChoice(ChoiceBox<String> categorieChoiceBox) {
		String choix = categorieChoiceBox.getValue();
		return choix;
	}

}
