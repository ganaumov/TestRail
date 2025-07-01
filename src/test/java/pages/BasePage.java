package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class BasePage {

    private static final String LOGIN_PAGE = "https://bigcheesegana.testrail.io/index.php?/dashboard",
            PROJECT_LIST_OPEN = "https://bigcheesegana.testrail.io/index.php?/admin/projects/overview",
            OPEN_PROJECT = "//a[contains(text(),'Test project')]";

    @Step("Открытие страницы входа на сайт")
    public void openPage() {
        open(LOGIN_PAGE);
    }

    @Step("Открытие спсика проектов")
    public void projectListOpen() {
        open(PROJECT_LIST_OPEN);
    }

    @Step("Открытие созданного проекта")
    public void openProject() {
        String fullUrl = $(byXpath(OPEN_PROJECT)).getAttribute("href");
        open(fullUrl);
    }
}
