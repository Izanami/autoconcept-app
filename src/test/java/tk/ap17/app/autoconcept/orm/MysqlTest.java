package tk.ap17.app.autoconcept.orm;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.models.Contacts;
import tk.ap17.app.autoconcept.models.Partenaires;

public class MysqlTest {
    private Mysql mysql;
    private Contacts contacts;

    @Before
    public void setUp() throws Exception {
        mysql = new Mysql();
        mysql.setUser("root");
        mysql.setPassword("autoconcept");
        mysql.connect();
        contacts = new Contacts(mysql);
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

    /**
     *
     * @throws SQLException Echec de l'execution de la requete
     */
    @Test
    public void testExecute() throws SQLException {
        ResultSet result = mysql.execute("Select * from Contact");
        result.next();
        assertEquals("Luther King", result.getString("nom"));
    }

    @Test
    public void testQuerySelect() throws Exception {
        contacts.select("*").execute(mysql);
        assertEquals("Luther King", contacts.getField("nom"));
    }

    @Test
    public void testQueryBelongs() throws Exception {
        Partenaires partenaires = new Partenaires(mysql);
        partenaires.select("*").execute(mysql);
        assertEquals("Luther King", partenaires.contact().getField("nom"));
    }
}
