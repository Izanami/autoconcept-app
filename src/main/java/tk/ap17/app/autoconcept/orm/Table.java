package tk.ap17.app.autoconcept.orm;

import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private String primaryKeyName = "id";
    private List<String> columns = new ArrayList<>();

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
    public List<String> getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    /**
     * Definie une colonne
     * @param columns Colonne
     */
    public void addColumn(String name) {
        columns.add(name);
    }

    /**
     * Supprime une colonne
     * @param columns Colonne
     */
    public void removeColumn(String name) {
        this.columns.remove(name);
    }
}
