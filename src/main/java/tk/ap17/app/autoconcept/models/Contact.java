package tk.ap17.app.autoconcept.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Row;
import tk.ap17.app.autoconcept.orm.query.QueryBelongs;
import tk.ap17.app.autoconcept.models.Contact;

public class Contact extends Row implements QueryBelongs {
    public Contact(Connector connector, ResultSet result_set) throws SQLException {
        super(connector, new Partenaires(), result_set);
    }

    public Contact(Row row) throws SQLException {
        super(row.getConnector(), row.getTable(), row.getResultset());
    }

    public String getName() throws SQLException {
        return this.getResultset().getString("nom");
    }
}
