package tk.ap17.app.autoconcept.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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
public abstract class Table<T extends Table<T>>  {
    private String nameTable;
    private String primaryKeyName = "id";
    private Map<String, Object> columns = new HashMap<>();
    private ResultSet resultSet;
    private Connector connector;
    private static Logger logger = Logger.getLogger(ORMLogger.class.getName());
    private Boolean isSave = false;

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

    public PreparedStatement prepare(String sql) throws SQLException {
        Connection connection = getConnector().getConnection();
        return  connection.prepareStatement(sql);
    }

    public ResultSet execute(String sql) throws SQLException {
        logger.info("EXECUTE " + sql);
        ResultSet result = prepare(sql).executeQuery();
        return result;
    }


    public ResultSet execute(PreparedStatement  sql) throws SQLException {
        logger.info("EXECUTE " + sql.toString());
        ResultSet result = sql.executeQuery();
        return result;
    }

    /**
     * Returns the FOREIGN KEY
     *
     * @return object
     **/
    public String foreignKey() {
        String fk = getNameTable().toLowerCase();
        fk += "_";
        fk += getPrimaryKeyName();

        return fk;
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
     *
     *
     * @return
     */
    public Integer getId() {
        Table<T> table = getTable();
        String pkn = table.getPrimaryKeyName();
        Integer primary_key = (Integer) getField(pkn);
        return primary_key;
    }

    /**
     * @param columns Colonne
     */
    public Object getField(String name) {
        if(getColumns().get(name) == null) { // Fly-weigth
            try {
                logger.info("Inject field '" + name + "'");
                addField(name, this.getResultSet().getObject(name));
            } catch(SQLException e){
                logger.warning("Can't inject field '" + name + "''" + e.getMessage());
                return null;
            }
        }
        return getColumns().get(name);
    }

    public <J> J getField(String name, Class<J> type) {
        try {
            Object field = getTable().getField(name);
            return type.cast(field);
        } catch(ClassCastException e) {
            logger.warning("Can't cast field '" + name + "''" + e.getMessage());
            return null;
        }
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
     * @return the isSave
     */
    public Boolean getIsSave() {
        return isSave;
    }

    /**
     * @param isSave the isSave to set
     */
    public void setIsSave(Boolean isSave) {
        this.isSave = isSave;
    }

    /**
     */
    public Table<T> getTable() {
        return this;
    }
}
