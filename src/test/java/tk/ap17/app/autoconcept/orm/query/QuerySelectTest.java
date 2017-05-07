package tk.ap17.app.autoconcept.orm.query;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.orm.Table;

public class QuerySelectTest {
    private QuerySelect select;

    @Before
    public void setUp() throws Exception {
        Table table = new Table();
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
    public void testToString() {
        assertEquals("SELECT nom, prenom FROM personne", select.toString());
        assertEquals("SELECT nom, prenom FROM personne LIMIT 2", select.limit(2).toString());
    }
}
