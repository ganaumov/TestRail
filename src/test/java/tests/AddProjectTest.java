package tests;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ProjectsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class AddProjectTest extends BaseTest {

    @Description("Создание и удаление автозаполненного проекта-примера")
    @Test(testName = "Создание example project",
            description = "проверка автозаполнения проекта при создании example project")
    public void addExampleProjectTest() {
        log.info("create example project");
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.openPage();
        $(byId("navigation-empty-addexampleproject")).click();
        $(byId("addProjectName")).sendKeys("Test project");
        $(byId("addProjectSubmit")).click();
        projectsPage.isProjectOpen();
        projectsPage.projectsListOpen();
        projectsPage.deleteProjectButtonClick();
        projectsPage.yesDeleteProject();
        projectsPage.isProjectDelete();
    }

    @Description("Создание нового проекта")
    @Test(testName = "Создание new project",
            description = "создание стандартного проекта + смена формы доступа")
    public void addProject() {
        log.info("create new project");
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.isPageOpened();
        projectsPage.addProject();
        projectsPage.nameAndAnnouncementProject("Test project", "Testing project!");
        projectsPage.accessClick();
        projectsPage.accessChoose();
        projectsPage.createProject();
        projectsPage.isProjectAdded();
    }
}
