package se.kth.ki.waitapp.core.model.user;

public enum AuthLevels {
    /** The user is not logged in. */
    NOT_LOGGED_IN,

    /** The user is logged in but has not provided necessary data. */
    NO_DATA_PROVIDED,

    /** The user is logged in and has provided the necessary data. */
    LOGGED_IN,

    /**
     * The user has a higher level of authentication.
     * Is not currently used, here for features in the future
     */
    HIGHER_AUTH_LEVEL,
}