package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.TestRunsPage;

@Log4j2
public class ManegmantTests extends BaseTest {

    @Description("Тестовое создание и редактирование тест кейса")
    @Test(description = "создание и редактирование тест-кейса")
    public void createTestCase() {
        log.info("create TestCase");
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.openPage();
        testCasePage.openProject();
        testCasePage.openTestCases();
        testCasePage.addTestCaseClick("NameOfCase");
        testCasePage.writeDescription("open Google", "1,2,3", "all okay");
        testCasePage.createTestCase();
    }

    @Description("Добавление testRun по выполнению тест кейсов")
    @Test(testName = "создание test run")
    public void addTestRun() {
        log.info("create new TestRun");
        loginPage.openPage();
        loginPage.login(user, password);
        testRunsPage.openPage();
        testRunsPage.addTestRun();
        //testRunsPage.doTestRun();
    }
}
