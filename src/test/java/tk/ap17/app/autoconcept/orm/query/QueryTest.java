package tk.ap17.app.autoconcept.orm.query;

import static org.junit.Assert.*;

import java.sql.JDBCType;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.exceptions.ExceptionOrm;
import tk.ap17.app.autoconcept.orm.Table;

public class QueryTest {
    private Query query;

    @Before
    public void setUp() throws Exception {
        Table table = new Table();
        table.addColumn("nom");
        table.addColumn("prenom");

        table.setNameTable("personne");
        query = new Query(table);
    }

    @Test
    public void testSelect() throws ExceptionOrm {
        assertEquals("SELECT nom, prenom FROM personne", query.select("nom,prenom").prepare());
    }
}
