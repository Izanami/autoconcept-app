package tk.ap17.app.autoconcept.orm.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface QueryWhere {
	
	/**
	 * 
	 * @param sql
	 * @param fields
	 * @return Requete préparée pour filtre Where Sql
	 * @throws SQLException
	 */

	public default PreparedStatement wherePrepare(PreparedStatement sql, String... fields) throws SQLException {

		int i = 1;
		for (String field : fields) {
			sql.setString(i, field);
			i++;
		}
		return sql;
	}
}
