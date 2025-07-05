package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class LoginPage extends BasePage {

    private static final String LOGIN_FIELD = "[name=name]",
            PASSWORD_FIELD = "[name=password]",
            LOG_IN = "#button_primary",
            FORGOT_PASS = "loginpage-forgotpassword",
            DASHBOARD = "Dashboard",
            RESET_PASSWORD_PAGE = "Reset Your Password",
            LOGIN_PASSWORD_ALERT = "Email/Login is required.",
            PASSWORD_REQUIRED_ALERT = "Password is required.",
            UNCORRECTED_DATA = "Sorry, there was a problem.";

    @Step("Открытие страницы")
    public void openLoginPage() {
        log.info("Open login page");
        openPage();
    }

    @Step("Логин {user} {password}")
    public void login(String user, String password) {
        log.info("login with login and password");
        $(LOGIN_FIELD).setValue(user);
        $(PASSWORD_FIELD).setValue(password);
        $(LOG_IN).click();
    }

    @Step("Проверка, открыта ли главная страница")
    public void isMainPageOpen() {
        log.info("check is main page opened");
        $(byText(DASHBOARD)).shouldBe(visible);
    }

    @Step("Нажатие на кнопку 'забыл пароль'")
    public void forgotPasswordClick() {
        log.info("click on button forgot password");
        $(byClassName(FORGOT_PASS)).click();
    }

    @Step("Проверка, открыта ли страница сброса пароля")
    public void forgotPasswordIsOpen() {
        log.info("Check is page forgot password opened");
        $(byText(RESET_PASSWORD_PAGE)).shouldBe(visible);
    }

    @Step("Проверка ошибки Логина")
    public void loginErrorAssert() {
        log.info("Error message Login check");
        $(byText(LOGIN_PASSWORD_ALERT)).shouldBe(visible);
    }

    @Step("Проверка ошибки Пароля")
    public void passwordErrorAssert() {
        log.info("Error message Password check");
        $(byText(PASSWORD_REQUIRED_ALERT)).shouldBe(visible);
    }

    @Step("Проверка ошибки 'некорректные данные'")
    public void notCorrectDataAssert() {
        log.info("Error message UnCorrected data check");
        $(byText(UNCORRECTED_DATA)).shouldBe(visible);
    }
}
