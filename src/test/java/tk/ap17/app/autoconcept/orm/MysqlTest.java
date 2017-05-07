package tk.ap17.app.autoconcept.orm;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MysqlTest {
<<<<<<< HEAD
	private Mysql mysql;

	@Before
	public void setUp() throws Exception {
		mysql = Mysql.InstanceForTest();
		mysql.connect();
	}

	@After
	public void setDown() throws Exception {
		mysql.close();
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
	public void testExecute() throws SQLException {
		ResultSet result = mysql.execute("Select * from personne");
		result.next();
		assertEquals("Luther King", result.getString(1));

	}

=======
    private Mysql mysql;

    @Before
    public void setUp() throws Exception {
        mysql = new Mysql();
        mysql.setUser("root");
        mysql.setPassword("autoconcept");
        mysql.connect();
    }

    @After
    public void setDown() throws Exception {
        mysql.close();
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
    public void testExecute() throws SQLException {
        ResultSet result = mysql.execute("Select * from personne");
        result.next();
        assertEquals("Luther King", result.getString(1));
    }
>>>>>>> review
}
