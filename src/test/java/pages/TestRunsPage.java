package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class TestRunsPage extends BasePage {

    public static final String ADD_TEST_RUN = "//a[contains(text(),'Add Test Run')]",
            ACCEPT = "accept";

    @Step("Добавить 'тест ран'")
    public void addTestRun() {
        log.info("Add test run");
        $(byXpath(ADD_TEST_RUN)).click();
        $(byId(ACCEPT)).click();
    }
}
