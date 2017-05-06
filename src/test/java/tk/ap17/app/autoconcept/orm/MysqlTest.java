package tk.ap17.app.autoconcept.orm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MysqlTest {
	private Connector connector;

	@Before
	public void setUp() throws Exception {
		connector = new Connector();
	}

	@Test
	public void testMysql() {
		connector.setHost("localhost:8080");
		assertEquals("localhost:8080", connector.getHost());
	}

	@Test
	public void testMysqlString() {

	}

	@Test
	public void testMysqlStringStringString() {

	}

}
