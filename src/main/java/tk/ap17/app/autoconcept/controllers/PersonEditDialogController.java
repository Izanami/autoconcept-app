package tk.ap17.app.autoconcept.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tk.ap17.app.autoconcept.models.Contacts;


/**
 * Dialog to edit details of a person.
 *
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField prenomField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField adresseField;
    @FXML
    private TextField codePostalField;
    @FXML
    private TextField villeField;
    @FXML
    private TextField ddnField;
    @FXML
    private TextField sexeField;
    @FXML
    private TextField courrielField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField inscriptionField;
    @FXML
    private TextField professionnelField;
    


    private Stage dialogStage;
    private Contacts contact;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Contacts contact) {
        this.contact = contact;

        professionnelField.setText(contact.getProfessionnel());
        adresseField.setText(contact.getAdresse());
        villeField.setText(contact.getVille());
        codePostalField.setText(Integer.toString(contact.getCodePostal()));
        nomField.setText(contact.getNom());
        prenomField.setText(contact.getPrenom());
        ddnField.setText(contact.getDateDeNaissance());
  //    ddnField.setPromptText("dd.mm.yyyy");
        sexeField.setText(Integer.toString(contact.getSexe()));
        courrielField.setText(contact.getCourriel());
        telephoneField.setText(contact.getTelephone());
        inscriptionField.setText(contact.getAnciennete());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
//    @FXML
//    private void handleOk() {
//        if (isInputValid()) {
//            person.setFirstName(firstNameField.getText());
//            person.setLastName(lastNameField.getText());
//            person.setStreet(streetField.getText());
//            person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
//            person.setCity(cityField.getText());
//            person.setBirthday(DateUtil.parse(birthdayField.getText()));
//
//            okClicked = true;
//            dialogStage.close();
//        }
//    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
//    private boolean isInputValid() {
//        String errorMessage = "";
//
//        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
//            errorMessage += "No valid first name!\n";
//        }
//        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
//            errorMessage += "No valid last name!\n";
//        }
//        if (streetField.getText() == null || streetField.getText().length() == 0) {
//            errorMessage += "No valid street!\n";
//        }
//
//        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
//            errorMessage += "No valid postal code!\n";
//        } else {
//            // try to parse the postal code into an int.
//            try {
//                Integer.parseInt(postalCodeField.getText());
//            } catch (NumberFormatException e) {
//                errorMessage += "No valid postal code (must be an integer)!\n";
//            }
//        }
//
//        if (cityField.getText() == null || cityField.getText().length() == 0) {
//            errorMessage += "No valid city!\n";
//        }
//
//        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
//            errorMessage += "No valid birthday!\n";
//        } else {
//            if (!DateUtil.validDate(birthdayField.getText())) {
//                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
//            }
//        }
//
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            // Show the error message.
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.initOwner(dialogStage);
//            alert.setTitle("Invalid Fields");
//            alert.setHeaderText("Please correct invalid fields");
//            alert.setContentText(errorMessage);
//
//            alert.showAndWait();
//
//            return false;
//        }
}

