package tk.ap17.app.autoconcept.orm;

import static org.junit.Assert.*;

import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.exceptions.ExceptionOrm;
import tk.ap17.app.autoconcept.orm.query.Query;
import tk.ap17.app.autoconcept.orm.query.QuerySelect;

public class TableTest {
    private Query query;

    @Before
    public void setUp() {
        Table table = new Table();
        table.setColumn("nom", JDBCType.VARCHAR);
        table.setColumn("prenom", JDBCType.VARCHAR);

        query = new Query(table);

        table.setNameTable("personne");
    }

    @Test
    public void testQuery() throws ExceptionOrm {
         QuerySelect querySelect = query.select("nom,prenom");
         assertEquals("SELECT nom, prenom FROM personne", querySelect.prepare());
    }

}
