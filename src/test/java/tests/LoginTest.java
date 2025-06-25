package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Log4j2
@Slf4j
public class LoginTest extends BaseTest {

    @Description("Проверка входа на сайт")
    @Test(testName = "Проверка входа в систему с верными данными",
            description = "проверяем вход систему с верными данными для входа")
    public void PositiveLogin() {
        log.info("login positive");
        loginPage.openPage();
        loginPage.login(user, password);
        loginPage.isMainPageOpen();
    }

    @Description("Проверка перехода на страницу сброса пароля")
    @Test(testName = "Проверка работы перехода на страницу сброс пороля",
            description = "проверяем переход на страницу сброса пароля")
    public void ForgotPassword() {
        log.info("login -> open forgot password page");
        loginPage.openPage();
        loginPage.forgotPasswordClick();
        loginPage.forgotPasswordIsOpen();
    }

    @Description("Проверка логина с пустым полем логина")
    @Test(testName = "Проверка логина в систему (пустой логин)",
            description = "проверяем вход систему с пустым логином")
    public void LoginWithoutMail() {
        log.info("login with empty login");
        loginPage.openPage();
        loginPage.login("", password);
        loginPage.loginErrorAssert();
    }

    @Description("Проверка логина с пустым полем пароля")
    @Test(testName = "Проверка логина в систему (пустой пароль)",
            description = "проверяем вход систему с пустым паролем")
    public void LoginWithoutPassword() {
        log.info("login with empty password");
        loginPage.openPage();
        loginPage.login(user, "");
        loginPage.passwordErrorAssert();
    }

    @Description("Проверка входа без ввода данных")
    @Test(testName = "Проверка логина в систему с пустыми строками данных",
            description = "проверяем вход систему без ввода данных")
    public void LoginWithNoData() {
        log.info("login without data");
        loginPage.openPage();
        loginPage.login("", "");
        loginPage.loginErrorAssert();
        loginPage.passwordErrorAssert();
    }

    @Description("Проверка входа с неверными данными")
    @Test(testName = "Проверка логина в систему с некорректными данными",
            description = "проверяем вход систему с невалидным логином и паролем")
    public void LoginWithNotCorrectData() {
        log.info("login with not correct login/password");
        loginPage.openPage();
        loginPage.login("sdfaw@fsdf.su", "231223dfsdf");
        loginPage.notCorrectDataAssert();
    }

    @Description("Проверка входа с неверным логином")
    @Test(testName = "Проверка логина в систему с некорректным логином",
            description = "проверяем вход систему с невалидным логином")
    public void LoginWithNotCorrectMail() {
        log.info("login with not correct login");
        loginPage.openPage();
        loginPage.login("sdfaw@fsdf.su", password);
        loginPage.notCorrectDataAssert();
    }

    @Description("Проверка входа с неверным паролем")
    @Test(testName = "Проверка логина в систему с некорректным паролем",
            description = "проверяем вход систему с невалидным паролем")
    public void LoginWithNotCorrectPassword() {
        log.info("login with not correct password");
        loginPage.openPage();
        loginPage.login(user, "sdfsfg");
        loginPage.notCorrectDataAssert();
    }
}
