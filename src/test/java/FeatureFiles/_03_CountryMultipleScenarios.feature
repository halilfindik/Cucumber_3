Feature: Country Multi Scenario

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Country Page

  Scenario: Create a Country
    When Create a country
    Then Success message should be displayed

  Scenario: Create a Country Parameter Data
    When Create a country name as "HalilNew1" code as "code1"
    Then Success message should be displayed