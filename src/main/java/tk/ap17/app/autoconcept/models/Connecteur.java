package tk.ap17.app.autoconcept.models;

public class Connecteur {
    private String uri; // Uniform Resource Identifier
    private String user; // Identifiant utilisateur
    private String password; // Mot de passe
    private String port; // Port de connection

    /**
     * Retourne l'identifiant de la ressource sur le r�seau
     *
     * @return uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * D�finit le nouvel identifiant de la ressource sur le r�seau
     *
     * @param newUri
     */
    public void setUri(String newUri) {
        uri = newUri;
    }

    /**
     * Retourne le nom de l'utilisateur
     *
     * @return nom de l'utilisateur
     */
    public String getUser() {
        return user;
    }

    /**
     * D�finit le nouveau nom de l'utilisateur
     *
     * @param newUser
     */
    public void setUser(String newUser) {
        user = newUser;
    }

    /**
     * Retourne le mot de passe
     *
     * @return mot de passe
     */
    public String getPassword() {
        return password;
    }

    /**
     * D�finit le nouveau mot de passe
     *
     * @param newPassword
     */
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    /**
     * Retourne le num�ro (String) de port
     *
     * @return port
     */
    public String getPort() {
        return port;
    }

    /**
     * D�finit le nouveau port
     *
     * @param newPort
     */
    public void setPort(String newPort) {
        port = newPort;
    }
}
