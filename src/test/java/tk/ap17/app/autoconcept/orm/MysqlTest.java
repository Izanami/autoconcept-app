package tk.ap17.app.autoconcept.orm;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MysqlTest {
    private Mysql mysql;

    @Before
    public void setUp() throws Exception {
        mysql = new Mysql();
        mysql.setUser("root");
        mysql.setPassword("autoconcept");
    }

    @After
    public void setDown() throws Exception {
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
     * Test l'execution.
     *
     * <br>
     * Parametre :
     *  <ul>
     *      <li>Adressse : localhost</li>
     *      <li>Utilisateur :  root</li>
     *      <li>Mot de passe : autoconcept</li>
     *  </ul>
     *
     *  Préparer le serveur :
     *  <br>
     * CREATE DATABASE IF NOT EXISTS autoconcept-app;
     *
     * CREATE TABLE `personne` IF NOT EXISTS (
     * `nom` text NOT NULL
     * );
     *
     * INSERT INTO `personne` (`nom`) VALUES
     * ('Luther King');
     *
     * @throws SQLException Echec de l'execution de la requete
     */
    //@Test
    //public void testExecute() throws SQLException {
        //mysql.connect();

        //ResultSet result = mysql.execute("Select * from personne");
        //result.next();
        //assertEquals("Luther King", result.getString("nom"));

        //mysql.close();
    //}
}
