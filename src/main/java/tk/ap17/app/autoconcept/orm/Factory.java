package tk.ap17.app.autoconcept.orm;

/**
 * Fabrique pour les operations de la classe Table.
 *
 * @author Adrien Jeser
 */
public interface Factory<T> {
    T create();
    T initialize();
}
