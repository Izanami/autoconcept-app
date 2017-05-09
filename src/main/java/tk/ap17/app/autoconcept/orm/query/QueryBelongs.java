package tk.ap17.app.autoconcept.orm.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.Locale;

import tk.ap17.app.autoconcept.orm.Table;

public interface QueryBelongs<T extends Table<T>> {
    public Table<T> getTable();

    public default <J extends Table<J>> J belongs(J table_join) throws SQLException {
        return belongs(table_join, "*");
    }

    public default <J extends Table<J>> J belongs(J table_join, String select) throws SQLException {
        ResultSet result = getTable().execute(belongsString(table_join, select));
        result.next();
        table_join.setResultSet(result);
        return table_join;
    }

    public default <J extends Table<J>> String belongsString(J table_join, String select) {
        String nameTableJoin = table_join.getNameTable();
        String nameTable = getTable().getNameTable();
        Integer id = getTable().getId();
        String fkName = table_join.foreignKey();

        StringBuilder query = new StringBuilder();
        Formatter formatter = new Formatter(query, Locale.US);
        formatter.format("SELECT * FROM %s INNER JOIN %s ON %s.%s=%d LIMIT 1",
                nameTableJoin,
                nameTable,
                nameTable,
                fkName,
                id);
        formatter.close();
        return query.toString();
    }
}
