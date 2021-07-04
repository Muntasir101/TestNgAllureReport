package pages;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.JSErrorLogs;
import utils.logs.Log;

public class LoginPage extends BasePage {
    /**Constructor*/
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Web Elements
     */
    By userNameId                = By.id("input-email");
    By passwordId                = By.id("input-password");
    By loginButtonCSS            = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
    By errorMessageUsernameXpath = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordXpath = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");
    By errorMessage=By.xpath("//*[@id=\"account-login\"]/div[1]");

    /**
     * Page Methods
     */
    public LoginPage loginToOpencart(String username, String password) {
        Log.info("Trying to login the Opencart.");
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonCSS);
        return this;
    }

    //Verify Test Condition
    public LoginPage verifyLogin(String expectedText) {
        Log.info("Verifying login.");
        waitVisibility(errorMessage);
        assertEquals(readText(errorMessage), expectedText);
        return this;
    }
}