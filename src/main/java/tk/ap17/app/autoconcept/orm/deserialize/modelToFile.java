package tk.ap17.app.autoconcept.orm.deserialize;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

import tk.ap17.app.autoconcept.orm.Table;

public interface modelToFile<T extends Table<T>> {
    public Table<T> getTable();

    //public default void toFile(Function<Table<T>, Boolean> lambda) throws FileNotFoundException, IOException {
        //Table<T> table = getTable();

        //////for(Map.Entry<String, Object> entry : table.getColumns().entrySet()) {
            //////String key = entry.getKey();
            //////HashMap value = entry.getValue();

            ////// do what you have to do here
            ////// In your case, an other loop.
        //////}

        ////BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("dist"));


        ////out.close();
        //return true;
    //}
}
