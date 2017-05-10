package tk.ap17.app.autoconcept;

import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import tk.ap17.app.autoconcept.controllers.AccueilController;
import tk.ap17.app.autoconcept.controllers.AuthController;
import tk.ap17.app.autoconcept.controllers.ContactController;
import tk.ap17.app.autoconcept.models.Contacts;
import tk.ap17.app.autoconcept.orm.Connector;

/**
 * Autoconcept
 *
 */
public class App extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private Connector connector;
	private ObservableList<Contacts> contact = FXCollections.observableArrayList();


	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Autoconcept-App");
		initRootLayout();
		showAuthentification();
	}

	public static void main(String[] args) {
		launch(args);
	}
		
	public App() {
		contact.add(new Contacts(connector, "bousquet", "kelian", "25/09/1994"));
		contact.add(new Contacts(connector, "jeser", "adrien", "06/10/1989"));
		contact.add(new Contacts(connector, "devaux", "mathias", "19/09/1977"));
		contact.add(new Contacts(connector, "vistot", "michael", "15/12/1987"));
	}
	
	public ObservableList<Contacts> getContact() {
        return contact;
    }
	
	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showAuthentification() throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("javafx/Authentification.fxml"));

			VBox Authentification = (VBox) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(Authentification);
			primaryStage.setScene(scene);
			primaryStage.show();

			AuthController controller = loader.getController();
			controller.setApp(this);

			// primaryStage.close();
		} catch (Exception e) {
			exceptionDialog(e, "An exception was throw.");
		}
	}

	public void showAccueil() throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("javafx/AccueilAppli.fxml"));

			VBox Accueil = (VBox) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(Accueil);
			primaryStage.setScene(scene);
			primaryStage.show();

			AccueilController controller = loader.getController();
			controller.setApp(this);
			controller.username();
			controller.initialize();

			// primaryStage.close();
		} catch (Exception e) {
			exceptionDialog(e, "An exception was throw.");
		}
	}

	public void showContact() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("javafx/ModuleContact.fxml"));

			VBox Contact = (VBox) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(Contact);
			primaryStage.setScene(scene);
			primaryStage.show();

			ContactController controller = loader.getController();
			controller.setApp(this);
			controller.afficherDonnees(controller.getApp());
			controller.choixCategorie();


		} catch (Exception e) {
			exceptionDialog(e, "An exception was throw.");
		}
	}

	
	/**
	 * Show a expection dialoag
	 *
	 **/
	private void exceptionDialog(Exception exception, String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Dialog");
		alert.setHeaderText("Look, an Exception Dialog");
		alert.setContentText(message);

		// Create expandable Exception.
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		String exceptionText = sw.toString();

		Label label = new Label("The exception stacktrace was:");

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Connector getConnector() {
		return connector;
	}

	public void setConnector(Connector connector) {
		this.connector = connector;
	}
}
