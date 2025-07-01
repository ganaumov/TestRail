package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Description("Проверка входа на сайт")
    @Test(testName = "Проверка входа в систему с верными данными")
    public void PositiveLogin() {
        loginPage.openLoginPage();
        loginPage.login(user, password);
        loginPage.isMainPageOpen();
    }

    @Description("Проверка перехода на страницу сброса пароля")
    @Test(testName = "Проверка работы перехода на страницу сброс пороля")
    public void ForgotPassword() {
        loginPage.openPage();
        loginPage.forgotPasswordClick();
        loginPage.forgotPasswordIsOpen();
    }

    @Description("Проверка логина с пустым полем логина")
    @Test(testName = "Проверка логина в систему (пустой логин)")
    public void LoginWithoutMail() {
        loginPage.openPage();
        loginPage.login("", password);
        loginPage.loginErrorAssert();
    }

    @Description("Проверка логина с пустым полем пароля")
    @Test(testName = "Проверка логина в систему (пустой пароль)")
    public void LoginWithoutPassword() {
        loginPage.openPage();
        loginPage.login(user, "");
        loginPage.passwordErrorAssert();
    }

    @Description("Проверка входа без ввода данных")
    @Test(testName = "Проверка логина в систему с пустыми строками данных")
    public void LoginWithNoData() {
        loginPage.openPage();
        loginPage.login("", "");
        loginPage.loginErrorAssert();
        loginPage.passwordErrorAssert();
    }

    @Description("Проверка входа с неверными данными")
    @Test(testName = "Проверка логина в систему с некорректными данными")
    public void LoginWithNotCorrectData() {
        loginPage.openPage();
        loginPage.login("sdfaw@fsdf.su", "231223dfsdf");
        loginPage.notCorrectDataAssert();
    }

    @Description("Проверка входа с неверным логином")
    @Test(testName = "Проверка логина в систему с некорректным логином")
    public void LoginWithNotCorrectMail() {
        loginPage.openPage();
        loginPage.login("sdfaw@fsdf.su", password);
        loginPage.notCorrectDataAssert();
    }

    @Description("Проверка входа с неверным паролем")
    @Test(testName = "Проверка логина в систему с некорректным паролем")
    public void LoginWithNotCorrectPassword() {
        loginPage.openPage();
        loginPage.login(user, "sdfsfg");
        loginPage.notCorrectDataAssert();
    }
}
