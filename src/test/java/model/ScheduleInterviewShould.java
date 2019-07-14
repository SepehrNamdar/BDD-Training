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

    private Candidate candidate;
    private Recruiter recruiter;
    private ScheduleInterview scheduler;

    @Given("Julia who is a Java developer and is available today")
    public void julia_who_is_a_java_developer_and_is_available_today() {
        candidate = new Candidate("Julia", "Java", TODAY);
    }

    @And("^David who is a Java recruiter and is available today$")
    public void davidWhoIsAJavaRecruiterAndIsAvailableToday() {
        recruiter = new Recruiter("David", "Java", TODAY);
    }

    @When("^I try to schedule an interview for Julia and David")
    public void iTryToScheduleAnInterviewForJuliaAndDavid() {
        scheduler = new ScheduleInterview(candidate, recruiter);
        scheduler.planInterview();
    }

    @Then("^an interview is scheduled for Julia and David today to meet each other$")
    public void anInterviewIsScheduledForJuliaAndDavidTodayToMeetEachOther() {
        Interview interviewTodayBetweenJuliaAndDavid = new Interview(TODAY, candidate.getName(), recruiter.getName());
        assertEquals(interviewTodayBetweenJuliaAndDavid, scheduler.getInterview());
    }
}
