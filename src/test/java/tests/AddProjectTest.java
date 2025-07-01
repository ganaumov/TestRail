package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Description("Создание и удаление автозаполненного проекта-примера")
    @Test(testName = "Создание example project")
    public void addExampleProjectTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.openPage();
        projectsPage.addExampleProjectClick();
        projectsPage.addNameAndSubmit("Test project","");
        projectsPage.isProjectOpen();
        projectsPage.projectsListOpen();
        projectsPage.deleteProjectButtonClick();
        projectsPage.yesDeleteProjectClick();
        projectsPage.isProjectDelete();
    }

    @Description("Создание нового проекта")
    @Test(testName = "Создание new project")
    public void addProject() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.isMainPageOpened();
        projectsPage.addProject();
        projectsPage.nameProject("Test project");
        projectsPage.accessClick();
        projectsPage.accessChoose();
        projectsPage.createProject();
        projectsPage.isProjectAdded();
    }
}
