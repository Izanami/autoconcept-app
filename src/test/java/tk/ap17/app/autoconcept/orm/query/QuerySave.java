package tk.ap17.app.autoconcept.orm.query;

import java.util.Map;

public interface QuerySave {
    public Boolean setIsSave();
    public Boolean getIsSave();
    public boolean didSave();
    public Map<String, Object> getColumns();

    public default boolean save() {
        return true;
    }

    // INSERT INTO table (c1, c2) VALUES (1, 2)
    public default boolean insert() {
        StringBuilder sql = new StringBuilder();
        StringBuilder columns_sql = new StringBuilder();
        StringBuilder values_sql = new StringBuilder();

        for(Map.Entry<String, Object> entry : getColumns().entrySet()) {
            columns_sql.append(entry.getKey());
            columns_sql.append(", ");
            values_sql.append("? ,");
        }
        return true;
    }
}
