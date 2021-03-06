package configuration;

public abstract class Config {

    public static final String MAIN_URL = "https://www.amazon.com/";
    public static final int WAITTIME_TIMEOUT = 60;
    public static final int WAITTIME_ELEMENTOCCURENCE = 15;
    public static final int WAITTIME_SMALL = 5;
    public static final String DEFAULT_USERNAME = "selcuk";
    public static final String DEFAULT_EMAIL = "testUser@test.com";
    public static final String DEFAULT_PASSWORD = "passwrod";
    public static final String INVALID_PASSWORD = "invalid";
    public static final String DROPBOX_ACCESS_TOKEN = "";

    private Config() {
    }
}
