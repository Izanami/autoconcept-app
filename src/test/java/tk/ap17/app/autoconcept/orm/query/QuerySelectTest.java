package tk.ap17.app.autoconcept.orm.query;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.exceptions.ExceptionOrm;
import tk.ap17.app.autoconcept.models.Contacts;
import tk.ap17.app.autoconcept.orm.Table;

public class QuerySelectTest {
    private QuerySelect select;

    @Before
    public void setUp() throws Exception {
        Contacts table = new Contacts(null);
        table.addColumn("nom");
        table.addColumn("prenom");

        select = new QuerySelect();
        List<String> columns = new ArrayList<>();

        columns.add("nom");
        columns.add("prenom");

        table.setNameTable("personne");

        select.setTable(table);
        select.setColumns(columns);
    }

    @Test
    public void testQuerySelect() {

    }

    @Test
    public void testPrepare() throws ExceptionOrm {
        assertEquals("SELECT nom, prenom FROM personne", select.prepare());
        assertEquals("SELECT nom, prenom FROM personne LIMIT 2", select.limit(2).prepare());
        assertEquals("SELECT nom, prenom FROM personne LIMIT 2 GROUP BY nom", select.groupBy("nom").prepare());
        assertEquals("SELECT DISTINCT nom, prenom FROM personne LIMIT 2 GROUP BY nom", select.distinct().prepare());
    }

    @Test
    public void testWhere() throws ExceptionOrm {
        select.where("qux = ?", 42);
    }
}
