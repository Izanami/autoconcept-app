package tk.ap17.app.autoconcept.orm;

import java.sql.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import tk.ap17.app.autoconcept.AutoconceptLogger;

/**
 * Enveloppe un driver sql.
 *
 * La methode close() DOIT etre appelle des que la connection n'est plus
 * necessaire
 *
 * <br>
 * <br>
 * Parametre de connexion par defaut :
 * <ul>
 *  <li>Adresse vers le serveur : "localhost"</li>
 *  <li>Utilisateur : ""</li>
 *  <li>Mot de passe : ""</li>
 *  <li>Port : "3306"</li>
 * </ul>
 *
 * <br>
 * <br>
 * Example :
 * <pre>{@code
 *  MySql connector = new Connector("example.org", "eclair",
 * "buzz"); connector.connect()
 *
 * Partenaire partenaire = new Partenaire();
 * partenaire.query().select("*").execute(connector);
 *
 * connector.close();
 * }
 * </pre>
 *
 * Supporte :
 * <ul>
 *  <li>Mysql</li>
 * </ul>
 *
 * @author Kelian Bousquet
 * @author Mathias Devaux
 * @author Adrien Jeser : adrien@jeser.me
 * @version 0.1
 * @see Mysql
 */
public abstract class Connector {
    /**
     * Session vers le serveur
     */
    private Connection connection = null;

    /**
     * logging
     */
    private static Logger logger = Logger.getLogger(AutoconceptLogger.class.getName());

    /**
     * Adresse vers le serveur
     */
    private String host;

    /**
     * Nom de utilisateur, pour l'authentification
     */
    private String user;

    /**
     * Mot de passe
     */
    private String password;

    /**
     * Port de connexion
     */
    private String port;

    /**
     * Vrai, si le driver est charge
     */
    protected static boolean driverLoaded = false;

    /**
     * Liste des tables
     */
    private List<Table> tables = new ArrayList<>();

    /**
     * Systeme de gestion de base de donnees
     */
    private String sgdb;

    /**
     * {@inheritDoc}
     *
     * Constructeur par defaut.
     *
     */
    public Connector() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this("localhost");
    }

    /**
     * Constructeur.
     *
     * @param host
     *            Adresse vers le serveur.
     * @throws InstantiationException Impossible de charger le driver.
     * @throws IllegalAccessException Impossible de charger le driver.
     * @throws ClassNotFoundException Impossible de charger le driver.
     */
    public Connector(String host) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this(host, "", "");
    }

    /**
     * Constructeur.
     *
     * @param host
     *            Adresse vers le serveur.
     * @param user
     *            Utilisateur.
     * @param password
     *            Mot de passe.
     * @throws InstantiationException Impossible de charger le driver.
     * @throws IllegalAccessException Impossible de charger le driver.
     * @throws ClassNotFoundException Impossible de charger le driver.
     */
    public Connector(String host, String user, String password) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this(host, user, password, "3306");
    }

    /**
     * Contructeur.
     *
     * @param host Adresse vers le serveur.
     * @param user Utilisateur.
     * @param password Mot de passe.
     * @param port Port.
     *
     * @throws ClassNotFoundException Impossible de charger le driver.
     * @throws IllegalAccessException Impossible de charger le driver.
     * @throws InstantiationException Impossible de charger le driver.
     */
    public Connector(String host, String user, String password, String port)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        setHost(host);
        setUser(user);
        setPassword(password);
        setPort(port);
    }

    /**
     * Connexion au serveur.
     *
     * L'adresse vers le serveur, l'utilisateur et mot de passe DOIVENT etre defini au prealable.
     *
     * @throws SQLException Impossible d'établir la connexion au serveur.
     */
    public void connect() throws SQLException {
        logger.info("Connexion à la base de données");

        String dBurl = "jdbc:" + getSgdb() + "://" + getHost() + "/autoconcept-app";
        connection = DriverManager.getConnection(dBurl, getUser(), getPassword());
    }

    /**
     * Execute une requete SQL.
     *
     * La connexion DOIT etre etablie au prealable, avec connect().
     *
     * @param query Requete.
     * @return Result de la requete.
     *
     * @throws SQLException Impossible d'execute la requete.
     */
    public ResultSet execute(String query) throws SQLException {
        logger.info("Execution de la requête :" + query);
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    /**
     * Ferme la connexion.
     *
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public void close() throws SQLException {
        connection.close();
    }

    /**
     * @return Revoie vrai, si le driver est charge.
     */
    public static boolean isDriverLoaded() {
        return driverLoaded;
    }


    /**
     * Pour chaque table, execute une function.
     *
     * Example :
     * <pre>
     * {@code
     * Table table = new Table();
     * table.setNameTable("fum");
     *
     * connector.forEachTable((table) -> {System.out.println(table.getNameTable());})
     * }
     * </pre>
     *
     *
     *
     * @param lambda Lambda
     */
    public void forEachTable(Function<Table, Boolean> lambda) {
        for (Table table : tables) {
            lambda.apply(table);
        }
    }

    /**
     * @return Adresse vers serveur.
     */
    public String getHost() {
        return host;
    }

    /**
     * @param newHost Nouvelle adresse vers le serveur.
     */
    public void setHost(String newHost) {
        host = newHost;
    }

    /**
     * @return Le nom de l'utilisateur.
     */
    public String getUser() {
        return user;
    }

    /**
     * @param newUser Nouveau nom d'utilisateur.
     */
    public void setUser(String newUser) {
        user = newUser;
    }

    /**
     * @return Le mot de passe.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param newPassword Nouveau mot de passe.
     */
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    /**
     * @return Le port.
     */
    public String getPort() {
        return port;
    }

    /**
     *
     *
     * @param newPort Nouveau port.
     */
    public void setPort(String newPort) {
        port = newPort;
    }

    /**
     * @return the sgdb
     */
    protected String getSgdb() {
        return sgdb;
    }

    /**
     * @param sgdb the sgdb to set
     */
    protected void setSgdb(String sgdb) {
        this.sgdb = sgdb;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
    	return this.connection;
    }
}
