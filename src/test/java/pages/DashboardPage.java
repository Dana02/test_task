package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.ActionHelper.waitElementVisible;

public class DashboardPage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[text()='Connectors']")
    private WebElement connectorsButton;

    @FindBy(xpath = "//button[text()='Add connector']")
    private WebElement addConnectorButton;

    @FindBy(xpath = "//span[text()='Add Microsoft 365 connector']")
    private WebElement addMicrosoft365ConnectorButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click on connectors button.
     */
    public DashboardPage clickOnConnectorsButton() {
        connectorsButton.click();
        return this;
    }

    /**
     * Click on add connectors button.
     */
    public DashboardPage clickOnAddConnectorButton() {
        waitElementVisible(driver, addConnectorButton);
        addConnectorButton.click();
        return this;
    }

    /**
     * Click on add Microsoft 365 connector button.
     */
    public DashboardPage clickOnAddMicrosoft365Connector() {
        waitElementVisible(driver, addMicrosoft365ConnectorButton);
        addMicrosoft365ConnectorButton.click();
        return this;
    }
}
