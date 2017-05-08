package tk.ap17.app.autoconcept.orm.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Row;
import tk.ap17.app.autoconcept.orm.Table;

public interface QueryBelongs {
    public Table getTable();
    public Object getField(String name);
    public default String getId() {
        return "4";
    }

    public default Row belongsString(Connector connector, Table table_join) throws SQLException {
        PreparedStatement prepareStatement = connector.getConnection().prepareStatement("SELECT * FROM Contact INNER JOIN Partenaire ON Partenaire.Contact_id=1 LIMIT 1");
        ResultSet result = prepareStatement.executeQuery();
        result.next();
        return new Row(connector, getTable(), result);
    }
}
