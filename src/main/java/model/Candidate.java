package model;

import java.time.LocalDateTime;

public class Candidate {
    private String name;
    private String skill;
    private LocalDateTime availability;

    Candidate(String name, String skill, LocalDateTime availability) {
        this.name = name;
        this.skill = skill;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    String getSkill() {
        return skill;
    }

    public LocalDateTime getAvailability() {
        return availability;
    }
}
