package tk.ap17.app.autoconcept.models;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.orm.Mysql;
import tk.ap17.app.autoconcept.models.Partenaire;
import tk.ap17.app.autoconcept.models.Partenaires;

public class PartenaireTest {
    private Mysql mysql;

    @Before
    public void setUp() throws Exception {
        mysql = new Mysql();
        mysql.setUser("root");
        mysql.setPassword("autoconcept");
    }

    @Test
    public void testExecute() throws Exception {
        mysql.connect();

        Partenaires partenaires = new Partenaires();
        ResultSet result = partenaires.query().select("*").execute(mysql);
        result.next();

        Partenaire partenaire = new Partenaire(mysql, result);
        assertEquals("Jeser", partenaire.contact().getName());

        mysql.close();
    }
}
