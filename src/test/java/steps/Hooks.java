package steps;

import configuration.Config;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.rmi.Remote;

public class Hooks {

    public static WebDriver driver;
    public static String runEnv = System.getProperty("runEnv").toLowerCase();

    @Before
    public void setUp() throws Exception {
        switch (runEnv) {
            case "docker":
                driver = getRemoteDriver();
                driver.get(Config.MAIN_URL);
                break;
            default:
                driver = getLocalDriver();
                driver.get(Config.MAIN_URL);
                break;
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getRemoteDriver() throws Exception {
        try {
            return new RemoteWebDriver(new URL("http://127.0.0.1:4444"),remoteDriverCapabilities());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public WebDriver getLocalDriver() {
        return new ChromeDriver();
    }

    public DesiredCapabilities remoteDriverCapabilities(){
        new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        chromeOptions.addArguments("window-size=1280,1024");
        capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        return capabilities;
    }
}
