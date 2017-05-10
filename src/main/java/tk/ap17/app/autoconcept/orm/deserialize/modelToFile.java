package tk.ap17.app.autoconcept.orm.deserialize;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Map;
import java.util.function.Function;

import tk.ap17.app.autoconcept.orm.Table;

public interface modelToFile<T extends Table<T>> {
    public Table<T> getTable();

    public default void toCsv(Path path) throws FileNotFoundException, IOException, SQLException {
        Table<T> table = getTable();
        BufferedWriter out = new BufferedWriter(new FileWriter("/tmp/ez"));

        // Head
        StringBuilder head = new StringBuilder();

        for(Map.Entry<String, Object> entry : table.getColumns().entrySet()) {
            head.append(entry.getKey());
            head.append(",");
        }

        head.setLength(head.length() - 1);
        head.append("\n");
        out.write(head.toString());

        Function<Table<T>, Boolean> lambda = (Table<T> t) -> {
            String str = toCsvRow(t);
            try {
                out.write(str);
            } catch(IOException e){
            }
            return true;
        };

        //table.forEach(lambda);

        out.close();
    }

    public default String toCsvRow(Table<T> table) {
        StringBuilder str = new StringBuilder();

        for(Map.Entry<String, Object> entry : table.getColumns().entrySet()) {
            table.getField(entry.getKey());
            str.append(entry.getValue());
            str.append(",");
        }

        str.setLength(str.length() - 1);
        str.append("\n");

        return str.toString();
    }
}
