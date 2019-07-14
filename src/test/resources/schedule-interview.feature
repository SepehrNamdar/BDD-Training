#Author: Sepehr NAMDAR

Feature: Schedule an interview

  As a human resource, I want to schedule an interview for Julia
  so she can meet a recruiter who can test her and is available at the same time than her

  Scenario: Schedule an interview successfully
    Given Julia who is a Java developer and is available today
    And David who is a Java recruiter and is available today
    When I try to schedule an interview for Julia and David
    Then an interview is scheduled for Julia and David today to meet each other
