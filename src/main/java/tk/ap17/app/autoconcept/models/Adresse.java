package tk.ap17.app.autoconcept.models;

import tk.ap17.app.autoconcept.orm.Connector;
import tk.ap17.app.autoconcept.orm.Table;

public class Adresse extends Table<Adresse> {
	public Adresse(Connector connector) {
        super(connector);
	}
}
