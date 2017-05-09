package tk.ap17.app.autoconcept.orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tk.ap17.app.autoconcept.orm.query.QueryBelongs;
import tk.ap17.app.autoconcept.orm.query.QuerySelect;

/**
 * Representation d'une table sql.
 *
 * Example de models :
 * <pre>{@code
 *  class Qux extends Table<Qux> {
 *      public Qux() {
 *          addColumn("fred");
 *  }
 * }
 * </pre>
 * @author Kelian Bousquet
 * @see Connector
 * @see QuerySelect
 */
public abstract class Table<T extends Table<T>> {
    private String nameTable;
    private String primaryKeyName = "id";
    private Map<String, Object> columns = new HashMap<>();
    private ResultSet resultSet;
    private Connector connector;

    public Table(Connector connector) {
        setConnector(connector);
    }

    /**
     * Requete SELECT
     *
     * @param columns Colonnes
     * @return QuerySelect
     *
     */
    public QuerySelect<T> select(List<String> columns) {
        QuerySelect<T> querySelect = new QuerySelect<T>();
        querySelect.setTable(this);
        querySelect.setColumns(columns);
        return querySelect;
    }

    /**
     * Requete SELECT
     *
     * Example :
     * <pre>{@code
     * Contacts contacts =  new Contacts();
     * contacts.select("nom, prenom");
     * }
     * </pre>
     *
     * @param columns Champs
     * @see Query
     * @return QuerySelect
     *
     */
    public QuerySelect<T> select(String columns) {
        String[] columns_array = columns.split(",");
        return this.select(Arrays.asList(columns_array));
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

    /**
     * @param columns Colonne
     */
    private void addField(String name, Object value) {
        getColumns().put(name, value);
    }

    /**
     * @param columns Colonne
     */
    public Object getField(String name) {
        if(getColumns().get(name) == null) { // Fly-weigth
            try {
                addField(name, this.getResultSet().getObject(name));
            } catch(SQLException e){
                e.printStackTrace();
            }
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
     * @return the connector
     */
    public Connector getConnector() {
        return connector;
    }

    /**
     * @param connector the connector to set
     */
    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    /**
     */
    public Table<T> getTable() {
        return this;
    }
}
