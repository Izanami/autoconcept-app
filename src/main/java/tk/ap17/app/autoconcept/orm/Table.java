package tk.ap17.app.autoconcept.orm;

public class Table {
	private String nameTable;

	public Query query() {
		Query query = new Query(this);
		return query;
	}

	public String getNameTable() {
		return nameTable;
	}

	public void setNameTable(String nameTable) {
		this.nameTable = nameTable;
	}
}
