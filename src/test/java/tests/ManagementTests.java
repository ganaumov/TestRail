package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ManagementTests extends BaseTest {

    @Description("Тестовое создание и редактирование тест кейса")
    @Test(description = "создание и редактирование тест-кейса", priority = 1, groups = {"smoke"})
    public void createTestCase() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.openPage();
        testCasePage.openProjectPage();
        testCasePage.openTestCases();
        testCasePage.addTestCaseClick("NameOfCase");
        testCasePage.writeDescription("open Google", "1,2,3", "all okay");
        testCasePage.createTestCase();
    }

    @Description("Добавление testRun по выполнению тест кейсов")
    @Test(testName = "создание test run", priority = 2, groups = {"smoke"})
    public void addTestRun() {
        loginPage.openPage();
        loginPage.login(user, password);
        testRunsPage.openPage();
        testRunsPage.addTestRun();
    }
}
