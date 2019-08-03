#Author: Sepehr NAMDAR

Feature: Schedule a recruitment interview

  As a human resource, I want to schedule an interview for Julia
  so she can meet a recruiter who can test her and is available at the same time than her

  Scenario Outline: Schedule an interview successfully
    Given <candidateName> who is a <candidateSkill> developer and is available at <candidateAvailability>
    And <recruiter> who is a <recruiterSkill> recruiter and is available at <recruiterAvailability>
    When I try to schedule an interview
    Then an interview is scheduled between a candidate and a recruiter to meet each other at <interviewDate>
    Examples:
      | candidateName | candidateSkill | candidateAvailability | recruiter | recruiterSkill | recruiterAvailability | interviewDate |
      | Julia         | Java           | 2018-01-01            | David     | Java           | 2018-01-01            | 2018-01-01    |
      | Marc          | .Net           | 2019-07-14            | Thomas    | .Net           | 2019-07-14            | 2019-07-14    |

  Scenario: Schedule an interview is not possible if candidate and recruiter skills does not match
    Given Marta who is a PHP developer and is available at 2019-07-15
    And Sam who is a Ruby recruiter and is available at 2019-07-15
    Then The system inform me that there is any recruiter who can test the candidate
