package de.exceptionflug.realms.api;

/**
 * An {@link Action} is the result of most of the methods provided by the api.
 * Those methods are likely rate-limited by the implementation in order to prevent
 * abuse or any stress on the Cytooxien backend systems.
 *
 * Date: 30.06.2021
 *
 * @author Exceptionflug
 * @param <T> Return type, if any, for the method result
 */
public interface Action<T> {

    /**
     * Returns if the action was successful.
     * @return true if the action was successful, false otherwise.
     */
    boolean success();

    /**
     * Returns the whether this action was rate-limited. If an action is rate-limited, it hasn't been executed.
     * success() will also return false.
     *
     * @return True if the action has been rate-limited
     */
    boolean rateLimited();

    /**
     * A failed action can additionally have a {@link Throwable} attached to it.<br>
     * NOTE: A non present Throwable is no indicator if the action was successful! Check success() instead!
     *
     * @return The throwable or null if not present
     */
    Throwable throwable();

    /**
     * The value provided by the executed method.
     * @return The value or null if no value was returned
     */
    T value();

}
