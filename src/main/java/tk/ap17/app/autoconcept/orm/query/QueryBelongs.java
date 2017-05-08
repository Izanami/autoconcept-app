package tk.ap17.app.autoconcept.orm.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Row;
import tk.ap17.app.autoconcept.orm.Table;

public interface QueryBelongs {
    public Table getTable();
    public Object getField(String name);
    public default String getId() {
        return (String) getField(getTable().getPrimaryKeyName());
    }

    public default Row belongsString(Connector connector, Table table_join) throws SQLException {
        PreparedStatement prepareStatement = connector.getConnection().prepareStatement("SELECT * FROM ? INNER JOIN ? = ? LIMIT 1");

        prepareStatement.setString(1, table_join.getNameTable()); // table
        prepareStatement.setString(2, table_join.getNameTable() + "." + table_join.getNameTable() + "_"+ getTable().getPrimaryKeyName());
        prepareStatement.setString(3, getId()); // table
        System.out.println(prepareStatement);
        return new Row(connector, getTable(), prepareStatement.executeQuery());
    }
}
