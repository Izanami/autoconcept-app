package tk.ap17.app.autoconcept.orm.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Table;

public interface QueryBelongs<T extends Table<T>, S extends Table<S>> {
    public Table<T> getTable();
    public Object getField(String name);
    public default String getId() {
        Table<T> table = getTable();
        String pkn = table.getPrimaryKeyName();
        String primary_key = (String) getField(pkn);
        return primary_key;
    }

    public default S belongs(S table_join) throws SQLException {
        Connection connection = getTable().getConnector().getConnection();
        String query = belongsString(table_join);
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet result = prepareStatement.executeQuery();
        result.next();
        table_join.setResultSet(result);
        return table_join;
    }

    public default String belongsString(S table_join) throws SQLException {
        String query = "SELECT * FROM Contact INNER JOIN Partenaire ON Partenaire.Contact_id=1 LIMIT 1";
        return query;
    }
}
