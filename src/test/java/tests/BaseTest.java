package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.TestCasePage;
import pages.TestRunsPage;
import utils.PropertyReader;
import utils.TestListener;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectsPage;
    TestCasePage testCasePage;
    TestRunsPage testRunsPage;

    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));


    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.timeout = 25000;
        Configuration.clickViaJs = true;
        Configuration.headless = true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        Configuration.browserCapabilities = options;

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        testCasePage = new TestCasePage();
        testRunsPage = new TestRunsPage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
