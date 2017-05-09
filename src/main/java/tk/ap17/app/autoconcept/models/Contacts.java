package tk.ap17.app.autoconcept.models;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Table;

public class Contacts extends Table<Contacts> {
	public Contacts(Connector connector) {
        super(connector);
        this.setNameTable("Contact");
        this.addColumn("nom");
	}
}
