package tk.ap17.app.autoconcept.orm.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface QueryWhere {
    /**
     * Inject fields WHERE
     *
     * @param sql PreparedStatement
     * @param fields Champs a injecter
     * @return Requete préparée pour filtre Where Sql
     * @throws SQLException Impossible de compiler la requete
     */
    public default PreparedStatement wherePrepare(PreparedStatement sql, Object... fields) throws SQLException {
        int i = 1;
        for (Object field : fields) {
            sql.setObject(i, field);
            i++;
        }
        return sql;
    }
}
