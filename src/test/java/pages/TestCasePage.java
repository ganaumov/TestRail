package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TestCasePage extends BasePage {

    private static final String TEST_CASES = "navigation-suites-dropdown",
            PRECONDITIONS = "custom_preconds_display",
            EXPECTED_RESULTS = "custom_expected_display",
            STEPS = "custom_steps_display",
            ADD_TESTCASE = "//*[@id='inlineSectionActions-2950']/a[1]",
            TESTCASE_TITLE = "addCaseTitle",
            ACCEPT_BUTTON = "//*[@data-testid='iconButtonAccept']",
            ACCEPT = "accept",
            TEST_CASE_EDIT_BUTTON = "//*[@data-testid='testCaseEditButton']",
            CASE_NAME = "NameOfCase";

    @Step("Открытие страницы с проектами")
    public void openProjectPage() {
        log.info("Open project page");
        openProject();
    }

    @Step("Открытите страницы тест кейсов")
    public void openTestCases() {
        log.info("Open test case");
        $(byId(TEST_CASES)).click();
    }

    @Step("Клик по кнопке добавления тест кейса")
    public void addTestCaseClick(String title) {
        log.info("Click on AddTestCase button");
        $x(ADD_TESTCASE).click();
        $(byId(TESTCASE_TITLE)).setValue(title);
        $x(ACCEPT_BUTTON).click();
    }

    @Step("Заполнение обязательных полей: precondition, steps, expected")
    public void writeDescription(String precondition, String steps, String expected) {
        log.info("Create Description for TestCase");
        $(byText(CASE_NAME)).click();
        $x(TEST_CASE_EDIT_BUTTON).click();
        $(byId(PRECONDITIONS)).click();
        $(byId(PRECONDITIONS)).setValue(precondition);
        $(byId(STEPS)).setValue(steps);
        $(byId(EXPECTED_RESULTS)).setValue(expected);
    }

    @Step("Клик по кнопке, подстверждающей создание тест кейса")
    public void createTestCase() {
        log.info("Click on Create test case");
        $(byId(ACCEPT)).click();
    }
}
