package tk.ap17.app.autoconcept.orm.serializable;

import java.nio.file.Path;

public interface SerializerTableSql {

	public default boolean fromSql(Path path) {

		return true;
	}

	public default boolean toSql(Path path) {

		return true;
	}

	public default boolean fromSql(String path) {

		return true;
	}

	public default boolean toSql(String path) {

		return true;
	}

}
