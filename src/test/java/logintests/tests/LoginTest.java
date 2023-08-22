package logintests.tests;

import com.codeborne.selenide.Configuration;
import logintests.Constants;
import logintests.pages.AccountUserPage;
import logintests.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LoginTest {
    LoginPage loginPage = new LoginPage();
    Constants constants = new Constants();
    AccountUserPage accountUserPage = new AccountUserPage();


    @Test
    public void loginTestPositive() {
        Configuration.timeout = 11000;
        loginPage.openPage();
        if (loginPage.cookieMessageExists()) {
            loginPage.closeCookiesMessage();
        }
        loginPage.checkOpenPage(constants.TITLE_PAGE);
        loginPage.setUserEmailAndPassword(constants.USER_EMAIL, constants.USER_PASSWORD);
        loginPage.clickButtonSubmit();
        accountUserPage.checkAccountPage();
        accountUserPage.checkUserName(constants.USER_TITLE_ON_PAGE);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
    public void loginTestNegative(String email, String password) {
        Configuration.timeout = 11000;
        loginPage.openPage();
        if (loginPage.cookieMessageExists()) {
            loginPage.closeCookiesMessage();
        }
        loginPage.setUserEmailAndPassword(email, password);

        if (loginPage.noAccountUserMessageExists()) {
            loginPage.checkNoAccountField();
        }
        loginPage.clickButtonSubmit();

        loginPage.checkErrorEmail(constants.ERROR_TEXT_COLOR,
                constants.MESSAGE_ERROR_EMAIL,
                constants.ERROR_BORDER_COLOR);

        loginPage.checkErrorPassword
                (constants.ERROR_TEXT_COLOR,
                        constants.MESSAGE_ERROR_PASSWORD,
                        constants.ERROR_BORDER_COLOR);
    }


}
