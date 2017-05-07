package tk.ap17.app.autoconcept.orm.query;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Table;

public class QuerySelect {
	private Table table;
	private Integer count;
	private List<String> columns;

	public QuerySelect() {

	}

	public QuerySelect(Table table, List<String> columns){
		setTable(table);
		setColumns(columns);
	}

	public QuerySelect limit(Integer count) {
		this.setCount(count);
		return this;
	}

	public String toString() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT ");
		for (String column : columns) {
			query.append(column);
			query.append(", ");
		}
		query.setLength(query.length() - 2);
		query.append(" FROM ");
		query.append(table.getNameTable());
		if (count != null) {
			query.append(" LIMIT ");
			query.append(Integer.toString(count));
		}

		return query.toString();
	}

	public ResultSet execute(Connector connector) throws SQLException {
		return connector.execute(this.toString());
	}

	/**
	 * Getter / Setter
	 */

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		if (count < 0) {
			throw new IllegalArgumentException("Ne peut pas être inférieur à zéro !");
		}
		this.count = count;
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
}
