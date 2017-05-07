package tk.ap17.app.autoconcept.orm;

import tk.ap17.app.autoconcept.orm.Connector;

/**
 * Enveloppe le driver MySql.
 *
 * @author Adrien Jeser : adrien@jeser.me
 * @version 0.1
 * @see Connector
 */
public class Mysql extends Connector {
    /**
     * Contructeur par defaut
     *
     * @see Connector#Mysql()
     */
    public Mysql() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super();
        init();
    }

    /**
     * {@inheritDoc}
     *
     * @see Connector#Mysql(String)
     */
    public Mysql(String host) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(host);
        init();
    }

    /**
     * {@inheritDoc}
     *
     * @see Connector#Mysql(String,String,String)
     */
    public Mysql(String host, String user, String password) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(host, user, password);
        init();
    }

    /**
     * {@inheritDoc}
     *
     * @see Connector#Mysql(String,String,String,String)
     */
    public Mysql(String host, String user, String password, String port)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(host, user, password, port);
        init();
    }

    /**
     *
     * Charge le driver MySql
     *
     * @throws ClassNotFoundException Impossible de charger le driver
     * @throws IllegalAccessException Impossible de charger le driver
     * @throws InstantiationException Impossible de charger le driver
     */
    private void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        setSgdb("mysql");

        if (!driverLoaded) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            driverLoaded = true;
        }
    }
}
