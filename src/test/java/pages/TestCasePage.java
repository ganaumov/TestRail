package pages;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestCasePage {

    private static final String TEST_CASES = "navigation-suites-dropdown";
    private static final String TITLE = "title";
    private static final String PRECONDITIONS = "custom_preconds_display";
    private static final String EXPECTED_RESULTS = "custom_expected_display";
    private static final String STEPS = "custom_steps_display";

    public void openProject() {
        String fullUrl = $(byXpath("//a[contains(text(),'Test project')]")).getAttribute("href");
        open(fullUrl);
    }

    public void openTestCases() {
        $(byId(TEST_CASES)).click();
    }

    public void addTestCaseClick(String title) {
        $(byXpath("//*[@id='inlineSectionActions-2950']/a[1]")).click();
        $(byId("addCaseTitle")).setValue(title);
        $(byXpath("//*[@data-testid='iconButtonAccept']")).click();
    }

    public void writeDescription(String precondition, String steps, String expected) {

        $(byText("NameOfCase")).click();
        $(byXpath("//*[@data-testid='testCaseEditButton']")).click();
        $(byId(PRECONDITIONS)).click();
        $(byId(PRECONDITIONS)).setValue(precondition);
        $(byId(STEPS)).setValue(steps);
        $(byId(EXPECTED_RESULTS)).setValue(expected);
    }

    public void createTestCase() {
        $(byId("accept")).click();
    }

    public void isTestCaseCreate() {
        $(byText("Successfully updated the test case.")).shouldBe(visible);
    }

    //public void deleteAllCases() {
    //$(byXpath("//*[@onclick='App.Cases.onToggleAllClick(this)']")).click();
    //$(byId("deleteCases")).click();
    //$(byXpath("//*[@class='button button-left button-positive" +
    //" button-no-margin-right dialog-action-secondary button-black']")).click();
    //$(".button.dialog-action-default[data-testid='deleteCaseDialogActionDefault']").pressEnter();

}
