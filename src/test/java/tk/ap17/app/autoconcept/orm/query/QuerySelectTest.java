package tk.ap17.app.autoconcept.orm.query;

import static org.junit.Assert.*;

import java.util.List;
import java.sql.JDBCType;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.exceptions.ExceptionOrm;
import tk.ap17.app.autoconcept.orm.Table;

public class QuerySelectTest {
    private QuerySelect select;

    @Before
    public void setUp() throws Exception {
        Table table = new Table();
        table.setColumn("nom", JDBCType.VARCHAR);
        table.setColumn("prenom", JDBCType.VARCHAR);

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
    public void testToString() throws ExceptionOrm {
        assertEquals("SELECT nom, prenom FROM personne", select.prepare());
        assertEquals("SELECT nom, prenom FROM personne LIMIT 2", select.limit(2).prepare());
        assertEquals("SELECT nom, prenom FROM personne LIMIT 2 GROUP BY nom", select.groupBy("nom").prepare());
        assertEquals("SELECT DISTINCT nom, prenom FROM personne LIMIT 2 GROUP BY nom", select.distinct().prepare());
    }
}
