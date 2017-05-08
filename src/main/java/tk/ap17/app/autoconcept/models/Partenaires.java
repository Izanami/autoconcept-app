package tk.ap17.app.autoconcept.models;

import java.util.ArrayList;
import java.util.List;

import tk.ap17.app.autoconcept.orm.Table;

public class Partenaires extends Table {
    public Partenaires() {
        List<String> map = new ArrayList<>();

        map.add("nom");
        map.add("prenom");
        map.add("sexe");
        map.add("dateNaiss");
        map.add("courriel");
        map.add("telephone");

        this.setNameTable("personne");
        this.setColumns(map);
    }
}
