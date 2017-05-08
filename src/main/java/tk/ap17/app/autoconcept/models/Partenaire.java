package tk.ap17.app.autoconcept.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Row;
import tk.ap17.app.autoconcept.orm.query.QueryBelongs;
import tk.ap17.app.autoconcept.models.Contact;
import tk.ap17.app.autoconcept.models.Contacts;

public class Partenaire extends Row implements QueryBelongs {
    public Partenaire(Connector connector, ResultSet result_set) throws SQLException {
        super(connector, new Partenaires(), result_set);
    }

    /**
     * Short Description
     *
	 * @throws
     **/
    public Contact contact() throws SQLException {
        return new Contact(belongsString(getConnector(), new Contacts()));
    }
}
