package use_case;

import model.AnyRecruiterCanTestTheCandidateException;
import model.Candidate;
import model.Interview;
import model.Recruiter;

import java.time.LocalDateTime;

public class ScheduleInterview {
    private final Candidate candidate;
    private final Recruiter recruiter;
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
        if (!recruiter.canTest(candidate)) {
            throw new AnyRecruiterCanTestTheCandidateException();
        }
        if (recruiter.isAvailable(interviewDate)) {
            interview = new Interview(interviewDate, candidate.getName(), recruiter.getName());
        }
    }
}
