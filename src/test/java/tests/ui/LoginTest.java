package tests.ui;

import jdk.jfr.Description;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import tests.BaseTest;

public class LoginTest extends BaseTest {
    @BeforeClass(alwaysRun = true)
    public void setUpData() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        softly = new SoftAssertions();
    }

    @Test()
    @Description("This test verifies sure that it is possible to create an Office 365 Admin")
    public void verifyCreateOffice() {
        loginPage.openLoginPage()
                .loginWithCredentials(getProperties().getProperty("username"),
                        getProperties().getProperty("password"));

        dashboardPage.clickOnConnectorsButton()
                .clickOnAddConnectorButton();


        dashboardPage.clickOnAddMicrosoft365Connector();

        loginPage.clickOnSignInButton()
                .setEmailInput(getProperties().getProperty("username"))
                .clickOnNextInButton();

        //Not implemented due to login issue
        //softly.assertThat();

    }
}
