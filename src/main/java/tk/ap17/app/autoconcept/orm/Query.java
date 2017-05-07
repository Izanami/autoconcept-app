package tk.ap17.app.autoconcept.orm;

import java.util.List;
import java.util.Map;

import tk.ap17.app.autoconcept.orm.query.QuerySelect;

public class Query {
	private Table table;

	/**
	 * 
	 */
	
	public Query() {

	}

	/**
	 *
	 */
	
	public Query(Table table) {

		setTable(table);
	}
	
	/**
	 * Sélectionner des champs
	 * 
	 */

	public QuerySelect select(List<String> columns) {
		QuerySelect querySelect = new QuerySelect();
		querySelect.setTable(table);
		querySelect.setColumns(columns);
		return querySelect;
	}

	/**
	 * Insérrer des champs
	 *
	 */

	public boolean insert(Map<String, String> value) {

		return true;
	}

	/**
	 * Modifier des champs
	 */

	public boolean update(Map<String, String> value) {

		return true;
	}

	/**
	 * Supprimer des champs
	 */

	public boolean delete(Map<String, String> value) {

		return true;
	}

	/**
	 * Récupérer une table
	 */
	
	public Table getTable() {

		return table;
	}

	public void setTable(Table newTable) {
		this.table = newTable;
	}
}
