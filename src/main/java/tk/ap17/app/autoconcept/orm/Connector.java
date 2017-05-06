package tk.ap17.app.autoconcept.orm;

import java.sql.*;

public class Connector {
	private String host; // Uniform Resource Identifier
	private String user; // Identifiant utilisateur
	private String password; // Mot de passe
	private String port; // Port de connection
	private Connection connection = null; // A définir
	private static boolean driverLoaded = false; // Etat de chargement du driver

	/**
	 * Constructeurs
	 */

	public Connector() {
		this("localhost");
	}

	public Connector(String host) {
		this(host, "", "");
	}

	public Connector(String host, String user, String password) {
		try {
			Connector.init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

		if (!driverLoaded) {
			throw new IllegalStateException("Cannot instantiate if driver is not loaded. Please call "
					+ getClass().getName() + ".init() method before invoking this constructor.");
		}

		setHost(host);
		setUser(user);
		setPassword(password);
	}

	/**
	 * Méthodes : connexion, execution, deconnexion
	 */

	public void connect() throws SQLException {
		// Connexion a la base de données
		System.out.println("Connexion à la base de données");

		String dBurl = "jdbc:mysql://" + host + "/autoconcept-app";
		connection = DriverManager.getConnection(dBurl, user, password);
	}

	public ResultSet execute(String query) throws SQLException {
		System.out.println("creation et execution de la requête :" + query);
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(query);
	}

	public void close() throws SQLException {
		connection.close();
	}

	/**
	 * A definir
	 *
	 * @return
	 */

	public static boolean isDriverLoaded() {
		return driverLoaded;
	}

	public static void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		if (!driverLoaded) {
			// Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			driverLoaded = true;
		}
	}

	/* Accesseurs à l'attribut host ******************************/
	public String getHost() {
		return host;
	}

	public void setHost(String newHost) {
		host = newHost;
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
