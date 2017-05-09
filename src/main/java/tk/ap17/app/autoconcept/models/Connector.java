package tk.ap17.app.autoconcept.models;

import java.nio.file.Path;
import java.sql.*;

public class Connector {
    private String uri; // Uniform Resource Identifier
    private String user; // Identifiant utilisateur
    private String password; // Mot de passe
    private String port; // Port de connection

    /**
     * Constructeurs
     */
    public Connector() {

    }

    public Connector(String uri) {

    }

    public Connector(String uri, String user, String password) {

    }

    public Connector(Path uri) {

    }

    public Connector(Path uri, String user, String password) {

    }

    /**
     * Méthodes : connexion, execution, deconnexion
     */

    public void connect() {

    }

    public void execute(String query) {

    }

    public void close() {

    }

    /* Accesseurs à l'attribut uri ******************************/
    public String getUri() {
        return uri;
    }

    public void setUri(String newUri) {
        uri = newUri;
    }

    /* Accesseurs à l'attribut user *****************************/
    public String getUser() {
        return user;
    }

    public void setUser(String newUser) {
        user = newUser;
    }

    /* Accesseurs à l'attribut password *************************/
    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    /* Accesseurs à l'attribut port *****************************/
    public String getPort() {
        return port;
    }

    public void setPort(String newPort) {
        port = newPort;
    }

}
