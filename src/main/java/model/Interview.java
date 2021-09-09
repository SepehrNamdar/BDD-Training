package model;

import java.time.LocalDateTime;
import java.util.Objects;

import static java.util.Objects.hash;

public class Interview {
    private final LocalDateTime interviewDate;
    private final String candidateName;
    private final String recruiterName;

    public Interview(LocalDateTime interviewDate, String candidateName, String recruiterName) {
        this.interviewDate = interviewDate;
        this.candidateName = candidateName;
        this.recruiterName = recruiterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(interviewDate, interview.interviewDate) &&
                Objects.equals(candidateName, interview.candidateName) &&
                Objects.equals(recruiterName, interview.recruiterName);
    }

    @Override
    public int hashCode() {
        return hash(interviewDate, candidateName, recruiterName);
    }
}
