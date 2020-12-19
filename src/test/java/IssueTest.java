import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class IssueTest {
    private final static String REPOSITORY = "robertkovalauskis/qa_guru_4_allure_homework";
    private final static String USER = "robertkovalauskis";
    private final static int ISSUE_NUMBER = 1;
    private final static String PASSWORD = "nh2iQKNZsYNxpdz";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void searchForIssue() {

        //Open page
        open("https://github.com");

        //Login
        $("a[href='/login']").click();
        $("#login_field").setValue(USER);
        $("#password").setValue(PASSWORD);
        $(".btn.btn-primary.btn-block").click();

        //Enter repository
        $(By.linkText(REPOSITORY)).click();

        //Transfer to Issues
        $("span[data-content='Issues']").click();
        $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);

        //Create New Issue
        $("a.btn.btn-primary").click();
        $("#issue_title").setValue("Issue");
        $("#issue_body").setValue("My first Issue");
        $(withText("Assignees")).click();
        $$(".js-username").find(text("robertkovalauskis")).click();
        $(withText("Assignees")).click();
        $(withText("Labels")).click();
        $$(".name").find(text("bug")).click();
        $(withText("Labels")).click();
        $$(".btn.btn-primary").find(text("Submit new issue")).click();
        // Assertion
        $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
    }
}
