package tk.ap17.app.autoconcept.orm.query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import tk.ap17.app.autoconcept.orm.Table;
import tk.ap17.app.autoconcept.orm.query.QuerySelect;

/**
 * Prepare les objects pour manipuler les requetes.
 *
 * Example :
 * <pre>{@code
 * Partenaire partenaire = new Partenaire();
 * partenaire.query().select("*").execute(connector);
 * }
 * </pre>
 *
 * @author Adrien Jeser : adrien@jeser.me
 * @author Kelian Bousquet
 * @see Connector
 * @see Table
 */
public class Query {
    private Table table;

    /**
     * Constructeur.
     *
     * Pour construire, prefere l'emploi de Table.query();
     *
     * @see Table
     */
    public Query() {}


    /**
     * Constructeur.
     *
     * Pour construire, prefere l'emploi de Table.query();
     *
     * @see Table
     */
    public Query(Table table) {
        setTable(table);
    }

    /**
     * Requete SELECT
     *
     * @param columns
     * @return
     *
     */
    public QuerySelect select(List<String> columns) {
        QuerySelect querySelect = new QuerySelect();
        querySelect.setTable(table);
        querySelect.setColumns(columns);
        return querySelect;
    }

    /**
     * Requete SELECT
     *
     * Example :
     * <pre>{@code
     *  query.select("nom, prenom");
     * }
     * </pre>
     *
     * @param columns Champs
     * @see Query
     * @return
     *
     */
    public QuerySelect select(String columns) {
        String[] columns_array = columns.split(",");
        return this.select(Arrays.asList(columns_array));
    }

    /**
     * @return the table
     */
    public Table getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(Table table) {
        this.table = table;
    }
}
