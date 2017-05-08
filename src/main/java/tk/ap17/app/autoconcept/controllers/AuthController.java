package tk.ap17.app.autoconcept.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AuthController {
    @FXML
    private TextField user;

    @FXML
    private TextField password;

    @FXML
    private Button connect_btn;

    /**
     * Initiazlize the auth controllers.
     */
    @FXML private void initialize() {
        //Auth auth = new Auth("http://localhost:3000/", "", "");
        //url.getItems().addAll(auth);
        //url.setValue(auth);

        //auth = new Auth("http://autoconcept.jeser.me/", "", "");
        //url.getItems().addAll(auth);

        //url.setConverter(new StringConverter<Auth>(){
            //@Override
            //public String toString(Auth auth) {
                //return auth == null ? null : auth.getUrl();
            //}

            //@Override
            //public Auth fromString(String string) {
                //return new Auth(string, "", "");
            //}
        //});

        //url.setCellFactory(new Callback<ListView<Auth>, ListCell<Auth>>() {
            //@Override public ListCell<Auth> call(ListView<Auth> p) {
                //return new ListCell<Auth>() {
                    //@Override protected void updateItem(Auth item, boolean empty) {
                        //super.updateItem(item, empty);
                        //if(item != null) {
                            //setText(item.getUrl());
                        //}
                    //}
                //};
            //};
        //});
    }

    @FXML protected void connect(ActionEvent event) {
        showFailedConnect();
    }

    private void showFailedConnect() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Failed connect");
        alert.setHeaderText("Failed to the server.");
        alert.setContentText("Please, verify the url !");

        alert.showAndWait();
    }
}
