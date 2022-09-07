Feature: ApachePOI Citizen Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship Page

  Scenario: Create and Delete Citizenship from Excel
    When User creates citizenship with ApachePOI
    Then User deletes citizenship with ApachePOI


