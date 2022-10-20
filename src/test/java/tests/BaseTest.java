package tests;

import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import pages.DashboardPage;
import pages.LoginPage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTest {
    private static Properties properties;
    protected SoftAssertions softly;
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    public static Properties getProperties() {
        return properties;
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        properties = loadProperties();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bdobu\\chromedriver.exe"); //TODO - this needs to be changed
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * This method will load properties to the stream, so they are accessible.
     *
     * @return {@link Properties} in stream.
     */
    public static Properties loadProperties() {
        Properties p = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("configs.properties");
        try {
            p.load(stream);
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
        return p;
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
