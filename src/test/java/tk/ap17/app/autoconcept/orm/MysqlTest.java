package tk.ap17.app.autoconcept.orm;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class MysqlTest {
	private Mysql mysql;

	@Before
	public void setUp() throws Exception {
		mysql = new Mysql();
	}

	@Test
	public void testMysql() throws Exception {
		new Mysql();
	}

	@Test
	public void testMysqlString() throws Exception {
		Mysql connector = new Mysql("localhost");
		assertEquals("localhost", connector.getHost());
	}

	@Test
	public void testMysqlStringStringString() throws Exception {
		Mysql connector = new Mysql("localhost", "root", "autoconcept");
		assertEquals("localhost", connector.getHost());
		assertEquals("root", connector.getUser());
		assertEquals("autoconcept", connector.getPassword());
	}

	@Test
	public void testMysqlStringStringStringString() throws Exception {
		Mysql connector = new Mysql("localhost", "root", "autoconcept", "3306");
		assertEquals("localhost", connector.getHost());
		assertEquals("root", connector.getUser());
		assertEquals("autoconcept", connector.getPassword());
		assertEquals("3306", connector.getPort());
	}

	@Test
	public void testConnect() throws SQLException {
		mysql.setUser("root");
		mysql.setPassword("autoconcept");
		mysql.connect();
		mysql.close();
	}

}
