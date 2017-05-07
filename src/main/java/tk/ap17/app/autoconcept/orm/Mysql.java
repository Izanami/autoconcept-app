package tk.ap17.app.autoconcept.orm;

import tk.ap17.app.autoconcept.orm.Connector;

public class Mysql extends Connector {

	public Mysql() throws Exception {
		super();
        setSgdb("mysql");
	}

	public Mysql(String host) throws Exception {
		super(host);
        setSgdb("mysql");
	}

	public Mysql(String host, String user, String password) throws Exception {
		super(host, user, password);
        setSgdb("mysql");
	}

	public Mysql(String host, String user, String password, String port)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(host, user, password, port);
        setSgdb("mysql");
	}


    private void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (!driverLoaded) {
            // Chargement du pilote
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            driverLoaded = true;
        }
    }
}
