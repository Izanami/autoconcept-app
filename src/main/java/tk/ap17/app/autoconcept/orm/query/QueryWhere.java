package tk.ap17.app.autoconcept.orm.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Connector;


public interface QueryWhere {

	public default String whereToString(Connector connector, String sql, String where, String... fields) throws SQLException {
		
		PreparedStatement preparedStatement = connector.getConnection().prepareStatement(sql); 

		int i = 1;
		for (String field : fields) {
			preparedStatement.setString(i,field); 
			i++;
		}
		
		// exécution de la requête
		preparedStatement.executeUpdate();

		return sql;
	}
}
