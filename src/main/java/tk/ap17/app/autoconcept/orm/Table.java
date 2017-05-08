package tk.ap17.app.autoconcept.orm;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tk.ap17.app.autoconcept.orm.query.Query;
import tk.ap17.app.autoconcept.orm.query.QuerySelect;

/**
 * Representation d'une table sql.
 *
 * @author Kelian Bousquet
 * @see Connector
 * @see Query
 */
public class Table {
    private String nameTable;
    private String primaryKeyName = "id";
    private Map<String, Object> columns = new HashMap<>();
    private ResultSet resultSet;

    /**
     *
     * @return Object pour manipuler les requetes sql.
     * @see Query
     */
    public Query query() {
        Query query = new Query(this);
        return query;
    }

    /**
     * Requete SELECT
     *
     * @param columns Colonnes
     * @return QuerySelect
     *
     */
    public QuerySelect select(List<String> columns) {
        QuerySelect querySelect = new QuerySelect();
        querySelect.setTable(this);
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
     * @return QuerySelect
     *
     */
    public QuerySelect select(String columns) {
        String[] columns_array = columns.split(",");
        return this.select(Arrays.asList(columns_array));
    }

    /**
     * @param columns Colonne
     */
    public void addField(String name, Object value) {
        getColumns().put(name, value);
    }

    /**
     * @param columns Colonne
     */
    public Object getField(String name) throws SQLException {
        if(getColumns().get(name) == null) {
            addField(name, this.getResultSet().getObject(name));
        }
        return getColumns().get(name);
    }

    /**
     * @return the nameTable
     */
    public String getNameTable() {
        return nameTable;
    }

    /**
     * @param nameTable the nameTable to set
     */
    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    /**
     * @return the primaryKeyName
     */
    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    /**
     * @param primaryKeyName the primaryKeyName to set
     */
    public void setPrimaryKeyName(String primaryKeyName) {
        this.primaryKeyName = primaryKeyName;
    }

    /**
     * @return the columns
     */
    public Map<String, Object> getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(Map<String, Object> columns) {
        this.columns = columns;
    }

    /**
     * @return the resultSet
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * @param resultSet the resultSet to set
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * Definie une colonne
     * @param columns Colonne
     */
    public void addColumn(String name) {
        columns.put(name, null);
    }

    /**
     * Supprime une colonne
     * @param columns Colonne
     */
    public void removeColumn(String name) {
        this.columns.remove(name);
    }
}
