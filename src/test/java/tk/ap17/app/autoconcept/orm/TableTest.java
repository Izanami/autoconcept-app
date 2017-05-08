package tk.ap17.app.autoconcept.orm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.exceptions.ExceptionOrm;
import tk.ap17.app.autoconcept.models.Contacts;
import tk.ap17.app.autoconcept.orm.query.QuerySelect;

public class TableTest {
    private Contacts table;

    @Before
    public void setUp() {
        this.table = new Contacts(null);
        table.addColumn("nom");
        table.addColumn("prenom");
        table.setNameTable("personne");
    }

    @Test
    public void testQuery() throws ExceptionOrm {
         QuerySelect<Contacts> querySelect = table.select("nom,prenom");
         assertEquals("SELECT nom, prenom FROM personne", querySelect.prepare());
    }
}
