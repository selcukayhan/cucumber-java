package objects;

import configuration.Config;
import org.openqa.selenium.WebDriver;

public class BuyerPool {

    private BuyerPool() {
    }

    public static Buyer defaultUser(WebDriver driver) {
        return new Buyer(Config.DEFAULT_EMAIL, Config.DEFAULT_PASSWORD, Config.DEFAULT_USERNAME, driver);
    }

    public static Buyer invalidLoginUser(WebDriver driver) {
        return new Buyer("buyer@email.com", Config.INVALID_PASSWORD, Config.DEFAULT_USERNAME, driver);
    }
}
