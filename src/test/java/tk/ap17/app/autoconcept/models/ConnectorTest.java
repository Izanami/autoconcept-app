package tk.ap17.app.autoconcept.models;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.orm.Connector;

public class ConnectorTest {
	private Connector connector;

	@Before
	public void setUp() throws Exception {
		connector = new Connector();
	}

	@Test
	public void testGetHost() {
		connector.setHost("localhost:8080");
		assertEquals("localhost:8080", connector.getHost());
	}
	
	@Test
	public void testConnect() throws SQLException {
		connector.setHost("localhost:8080");
		connector.setUser("root");
		connector.setPassword("autoconcept");
		connector.connect();
	}

}
