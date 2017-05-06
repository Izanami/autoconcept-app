package tk.ap17.app.autoconcept.orm;

import tk.ap17.app.autoconcept.orm.Connector;

public class Mysql extends Connector {

	public Mysql() throws Exception {
		super();
	}

	public Mysql(String host) throws Exception {
		super(host);
	}

	public Mysql(String host, String user, String password)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(host, user, password);
	}
}
