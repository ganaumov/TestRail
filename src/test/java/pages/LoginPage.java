package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final String LOGIN_FIELD = "[name=name]";
    private static final String PASSWORD_FIELD = "[name=password]";
    private static final String LOG_IN = "button_primary";
    private static final String FORGOT_PASS = "loginpage-forgotpassword";


    public void openPage() {
        open("https://bigcheesegana.testrail.io/index.php?/auth/login");
    }

    public void login(String user, String password) {
        $(LOGIN_FIELD).setValue(user);
        $(PASSWORD_FIELD).setValue(password);
        $(byId(LOG_IN)).click();
    }

    public void isMainPageOpen() {
        $(byText("Dashboard")).shouldBe(visible);
    }

    public void forgotPasswordClick() {
        $(byClassName(FORGOT_PASS)).click();
    }

    public void forgotPasswordIsOpen() {
        $(byText("Reset Your Password")).shouldBe(visible);
    }

    public void loginErrorAssert() {
        $(byText("Email/Login is required.")).shouldBe(visible);
    }

    public void passwordErrorAssert() {
        $(byText("Password is required.")).shouldBe(visible);
    }

    public void notCorrectDataAssert() {
        $(byText("Sorry, there was a problem.")).shouldBe(visible);
    }

}
