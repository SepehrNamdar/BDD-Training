package use_case;

import model.Candidate;
import model.Interview;
import model.Recruiter;

import java.time.LocalDateTime;

public class ScheduleInterview {
    private Candidate candidate;
    private Recruiter recruiter;
    private Interview interview;

    public ScheduleInterview(Candidate candidate, Recruiter recruiter) {
        this.candidate = candidate;
        this.recruiter = recruiter;
    }

    public Interview getInterview() {
        return interview;
    }

    public void planInterview() {
        LocalDateTime interviewDate = candidate.getAvailability();
        if (recruiter.isAvailable(interviewDate) && recruiter.canTest(candidate)) {
            interview = new Interview(interviewDate, candidate.getName(), recruiter.getName());
        }
    }
}
