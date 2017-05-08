package tk.ap17.app.autoconcept.orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Row {
    private String primaryKey;
    private ResultSet resultset;
    private Map<String, Object> fields = new HashMap<>();
    private Table table;
    private Connector connector;

    public Row(Connector connector, Table table, ResultSet resultset) throws SQLException {
        setResultset(resultset);
        setConnector(connector);
        setTable(table);

        for (String column : table.getColumns()) {
            addField(column);
        }
    }

    /**
     * @return the primaryKey
     */
    public String getPrimaryKey() {
        return primaryKey;
    }

    /**
     * @param primaryKey the primaryKey to set
     */
    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * @return the resultset
     */
    public ResultSet getResultset() {
        return resultset;
    }

    /**
     * @param resultset the resultset to set
     */
    public void setResultset(ResultSet resultset) {
        this.resultset = resultset;
    }

    /**
     * @return the fields
     */
    public Map<String, Object> getFields() {
        return fields;
    }

    /**
     * @return the fields
     */
    public Object getField(String name) {
        return getFields().get(name);
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
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
    public boolean addField(String name) {
        try {
            getResultset().findColumn(name);
        } catch(SQLException e){
            return false;
        }

        try {
            this.fields.put(name, getResultset().getObject(name));
        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
