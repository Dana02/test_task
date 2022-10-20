package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionHelper {
    private static WebDriverWait wait;
    private static JavascriptExecutor js;

    /**
     * Wait until web element is visible.
     *
     * @param driver     the driver
     * @param webElement the web element to wait
     */
    public static void waitElementVisible(WebDriver driver, WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Scroll to web element.
     *
     * @param webElement to scroll to
     */
    public static void scrollToWebElement(WebDriver driver, WebElement webElement) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
