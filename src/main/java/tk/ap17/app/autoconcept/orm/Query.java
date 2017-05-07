package tk.ap17.app.autoconcept.orm;

import java.util.List;
import java.util.Map;

import tk.ap17.app.autoconcept.orm.query.QuerySelect;

public class Query {
<<<<<<< HEAD
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
=======
    private Connector connector;
    private Table table;


    /**
     *
     */
    public Query(){

    }

    /**
     * Contructeur
     */
    public Query(Table table) {

    }

    /**
     * Returns a Query.
     *
     * @param colums
     * @throws NullPointerException
     */
//  public ResultSet select(List<String> columns) throws NullPointerException, SQLException {
//      StringBuffer query = new StringBuffer("SELECT ");
//
//      if (columns.size() <= 0) {
//          throw new IllegalArgumentException("Columns can not be empty.");
//      }
//
//      for (String column : columns) {
//          query.append(column);
//          query.append(" ,");
//      }
//
//      query.setLength(query.length() - 2);
//      query.append(" FROM ");
//      query.append(getNameTable());
//
//      return connector.execute("");
//  }

    /**
     * Insérrer des champs
     *
     * @param value value
     * @return true
     */
    public boolean insert(Map<String, String> value) {

        return true;
    }

    /**
     * Modifier des champs
     *
     * @param value value
     * @return true
     */
    public boolean update(Map<String, String> value) {

        return true;
    }

    /**
     * Supprimer des champs
     *
     * @param value value
     * @return true
     */
    public boolean delete(Map<String, String> value) {

        return true;
    }

    // public Resulset execute(Connector()){
    //
    // return ;
    // }

    /**
     * Récupérer une table
     *
     * @return Table
     *
     */
    public String getTable() {

        return "";
    }

    /**
     * Collection de tables unique
     *
     * @param name
     */
    // public List setTable(String name) {

    // return;
    // }

    /**
     * Récuperer une colonne
     */
    // public List getColums() {

    // return
    // }

    /**
     * Collection de colonnes unique
     */
    // public List setColums() {

    // return
    // }
>>>>>>> review
}
