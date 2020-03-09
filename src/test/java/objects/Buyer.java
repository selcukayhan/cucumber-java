package objects;

import org.openqa.selenium.WebDriver;


public class Buyer {

    private String email;
    private String password;
    private String name;
    private final WebDriver driver;

    public Buyer(String email, String password, String name, WebDriver driver) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.driver = driver;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Buyer login() {
        new HomePage(driver)
                .callLoginPage()
                .login(this);
        return this;
    }
}