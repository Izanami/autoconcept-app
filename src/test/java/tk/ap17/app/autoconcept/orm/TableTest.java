package tk.ap17.app.autoconcept.orm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.exceptions.ExceptionOrm;
import tk.ap17.app.autoconcept.orm.query.QuerySelect;

public class TableTest {
    private Table table;

    @Before
    public void setUp() {
        this.table = new Table();
        table.addColumn("nom");
        table.addColumn("prenom");
        table.setNameTable("personne");
    }

    @Test
    public void testQuery() throws ExceptionOrm {
         QuerySelect querySelect = table.select("nom,prenom");
         assertEquals("SELECT nom, prenom FROM personne", querySelect.prepare());
    }
}
