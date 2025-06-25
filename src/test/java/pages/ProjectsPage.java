package pages;

import java.io.UncheckedIOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    private static final String ADD_PROJECT = "navigation-empty-addproject";
    private static final String PROJECT_NAME = "name";
    private static final String ANNOUNCEMENT = "announcement";

    public void openPage() {
        open("https://bigcheesegana.testrail.io/index.php?/dashboard");
    }

    public void isPageOpened() {
        $(byId(ADD_PROJECT)).shouldBe(visible);

    }

    public void addProject() {
        $(byId(ADD_PROJECT)).click();
    }

    public void isProjectOpen() {
        $(byId("navigation-overview-runs")).shouldBe(visible, Duration.ofSeconds(75));
    }

    public void projectsListOpen() {
        open("https://bigcheesegana.testrail.io/index.php?/admin/projects/overview");
    }

    public void deleteProjectButtonClick() {
        $(byXpath("//*[@data-testid='projectDeleteButton']")).click();
    }

    public void yesDeleteProject() {
        //$(byName("deleteCheckbox")).shouldBe(hidden);
        $(byXpath("(//input[@type='checkbox'])[7]")).click();
        //$(byName("deleteCheckbox")).shouldBe(checked);
        $(byXpath("//*[@data-testid='caseFieldsTabDeleteDialogButtonOk']")).click();
    }

    public void isProjectDelete() {
        $(byText("Successfully deleted the project.")).shouldBe(visible);
    }

    public void nameAndAnnouncementProject(String name, String announcement) {
        $(byId("name")).sendKeys(name);
        $(byId("announcement_display")).sendKeys(announcement);
    }

    public void accessClick() {
        $(byId("projects-tabs-access")).click();
    }

    public void accessChoose() {
        $(byId("access")).selectOption("Lead");
    }

    public void createProject() {
        $(byId("accept")).click();
    }

    public void isProjectAdded() {
        $(byText("Test project")).shouldBe(visible);
    }
}
