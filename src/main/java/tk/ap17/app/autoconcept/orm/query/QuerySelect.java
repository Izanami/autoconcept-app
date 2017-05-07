package tk.ap17.app.autoconcept.orm.query;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Table;

/**
 *  Effectue les requetes SELECT
 *
 * @author Adrien Jeser : adrien@jeser.me
 */
public class QuerySelect {
    private Table table;
    private Integer count;
    private List<String> columns;

    /**
     * Constructeur.
     *
     * Pour construire, prefere l'emploi de Table.query().select();
     *
     * @see Table
     */
    public QuerySelect() {

    }

    /**
     * Constructeur.
     *
     * Pour construire, prefere l'emploi de Table.query().select();
     *
     * @param table Table
     * @param columns Colonne
     * @see Table
     */
    public QuerySelect(Table table, List<String> columns) {
        setTable(table);
        setColumns(columns);
    }

    /**
     * Limite le nombre de resulta
     *
     * @param count
     * @return QuerySelect
     */
    public QuerySelect limit(Integer count) {
        this.setCount(count);
        return this;
    }

    /**
     * Genere la requete Sql
     */
    public String toString() {
        StringBuffer query = new StringBuffer();
        query.append("SELECT ");
        for (String column : columns) {
            query.append(column);
            query.append(", ");
        }
        query.setLength(query.length() - 2);
        query.append(" FROM ");
        query.append(table.getNameTable());
        if (count != null) {
            query.append(" LIMIT ");
            query.append(Integer.toString(count));
        }

        return query.toString();
    }

    /**
     * Execute
     *
     * @param connector Le connecteur
     * @return ResultSet
     * @throws SQLException Requete refuser par le serveur.
     */
    public ResultSet execute(Connector connector) throws SQLException {
        return connector.execute(this.toString());
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

    /**
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return the columns
     */
    public List<String> getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
