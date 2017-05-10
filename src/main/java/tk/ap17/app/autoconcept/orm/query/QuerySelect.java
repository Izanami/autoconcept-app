package tk.ap17.app.autoconcept.orm.query;

import java.util.List;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.exceptions.ExceptionOrm;
import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.ORMLogger;
import tk.ap17.app.autoconcept.orm.Table;

/**
 * Effectue les requetes SELECT
 *
 * <pre>{@code
 *  Partenaires partenaires = new Partenaires(connector);
 *  partenaire.select("thud").limit(10).where("nom = ?", "Adrien").execute();
 *
 *  System.out.println(partenaire.getField("thud"));
 * }
 * </pre>
 *
 * @author Kelian Bousquet
 * @author Adrien Jeser : adrien@jeser.me
 */
public class QuerySelect<T extends Table<T>> implements QueryWhere {
    private Table<T> table;
    private Integer count;
    private String group_by;
    private List<String> columns;
    private boolean distrinct = false;
    private String whereStr;
    private Object[] whereFields;
    private static Logger logger = Logger.getLogger(ORMLogger.class.getName());

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
     * Limite le nombre de resulta
     *
     * @param count
     * @return QuerySelect
     */
    public QuerySelect<T> limit(Integer count) {
        this.setCount(count);
        return this;
    }

    /**
     * Groupe le resulta par un/des champ(s)
     *
     * @return object QuerySelect
     */
    public QuerySelect<T> groupBy(String str) {
        this.setGroupBy(str);
        return this;
    }

    /**
     * Supprimer les lignes en doublon
     *
     * @return object QuerySelect
     */
    public QuerySelect<T> distinct() {
        this.setDistrinct(true);
        return this;
    }

    /**
     * Genere la requete Sql
     *
     * @throws SQLException
     *             impossible de compiler le Sql
     */
    public String prepare() throws ExceptionOrm {
        StringBuffer query = new StringBuffer();
        query.append("SELECT ");

        if (isDistrinct()) {
            query.append("DISTINCT ");
        }

        if (getColumns().contains("*")) {
            query.append("*");
        } else {
            for (String column : columns) {
                if (!getTable().getColumns().containsKey(column)) {
                    throw new ExceptionOrm("Column " + column + " not in the " + getTable().getClass().getName()
                            + " models (Table name : " + getTable().getNameTable() + ")");
                }

                query.append(column);
                query.append(", ");
            }
        query.setLength(query.length() - 2);
        }

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


        logger.info("PREPARE : " + query.toString());

        return query.toString();
    }

    /**
     * Genere la requete Sql
     *
     * @throws SQLException
     *             impossible de compiler le Sql
     */
    public PreparedStatement compile() throws ExceptionOrm, SQLException {
        PreparedStatement prepareStatement = getTable().prepare(prepare().toString());

        logger.info("BEFORE WHERE : " + prepareStatement.toString());
        if(getWhereFields() != null) {
            prepareStatement = wherePrepare(prepareStatement, getWhereFields());
        }
        logger.info("AFTER WHERE : " + prepareStatement.toString());

        return prepareStatement;
    }

    /**
     * Filtre WHERE
     *
     * <pre>{@code
     *  Partenaire partenaire = new Partenaire();
     *  partenaire.query().select().where("nom = ?", "Adrien");
     * }
     * </pre>
     *
     * @param sql Code sql
     * @param fields Champs a injecter
     * @return
     */
    public QuerySelect<T> where(String sql, Object... fields) {
        setWhereStr(sql);
        setWhereFields(fields);
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
    public T execute() throws SQLException, ExceptionOrm {
        T table = getTable().create();
        ResultSet result_set = getTable().execute(this.compile());
        result_set.next();
        table.setResultSet(result_set);
        table.initialize();
        return table;
    }

    /**
     * @return the table
     */
    public Table<T> getTable() {
        return table;
    }

    /**
     * @param table
     *            the table to set
     */
    public void setTable(Table<T> table) {
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

    /**
     * @return the whereFields
     */
    public Object[] getWhereFields() {
        return whereFields;
    }

    /**
     * @param whereFields the whereFields to set
     */
    public void setWhereFields(Object[] whereFields) {
        this.whereFields = whereFields;
    }

    /**
     * @return the logger
     */
    public static Logger getLogger() {
        return logger;
    }
}
