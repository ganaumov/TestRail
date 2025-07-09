package tests.api;

import adapters.ProjectAPI;
import models.ProjectRq;
import org.testng.annotations.Test;

public class ProjectAPITest {

    Integer project_id;

    ProjectRq rq = ProjectRq.builder()
            .name("Project")
            .announcement("New project")
            .show_announcement(false)
            .suite_mode(1)
            .build();

    @Test(priority = 1)
    public void createProjectTest() {
        project_id = ProjectAPI.createProject(rq);
    }

    @Test(priority = 2)
    public void getProjectTest() {
        ProjectAPI.getProject(project_id);
    }

    @Test(priority = 3)
    public void deleteProjectTest() {
        ProjectAPI.deleteProject(project_id);
    }
}