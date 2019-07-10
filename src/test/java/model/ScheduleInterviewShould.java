package model;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import use_case.ScheduleInterview;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ScheduleInterviewShould {
    private final LocalDateTime TODAY = LocalDateTime.now();

    private Candidate julia;
    private Recruiter david;
    private ScheduleInterview scheduler;

    @Given("Julia who is a Java developer and is available today")
    public void julia_who_is_a_java_developer_and_is_available_today() {
        julia = new Candidate("Julia", "Java", TODAY);
    }

    @And("^David who is a Java recruiter and is available today$")
    public void davidWhoIsAJavaRecruiterAndIsAvailableToday() {
        david = new Recruiter("David", "Java", TODAY);
    }

    @When("^I try to schedule an interview for Julia today$")
    public void iTryToScheduleAnInterviewForJulia() {
        scheduler = new ScheduleInterview(julia, david);
        scheduler.planInterview();
    }

    @Then("^an interview is scheduled for Julia and Thomas today to meet each other$")
    public void anInterviewIsScheduledForJuliaAndThomasTodayToMeetEachOther() {
        Interview interviewTodayBetweenJuliaAndDavid = new Interview(TODAY, julia.getName(), david.getName());
        assertEquals(interviewTodayBetweenJuliaAndDavid, scheduler.getInterview());
    }
}
