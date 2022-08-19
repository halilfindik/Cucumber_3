Feature: Citizenship with Scenario Outline

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship Page

    Scenario Outline: Citizenship Create
      When User a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
      Then Success message should be displayed

      When User a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
      Then Already exists message should be displayed
      And Click on close button

      Examples:
        | CitizenshipName | ShortName |
        | halil111        | halo1     |
        | halil112        | halo2     |
        | halil113        | halo3     |
        | halil114        | halo4     |
        | halil115        | halo5     |
        | halil116        | halo6     |

