package tk.ap17.app.autoconcept.orm;

import tk.ap17.app.autoconcept.orm.query.Query;

/**
 * Representation d'une table sql.
 *
 * @author Kelian Bousquet
 * @see Connector
 * @see Query
 */
public class Table {
    /**
     * Nom de la table dans la base de donnee.
     */
    private String nameTable;

    /**
     *
     * @return Object pour manipuler les requetes sql.
     * @seee Query
     */
    public Query query() {
        Query query = new Query(this);
        return query;
    }

    /**
     * @return the nameTable
     */
    public String getNameTable() {
        return nameTable;
    }

    /**
     * @param nameTable the nameTable to set
     */
    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

}
