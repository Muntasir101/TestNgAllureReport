package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;

public class HomePage extends BasePage {
    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Variables
     */
    String baseURL = "http://demo.opencart.com/";

    /**
     * Web Elements
     */
    By MyAccountLinkText = By.linkText("My Account");
    By LoginButtonLinkText = By.linkText("Login");

    /**
     * Page Methods
     */
    //Go to Homepage
    public HomePage goToOpencart() {
        Log.info("Opening N11 Website.");
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public LoginPage goToLoginPage() {
        Log.info("Going to Login Page..");
        click(MyAccountLinkText);
        click(LoginButtonLinkText);
        return new LoginPage(driver);
    }
}