#Author: Sepehr NAMDAR

Feature: Schedule an interview

  As a human resource, I want to schedule an interview for Julia
  so she can meet a recruiter who can test her and is available at the same time than her

  Scenario: Schedule an interview successfully
    Given Julia who is a Java developer and is available 2018-01-01
    And David who is a Java recruiter and is available 2018-01-01
    When I try to schedule an interview
    Then an interview is scheduled between a candidate and a recruiter to meet each other at 2018-01-01
