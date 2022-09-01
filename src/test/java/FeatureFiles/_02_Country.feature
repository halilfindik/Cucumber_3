Feature: Country

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button

  @Regression
  Scenario: Create A Country

    Given Navigate to Country Page
    When Create a country
    Then Success message should be displayed