package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.ActionHelper.scrollToWebElement;
import static helpers.ActionHelper.waitElementVisible;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement nextButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Open Login page in browser window.
     */
    public LoginPage openLoginPage() {
        driver.get("https://ws-test.keepit.com/desktop/signin");
        return this;
    }

    /**
     * Set email input.
     *
     * @param email the email to set
     */
    public LoginPage setEmailInput(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    /**
     * Login to the app with provided credentials.
     *
     * @param username username
     * @param password password
     */
    public LoginPage loginWithCredentials(String username, String password) {
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        submitButton.click();
        return this;
    }

    /**
     * Click on Sign in button.
     */
    public LoginPage clickOnSignInButton() {
        scrollToWebElement(driver, signInButton);
        waitElementVisible(driver, signInButton);
        signInButton.click();
        return this;
    }

    /**
     * Click on Next button.
     */
    public LoginPage clickOnNextInButton() {
        nextButton.click();
        return this;
    }
}
