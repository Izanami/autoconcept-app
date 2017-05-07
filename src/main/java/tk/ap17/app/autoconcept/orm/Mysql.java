package tk.ap17.app.autoconcept.orm;

import tk.ap17.app.autoconcept.orm.Connector;

public class Mysql extends Connector {

	public Mysql() throws Exception {
		super();
	}

	public Mysql(String host) throws Exception {
		super(host);
	}

	public Mysql(String host, String user, String password) throws Exception {
		super(host, user, password);
	}

	public Mysql(String host, String user, String password, String port)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(host, user, password, port);
	}
	
	public static Mysql InstanceForTest() throws Exception{
		return new Mysql("localhost","root","autoconcept");
	}
}
