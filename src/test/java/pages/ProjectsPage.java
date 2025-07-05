package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class ProjectsPage extends BasePage {

    private static final String ADD_PROJECT = "navigation-empty-addproject",
            ADD_EXAMPLE_PROJECT = "navigation-empty-addexampleproject",
            NAME_EXAMPLE_PROJECT = "addProjectName",
            SUBMIT_EXAMPLE_PROJECT = "addProjectSubmit",
            PROJECT_NAVIGATION = "navigation-overview-runs",
            DELETE_PROJECT = "/*[@data-testid='projectDeleteButton']",
            TEST_PROJECT = "Test project",
            CONFIRM_DELETE1 = "(//input[@type='checkbox'])[7]",
            CONFIRM_DELETE2 = "//*[@data-testid='caseFieldsTabDeleteDialogButtonOk']",
            PROJECT_DELETED = "Successfully deleted the project.",
            NAME_OF_PROJECT = "name",
            ACCESS_DROPDOWN = "projects-tabs-access",
            ACCESS_CHANGE = "access",
            ACCEPT = "accept";

    @Step("Проверка, открыла ли главная страница")
    public void isMainPageOpened() {
        log.info("Check is main page opened");
        $(byId(ADD_PROJECT)).shouldBe(visible);
    }

    @Step("Клик по кнопке добавление проекта-примера")
    public void addExampleProjectClick() {
        log.info("Click on button 'Add example project'");
        $(byId(ADD_EXAMPLE_PROJECT)).click();
    }

    @Step("Добавление названия и описания проекта-примера")
    public void addNameAndSubmit(String name, String submit) {
        log.info("SendKeys name and submit");
        $(byId(NAME_EXAMPLE_PROJECT)).sendKeys(name);
        $(byId(SUBMIT_EXAMPLE_PROJECT)).setValue(submit);
    }

    @Step("Клик по кнопке добавление нового проекта")
    public void addProject() {
        log.info("Click add project");
        $(byId(ADD_PROJECT)).click();
    }

    @Step("Проверка, открыт ли проект")
    public void isProjectOpen() {
        log.info("Check is project opened");
        $(byId(PROJECT_NAVIGATION)).shouldBe(visible, Duration.ofSeconds(75));
    }

    @Step("Открытие списка проектов")
    public void projectsListOpen() {
        log.info("Open projects list");
        projectListOpen();
    }

    @Step("Клик по кнопке удаления проекта")
    public void deleteProjectButtonClick() {
        log.info("Click on 'delete project'");
        $x(DELETE_PROJECT).click();
    }

    @Step("Подтверждение удаления проекта, клик")
    public void yesDeleteProjectClick() {
        log.info("Click on 'Yes delete project'");
        $x(CONFIRM_DELETE1).click();
        $x(CONFIRM_DELETE2).click();
    }

    @Step("Проверка, удален ли проект")
    public void isProjectDelete() {
        log.info("Check is project deleted");
        $(byText(PROJECT_DELETED)).shouldBe(visible);
    }

    @Step("Имя и описание проекта")
    public void nameProject(String name) {
        log.info("Send name of project");
        $(byId(NAME_OF_PROJECT)).sendKeys(name);
    }

    @Step("Нажатие на дропдаун")
    public void accessClick() {
        log.info("dropdown access click");
        $(byId(ACCESS_DROPDOWN)).click();
    }

    @Step("Изменение доступа в дропдауне")
    public void accessChoose() {
        log.info("Change access");
        $(byId(ACCESS_CHANGE)).selectOption("Lead");
    }

    @Step("Клик по кнопке создания проекта(подтверждение)")
    public void createProject() {
        log.info("Create project click");
        $(byId(ACCEPT)).click();
    }

    @Step("Проверка, создан ли проект")
    public void isProjectAdded() {
        log.info("Check is project Added");
        $(byText(TEST_PROJECT)).shouldBe(visible);
    }
}
