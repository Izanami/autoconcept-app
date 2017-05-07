package tk.ap17.app.autoconcept.orm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.orm.query.Query;
import tk.ap17.app.autoconcept.orm.query.QuerySelect;

public class TableTest {
    private Query query;

    @Before
    public void setUp() throws Exception {
        Table table = new Table();
        query = new Query(table);

        table.setNameTable("personne");
    }

    @Test
    public void testQuery() {
         QuerySelect querySelect = query.select("nom,prenom");
         assertEquals("SELECT nom, prenom FROM personne", querySelect.toString());
    }

}
