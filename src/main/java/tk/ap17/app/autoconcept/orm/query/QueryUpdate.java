package tk.ap17.app.autoconcept.orm.query;

import java.util.List;
import java.sql.ResultSet;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Table;

public class QueryUpdate {
	private Table table;
	private Integer count;
	private List<String> columns;

	public QueryUpdate() {

	}

	public QueryUpdate limit(Integer count) {
		this.count = count;
		return this;
	}

	public Resulset execute(Connector connector) {

		return;
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
		this.count = count;
	}

	public List getString() {
		return String;
	}

	public void setString(List string) {
		String = string;
	}

	public String getColums() {
		return colums;
	}

	public void setColums(String colums) {
		this.colums = colums;
	}

}
