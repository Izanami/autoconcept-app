package tk.ap17.app.autoconcept.models;

import java.util.ArrayList;
import java.util.List;

import tk.ap17.app.autoconcept.orm.Table;

public class Partenaires extends Table {
    public Partenaires() {
        List<String> map = new ArrayList<>();

        this.setNameTable("Partenaire");
        this.setColumns(map);
    }
}
