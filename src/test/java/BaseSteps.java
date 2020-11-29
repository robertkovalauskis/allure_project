import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class  BaseSteps{

    private final static int ISSUE_NUMBER = 1;

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search for repository ${name}")
    public void searchForRepository(final String name) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(name);
        $(".header-search-input").submit();
    }

    @Step("Transfer to repository ${name}")
    public void goToRepository(final String name) {
        $(By.linkText(name)).click();
    }

    @Step("Transfer to Issue")
    public void goToIssue() {
        $(withText("Issues")).click();
    }

    @Step("Check Issue with the ${number}")
    public void shouldSeeIssueWithNumber(final int number) {
        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    }
}
