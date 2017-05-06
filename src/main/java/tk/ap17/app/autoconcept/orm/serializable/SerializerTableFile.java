package tk.ap17.app.autoconcept.orm.serializable;

import java.nio.file.Path;
import java.util.function.Function;

public interface SerializerTableFile {

	public default boolean toFile(Path path) {

		return true;
	}

	public default String fromFilePath(Path path) {

		return "";
	}

	public default boolean toFile(String path) {

		return true;
	}

	public default String fromFile(String path) {

		return "";
	}

	public default boolean fromFileEach(Function<String, Boolean> f) {

		return true;
	}
}
