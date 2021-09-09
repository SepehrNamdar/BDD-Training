package model;

import java.time.LocalDateTime;

public class Recruiter {
    private final String name;
    private final String recruiterSkill;
    private final LocalDateTime recruiterAvailability;

    Recruiter(String name, String recruiterSkill, LocalDateTime recruiterAvailability) {
        this.name = name;
        this.recruiterSkill = recruiterSkill;
        this.recruiterAvailability = recruiterAvailability;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable(LocalDateTime interviewDate) {
        return recruiterAvailability.equals(interviewDate);
    }

    public boolean canTest(Candidate candidate) {
        return candidate.getSkill().equals(recruiterSkill);
    }
}
