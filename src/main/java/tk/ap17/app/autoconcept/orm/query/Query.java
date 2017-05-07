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
     * Pour construire un objet, prefere l'emploi de Table.query();
     *
     * @see Table
     */
    public Query() {}


    /**
     * Constructeur.
     *
     * Pour construire un objet, prefere l'emploi de Table.query();
     *
     * @see Table
     */
    public Query(Table table) {
        setTable(table);
    }

    /**
     * Sélectionner des champs
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
     * Sélectionner des champs
     *
     * @param columns
     * @return
     *
     */
    public QuerySelect select(String columns) {
        String[] columns_array = columns.split(",");
        return this.select(Arrays.asList(columns_array));
    }

    /**
     * Insérrer des champs
     *
     */

    public boolean insert(Map<String, String> value) {

        return true;
    }

    /**
     * Modifier des champs
     */

    public boolean update(Map<String, String> value) {

        return true;
    }

    /**
     * Supprimer des champs
     */

    public boolean delete(Map<String, String> value) {

        return true;
    }

    /**
     * Récupérer une table
     */

    public Table getTable() {

        return table;
    }

    public void setTable(Table newTable) {
        this.table = newTable;
    }
}
