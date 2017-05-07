package tk.ap17.app.autoconcept.orm;

import java.sql.JDBCType;
import java.util.HashMap;
import java.util.Map;

import tk.ap17.app.autoconcept.orm.query.Query;

/**
 * Representation d'une table sql.
 *
 * @author Kelian Bousquet
 * @see Connector
 * @see Query
 */
public class Table {
    private String nameTable;
    private String primaryKeyName;
    private Map<String, JDBCType> columns = new HashMap<>();

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
    public Map<String, JDBCType> getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(Map<String, JDBCType> columns) {
        this.columns = columns;
    }

    /**
     * Definie une colonne
     * @param columns Colonne
     */
    public void setColumn(String name, JDBCType jdbctype) {
        this.columns.put(name, jdbctype);
    }

    /**
     * Supprime une colonne
     * @param columns Colonne
     */
    public void removeColumn(String name) {
        this.columns.remove(name);
    }
}
