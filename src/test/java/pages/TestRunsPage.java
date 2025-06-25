package pages;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestRunsPage {

    public void openPage() {
        open("https://bigcheesegana.testrail.io/index.php?/runs/overview/20");
    }

    public void addTestRun() {
        $(byXpath("//a[contains(text(),'Add Test Run')]")).click();
        $(byId("accept")).click();
    }

    public void doTestRun() {
        $(byXpath("//tr@class='header'//th@class='checkbox'//input")).click();
        $("input[onclick='App.Tests.onToggleAllClick(this)']").click();
        $(byXpath("//a[@id='massAddResult']//span[@class='button-text'][normalize-space()='Add Results']")).click();
        $(byId("addResultSubmit")).click();
    }
}
