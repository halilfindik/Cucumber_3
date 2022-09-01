Feature: Country Multi Scenario

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Country Page

  @Regression
  Scenario: Create a Country
    When Create a country
    Then Success message should be displayed

  @Regression
  Scenario: Create a Country Parameter Data
    When Create a country name as "HalilNew9" code as "code9"
    Then Success message should be displayed