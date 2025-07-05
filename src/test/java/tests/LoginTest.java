package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Description("Проверка входа на сайт")
    @Test(testName = "Проверка входа в систему с верными данными", priority = 8, groups = {"smoke"})
    public void positiveLogin() {
        loginPage.openLoginPage();
        loginPage.login(user, password);
        loginPage.isMainPageOpen();
    }

    @Description("Проверка перехода на страницу сброса пароля")
    @Test(testName = "Проверка работы перехода на страницу сброс пороля", priority = 7, groups = {"smoke"})
    public void forgotPassword() {
        loginPage.openPage();
        loginPage.forgotPasswordClick();
        loginPage.forgotPasswordIsOpen();
    }

    @Description("Проверка логина с пустым полем логина")
    @Test(testName = "Проверка логина в систему (пустой логин)", priority = 6)
    public void loginWithoutMail() {
        loginPage.openPage();
        loginPage.login("", password);
        loginPage.loginErrorAssert();
    }

    @Description("Проверка логина с пустым полем пароля")
    @Test(testName = "Проверка логина в систему (пустой пароль)", priority = 5)
    public void loginWithoutPassword() {
        loginPage.openPage();
        loginPage.login(user, "");
        loginPage.passwordErrorAssert();
    }

    @Description("Проверка входа без ввода данных")
    @Test(testName = "Проверка логина в систему с пустыми строками данных", priority = 4, groups = {"smoke"})
    public void loginWithNoData() {
        loginPage.openPage();
        loginPage.login("", "");
        loginPage.loginErrorAssert();
        loginPage.passwordErrorAssert();
    }

    @Description("Проверка входа с неверными данными")
    @Test(testName = "Проверка логина в систему с некорректными данными", priority = 1, groups = {"smoke"})
    public void loginWithNotCorrectData() {
        loginPage.openPage();
        loginPage.login("sdfaw@fsdf.su", "231223dfsdf");
        loginPage.notCorrectDataAssert();
    }

    @Description("Проверка входа с неверным логином")
    @Test(testName = "Проверка логина в систему с некорректным логином", priority = 2)
    public void loginWithNotCorrectMail() {
        loginPage.openPage();
        loginPage.login("sdfaw@fsdf.su", password);
        loginPage.notCorrectDataAssert();
    }

    @Description("Проверка входа с неверным паролем")
    @Test(testName = "Проверка логина в систему с некорректным паролем", priority = 3)
    public void loginWithNotCorrectPassword() {
        loginPage.openPage();
        loginPage.login(user, "sdfsfg");
        loginPage.notCorrectDataAssert();
    }
}
