package tk.ap17.app.autoconcept.orm.query;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import tk.ap17.app.autoconcept.orm.Table;

public class QueryTest {
    private Query query;

    @Before
    public void setUp() throws Exception {
        Table table = new Table();
        table.setNameTable("personne");
        query = new Query(table);
    }

    @Test
    public void testSelect() {
        assertEquals("SELECT nom, prenom FROM personne", query.select("nom,prenom").toString());
    }
}
