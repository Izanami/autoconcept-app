package tk.ap17.app.autoconcept.orm.serializable;

import java.nio.file.Path;

public interface SerializerTableCsv {

	public default boolean fromCsv(Path path) {

		return true;
	}

	public default boolean toCsv(Path path) {

		return true;
	}

	public default boolean fromCsv(String path) {

		return true;
	}

	public default boolean toCsv(String path) {

		return true;
	}
}
