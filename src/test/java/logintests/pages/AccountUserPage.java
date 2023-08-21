package logintests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AccountUserPage {
    private static final SelenideElement TITLE_PAGE = $(".OverviewPage__slogan__36_ee");

    public void checkAccountPage() {
        TITLE_PAGE.shouldBe(visible);
    }

    public void checkUserName(String value) {
        TITLE_PAGE.shouldHave(Condition.text(value));
    }
}
