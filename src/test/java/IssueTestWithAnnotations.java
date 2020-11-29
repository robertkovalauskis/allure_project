import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssueTestWithAnnotations extends BaseSteps {
    private final static String REPOSITORY = "robertkovalauskis/qa_guru_4_allure_homework";
    private final static String USER = "robertkovalauskis";
    private final static int ISSUE_NUMBER = 1;


    @Test
    @DisplayName("Annotation testt")
    @Feature("Issues")
    @Story("User should see issues in existing repository")
    public void searchForIssue(){
        final BaseSteps steps = new BaseSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.goToIssue();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }

}
