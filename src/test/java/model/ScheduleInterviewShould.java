package model;

import cucumber.api.Format;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import use_case.ScheduleInterview;

import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;

public class ScheduleInterviewShould {

    private Candidate candidate;
    private Recruiter recruiter;
    private ScheduleInterview scheduler;

    @Given("(.*) who is a (.*) developer and is available (.*)")
    public void julia_who_is_a_java_developer_and_is_available_today(
            String candidateName, String candidateSkill, @Format("yyyy-MM-dd") Date candidateAvailability) {
        candidate = new Candidate(candidateName, candidateSkill, convert(candidateAvailability));
    }

    @And("^(.*) who is a (.*) recruiter and is available (.*)")
    public void davidWhoIsAJavaRecruiterAndIsAvailableToday(
            String recruiterName, String recruiterSkill, @Format("yyyy-MM-dd") Date recruiterAvailability) {
        recruiter = new Recruiter(recruiterName, recruiterSkill, convert(recruiterAvailability));
    }

    @When("^I try to schedule an interview")
    public void iTryToScheduleAnInterview() {
        scheduler = new ScheduleInterview(candidate, recruiter);
        scheduler.planInterview();
    }

    @Then("^an interview is scheduled between a candidate and a recruiter to meet each other at (.*)$")
    public void anInterviewIsScheduledBetweenACandidateAndARecruiterToMeetEachOther(
            @Format("yyyy-MM-dd") Date interviewDate) {
        Interview interviewTodayBetweenJuliaAndDavid =
                new Interview(convert(interviewDate), candidate.getName(), recruiter.getName());
        assertEquals(interviewTodayBetweenJuliaAndDavid, scheduler.getInterview());
    }

    private LocalDateTime convert(Date dateToConvert) {
        return new java.sql.Timestamp(dateToConvert.getTime()).toLocalDateTime();
    }

    @Then("^The system inform me that there is any recruiter who can test the candidate$")
    public void theSystemInformMeThatThereIsAnyRecruiterWhoCanTestTheCandidate() {
        scheduler = new ScheduleInterview(candidate, recruiter);
        assertThatExceptionOfType(AnyRecruiterCanTestTheCandidateexception.class)
                .isThrownBy(scheduler::planInterview);
    }
}
