package tk.ap17.app.autoconcept.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;
import tk.ap17.app.autoconcept.orm.deserialize.modelToFile;
import tk.ap17.app.autoconcept.orm.query.QuerySelect;

/**
 * Representation d'une table sql.
 *
 * Models example :
 * <pre>
 * {@code
 *  class Qux extends Table<Qux> {
 *      public Qux() {
 *          addColumn("fred");
 *      }
 *  }
 * }
 * </pre>
 *
 * Example :
 * <pre>
 * {@code
 * Qux quxs = new Qux(connector);
 * quxs = quxs.select("*").execute();
 *
 * // First row
 * System.out.println(quxs.getField("fred"));
 *
 * // Second row
 * quxs = quxs.next();
 * System.out.println(quxs.getField("fred"));
 * }
 * </pre>
 *
 * @author Kelian Bousquet
 * @see Connector
 * @see QuerySelect
 */
public abstract class Table<T extends Table<T>> implements Factory<T> {
    private String nameTable;
    private String primaryKeyName = "id";
    private Map<String, Object> columns = new HashMap<>();
    private ResultSet resultSet;
    private Connector connector;
    private Boolean isSave = false;
    private List<String> loadedField = new ArrayList<>();
    private static Logger logger = Logger.getLogger(ORMLogger.class.getName());

    public Table(Connector connector) {
        setConnector(connector);
    }

    /**
     * Requete SELECT
     *
     * @param columns List of columns
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
     *
     * <pre>
     * {@code
     *  Contacts contacts = new Contacts();
     *  contacts.select("nom, prenom");
     * }
     * </pre>
     *
     * @param columns
     *            Champs
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
        return connection.prepareStatement(sql);
    }

    public ResultSet execute(String sql) throws SQLException {
        logger.info("EXECUTE " + sql);
        ResultSet result = prepare(sql).executeQuery();
        return result;
    }

    public ResultSet execute(PreparedStatement sql) throws SQLException {
        logger.info("EXECUTE " + sql.toString());
        ResultSet result = sql.executeQuery();
        return result;
    }

    /**
     * @return Foreign key anme
     **/
    public String foreignKey() {
        String fk = getNameTable().toLowerCase();
        fk += "_";
        fk += getPrimaryKeyName();
        return fk;
    }

    /**
     * Add a column
     *
     * @param name Column name
     */
    public void addColumn(String name) {
        columns.put(name, null);
    }

    /**
     * Delete column
     *
     * @param name Column name
     */
    public void removeColumn(String name) {
        this.columns.remove(name);
    }

    /**
     * Set value of a field.
     * @param name
     * @param value
     */
    private void addField(String name, Object value) {
        getColumns().put(name, value);
    }

    /**
     * @return Primary key
     */
    public Integer getId() {
        Table<T> table = getTable();
        String pkn = table.getPrimaryKeyName();
        Integer primary_key = getField(pkn, Integer.class);
        return primary_key;
    }

    /**
     * Returns field
     *
     * Prefer use getField(String name, Class<J> type)
     *
     * @param name Column name
     * @param type Type
     * @return Field
     */
    public Object getField(String name) {
        if (!getLoadedField().contains(name)) { // Fly-weigth
            try {
                logger.info("Inject field '" + name + "'");
                getLoadedField().add(name);
                addField(name, this.getResultSet().getObject(name));
            } catch (SQLException e) {
                logger.warning("Can't inject field '" + name + "''" + e.getMessage());
                return null;
            }
        }
        return getColumns().get(name);
    }

    /**
     * Returns casted field
     *
     * @param name Column name
     * @param type Type
     * @return Field
     */
    public <J> J getField(String name, Class<J> type) {
        try {
            Object field = getTable().getField(name);
            return type.cast(field);
        } catch (ClassCastException e) {
            logger.warning("Can't cast field '" + name + "''" + e.getMessage());
            return null;
        }
    }

    /**
     * Next row
     *
     **/
    public T next() throws SQLException {
        T newTable = create();
        getResultSet().next();
        newTable.setResultSet(getResultSet());
        return newTable;
    }

    /**
     * For each
     *
     **/
    //public void forEach(Function< Table<T>, Boolean> lambda) throws SQLException {
        //do {
            //lambda.apply(this);
        //} while(next());
    //}

    /**
     * @return the nameTable
     */
    public String getNameTable() {
        return nameTable;
    }

    /**
     * @param nameTable
     *            the nameTable to set
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
     * @param primaryKeyName
     *            the primaryKeyName to set
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
     * @param columns
     *            the columns to set
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
     * @param resultSet
     *            the resultSet to set
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
     * @param connector
     *            the connector to set
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
     * @param isSave
     *            the isSave to set
     */
    public void setIsSave(Boolean isSave) {
        this.isSave = isSave;
    }

    /**
     * @return the loadedField
     */
    public List<String> getLoadedField() {
        return loadedField;
    }

    /**
     * @param loadedField
     *            the loadedField to set
     */
    public void setLoadedField(List<String> loadedField) {
        this.loadedField = loadedField;
    }

    /**
     * Short Description
     *
     **/
    public void resetLoadedField() {
        setLoadedField(new ArrayList<String>());
    }

    /**
     */
    public Table<T> getTable() {
        return this;
    }

    /**
     * For each
     *
     **/

    //public void forEach(Function< Table<T>, Boolean> lambda) throws SQLException {
        //do {
            //lambda.apply(this);
        //} while(next());
    //}
}
