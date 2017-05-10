package tk.ap17.app.autoconcept.models;

import java.sql.SQLException;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Table;
import tk.ap17.app.autoconcept.orm.query.QueryBelongs;
import tk.ap17.app.autoconcept.models.Contacts;

public class Partenaires
    extends Table<Partenaires>
    implements QueryBelongs<Partenaires>
    {
    public Partenaires(Connector connector) {
        super(connector);
        this.setNameTable("Partenaire");
    }

    public Contacts contact() throws SQLException {
        Contacts contact = new Contacts(getConnector());
        return this.belongs(contact);
    }

    public Partenaires create() {
        return new Partenaires(getConnector());
    }
}
