package tk.ap17.app.autoconcept.models;

import java.sql.JDBCType;
import java.util.HashMap;
import java.util.Map;

import tk.ap17.app.autoconcept.orm.Table;

public class Contacts extends Table {

	public Contacts() {
		Map<String,JDBCType> map = new HashMap<>();
		
		map.put("nom", JDBCType.VARCHAR);
		map.put("prenom", JDBCType.VARCHAR);
		map.put("sexe", JDBCType.TINYINT);
		map.put("dateNaiss", JDBCType.DATE);
		map.put("courriel", JDBCType.VARCHAR);
		map.put("telephone", JDBCType.VARCHAR);
		
		
		this.setNameTable("Contact"); 
//		this.setColumns(map);
	}
}
