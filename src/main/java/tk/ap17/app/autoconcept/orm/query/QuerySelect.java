package tk.ap17.app.autoconcept.orm.query;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.exceptions.ExceptionOrm;
import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Table;

/**
 * Effectue les requetes SELECT
 *
 * @author Adrien Jeser : adrien@jeser.me
 */
public class QuerySelect implements QueryWhere {
	private Table table;
	private Integer count;
	private String group_by;
	private List<String> columns;
	private boolean distrinct = false;
	private String whereStr;
	private String[] fields;

	/**
	 * Constructeur.
	 *
	 * Pour construire, prefere l'emploi de Table.query().select();
	 *
	 * @see Table
	 */
	public QuerySelect() {

	}

	/**
	 * Constructeur.
	 *
	 * Pour construire, prefere l'emploi de Table.query().select();
	 *
	 * @param table
	 *            Table
	 * @param columns
	 *            Colonne
	 * @see Table
	 */
	public QuerySelect(Table table, List<String> columns) {
		setTable(table);
		setColumns(columns);
	}

	/**
	 * Limite le nombre de resulta
	 *
	 * @param count
	 * @return QuerySelect
	 */
	public QuerySelect limit(Integer count) {
		this.setCount(count);
		return this;
	}

	/**
	 * Groupe le resulta par un/des champ(s)
	 * 
	 * @return object QuerySelect
	 */
	public QuerySelect groupBy(String str) {
		this.setGroupBy(str);
		return this;
	}

	/**
	 * Supprimer les lignes en doublon
	 * 
	 * @return object QuerySelect
	 */
	public QuerySelect distinct() {
		this.setDistrinct(true);
		return this;
	}

	/**
	 * Genere la requete Sql
	 * 
	 * @throws SQLException
	 *             impossible de compiler le Sql
	 */
	public PreparedStatement prepare(Connector connector) throws ExceptionOrm, SQLException {

		StringBuffer query = new StringBuffer();
		query.append("SELECT ");

		if (isDistrinct()) {
			query.append("DISTINCT ");
		}

		for (String column : columns) {
			if (getTable().getColumns().get(column) == null) {
				throw new ExceptionOrm("Column " + column + " not in the " + getTable().getClass().getName()
						+ " models (Table name : " + getTable().getNameTable() + ")");
			}

			query.append(column);
			query.append(", ");
		}
		query.setLength(query.length() - 2);
		query.append(" FROM ");
		query.append(table.getNameTable());
		
		if (getWhereStr() != null) {
		query.append(" WHERE ");
		query.append(getWhereStr());
		}

		if (getCount() != null) {
			query.append(" LIMIT ");
			query.append(Integer.toString(count));
		}

		if (getGroupBy() != null) {
			query.append(" GROUP BY ");
			query.append(getGroupBy());
		}

		PreparedStatement prepareStatement = connector.getConnection().prepareStatement(query.toString());
		
		 prepareStatement = wherePrepare(prepareStatement, fields);

		return prepareStatement;
	}

	public QuerySelect where(String sql, String... fields) {
		setWhereStr(sql);
		this.fields = fields;
		return this;
	}

	/**
	 * Execute
	 *
	 * @param connector
	 *            Le connecteur
	 * @return ResultSet
	 * @throws SQLException
	 *             Requete refuser par le serveur.
	 * @throws ExceptionOrm
	 */
	public ResultSet execute(Connector connector) throws SQLException, ExceptionOrm {
		return this.prepare(connector).executeQuery();
	}

	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the groupBy
	 */
	public String getGroupBy() {
		return group_by;
	}

	/**
	 *
	 * @param groupBy
	 *            the groupBy to set
	 */
	public void setGroupBy(String groupBy) {
		this.group_by = groupBy;
	}

	/**
	 * @return the columns
	 */
	public List<String> getColumns() {
		return columns;
	}

	/**
	 * @param columns
	 *            the columns to set
	 */
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	/**
	 * @return the distrinct
	 */
	public boolean isDistrinct() {
		return distrinct;
	}

	/**
	 * @param distrinct
	 *            the distrinct to set
	 */
	public void setDistrinct(boolean distrinct) {
		this.distrinct = distrinct;
	}

	public String getWhereStr() {
		return whereStr;
	}

	public void setWhereStr(String whereStr) {
		this.whereStr = whereStr;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}
}
