package tk.ap17.app.autoconcept.orm.deserialize;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import tk.ap17.app.autoconcept.orm.Table;

public interface modelToFile<T extends Table<T>> {
    public Table<T> getTable();

    public default void toCsv(Path path, String data) throws FileNotFoundException, IOException {
        Table<T> table = getTable();
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("dist"));


        for(Map.Entry<String, Object> entry : table.getColumns().entrySet()) {
            Object value = entry.getValue();
            out.write(content);
        }

        out.close();
    }
}
