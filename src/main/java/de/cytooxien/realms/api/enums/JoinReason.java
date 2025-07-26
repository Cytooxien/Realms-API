package de.cytooxien.realms.api.enums;

public enum JoinReason {

    /**
     * The player joined the realm directly, by connecting via server address.
     */
    DIRECT,

    /**
     * The player joined the realm through the lobby.
     */
    LOBBY,

    /**
     * The player joined using a "JoinMe" invitation.
     */
    JOINME,

    /**
     * The player joined by jumping to a friend.
     */
    FRIEND_JUMP
}
