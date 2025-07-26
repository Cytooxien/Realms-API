package de.cytooxien.realms.api;

import de.cytooxien.realms.api.model.Boost;
import de.cytooxien.realms.api.model.Limits;
import net.kyori.adventure.text.Component;

import java.util.List;
import java.util.UUID;

/**
 * This interface provides basic information about the realm.
 * It is possible to update some realm settings here like
 * the maximum allowed player count, the name or some other stuff.
 * <br><br>
 * Date: 30.06.2021
 * @author Exceptionflug
 */
public interface RealmInformationProvider {

    /**
     * Returns the display name of the realm which is visible in the tab list or in the realm overview
     * menu on the lobby. This method is not rate limited.
     *
     * @return the display name of the realm.
     */
    Component realmDisplayName();

    /**
     * Returns the description of the realm which is visible in the realm overview
     * menu on the lobby. This method is not rate limited.
     *
     * @return the description of the realm.
     */
    String description();

    /**
     * @return true if the realm is private, false otherwise
     */
    boolean privateRealm();

    /**
     * @return the currently allowed maximum player count
     */
    int maxPlayers();

    /**
     * @return the amount of currently active boosts
     */
    int boostCount();

    /**
     * This will query all active boosts a realm has.
     * @return {@link List<Boost>} of all active boosts
     */
    Action<Boost[]> boosts();

    /**
     * Limits are specified by the realm boost level.
     *
     * @return the current realm limits
     */
    Limits limits();

    /**
     * The promotion state of the realm. A promoted realm will always be shown first on the lobby's
     * realm overview menu and at the banner stand. Only VIPs and higher are privileged to mark a realm as promoted.
     *
     * <br><br> Since a realm doesn't know its promotion state, it has to be requested at the Cytooxien Realms
     * Backend Management service. So this method returns an {@link Action} and is rate-limited.
     *
     * @return The action containing information about the promotion state of the realm.
     */
    Action<Boolean> promotedRealm();

    /**
     * A realm is able to have its own address. Using this address, players can directly join onto the running realm
     * without joining on Cytooxien first.
     *
     * <br><br> Since a realm doesn't know its subdomain, it has to be requested at the Cytooxien Realms
     * Backend Management service. So this method returns an {@link Action} and is rate-limited.
     *
     * @return The action containing the FQDN under which the realm can also be joined.
     */
    Action<String> subdomain();

    /**
     * This changes the display name of the realm. The new name of the realm must not exceed 32 characters and mustn't
     * be null or empty. Otherwise, this action will fail.
     *
     * <br><br> Since this has to be requested at the Cytooxien Realms
     * Backend Management service, this method returns an {@link Action} and is rate-limited.
     * @param name The new name of the realm as legacy formatted string (supporting section color codes)
     * @return the action containing the success state
     */
    Action<Void> changeName(String name);

    /**
     * This changes the display name of the realm. The new name of the realm must not exceed 32 characters and mustn't
     * be null or empty. Otherwise, this action will fail.
     *
     * <br><br> Since this has to be requested at the Cytooxien Realms
     * Backend Management service, this method returns an {@link Action} and is rate-limited.
     * @param name The new name of the realm as adventure component
     * @return the action containing the success state
     */
    Action<Void> changeName(Component name);

    /**
     * This changes the description of the realm. The new description of the realm must not exceed 128 characters otherwise this action will fail.
     *
     * <br><br> Since this has to be requested at the Cytooxien Realms
     * Backend Management service, this method returns an {@link Action} and is rate-limited.
     * @param description The new realm description
     * @return the action containing the success state
     */
    Action<Void> changeDescription(String description);

    /**
     * This changes the maximum allowed player count of the realm. The new player count of the realm must
     * not exceed the maximum player count specified by the {@link Limits} object otherwise this action will fail.
     *
     * <br><br> Since this has to be requested at the Cytooxien Realms
     * Backend Management service, this method returns an {@link Action} and is rate-limited.
     *
     * @param maxPlayers The new maximum player count
     * @return the action containing the success state
     */
    Action<Void> updateMaximumPlayers(int maxPlayers);

    /**
     * This changes the privacy state of the realm.
     *
     * <br><br> Since this has to be requested at the Cytooxien Realms
     * Backend Management service, this method returns an {@link Action} and is rate-limited.
     *
     * @param privateRealm true if the realm is private false otherwise
     * @return the action containing the success state
     */
    Action<Void> updatePrivacyState(boolean privateRealm);

}
