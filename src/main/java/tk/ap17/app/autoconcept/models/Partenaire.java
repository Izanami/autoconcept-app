package tk.ap17.app.autoconcept.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Row;
import tk.ap17.app.autoconcept.orm.query.QueryBelongs;

public class Partenaire extends Row implements QueryBelongs {
    public Partenaire(Connector connector, ResultSet result_set) throws SQLException {
        super(connector, new Partenaires(), result_set);
    }

    public String getName() throws SQLException {
        return (String) this.getField("nom");
    }

    /**
     * Short Description
     *
	 * @throws
     **/
    public Partenaire belongs() throws SQLException {
        return (Partenaire) belongsString(getConnector(), getTable());
    }
}
