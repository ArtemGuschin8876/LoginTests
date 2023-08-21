package logintests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final String URL = "https://account.asus.com/loginform.aspx?skey=1d2642cc6fac4bc1bf32ae7df66ece56";
    private static final SelenideElement EMAIL_FIELD = $("#txtMail");
    private static final SelenideElement PASSWORD_FIELD = $("#txtPassword1");
    private static final SelenideElement SUBMIT_BUTTON = $("[type='submit']");
    private static final SelenideElement SUB_TITLE = $(".LoginPage__subTitle__7Dgkb");
    private static final SelenideElement INPUT_ERROR_TEXT = $(".Account2__helpInline__bX-vk");
    private static final SelenideElement INPUT_ERROR_PASSWORD = $(".Password2__helpInline__1s7pg");
    private static final SelenideElement COOKIE_FIELD = $(".cookie-btn-box").$("[aria-label=Accept]");


    public void openPage() {
        open(URL);

    }

    public boolean cookieMessageExists() {
        return COOKIE_FIELD.exists();
    }

    public void closeCookiesMessage() {
        COOKIE_FIELD.click();
    }


    public void setUserEmailAndPassword(String email, String password) {
        EMAIL_FIELD.setValue(email);
        PASSWORD_FIELD.setValue(password);

    }

    public void clickButtonSubmit() {
        SUBMIT_BUTTON.click();
    }

    public void checkOpenPage(String titlePage) {
        SUB_TITLE.shouldHave(text(titlePage));
    }

    public void checkErrorEmail(String color, String messageEmail, String borderColor) {
        INPUT_ERROR_TEXT.shouldBe(visible);
        INPUT_ERROR_TEXT.shouldHave(cssValue("color", color));
        INPUT_ERROR_TEXT.shouldHave(text(messageEmail));
        EMAIL_FIELD.shouldHave(cssValue("border-color", borderColor));
    }

    public void checkErrorPassword(String color, String messagePassword, String borderColor) {
        INPUT_ERROR_PASSWORD.shouldBe(visible);
        INPUT_ERROR_PASSWORD.shouldHave(cssValue("color", color));
        INPUT_ERROR_PASSWORD.shouldHave(text(messagePassword));
        PASSWORD_FIELD.shouldHave(cssValue("border-color", borderColor));
    }

}
