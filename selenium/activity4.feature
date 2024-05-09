@activity4
Feature: Login Test

  @SmokeTest
  Scenario Outline: Testing Login without Examples
    Given User is on 4 Login page
    When User enters "<Username>" and "<Password>"
    Then Read the page title and confirmation message on page
    And Close the login browser

    Examples:
      | Username | Password  |
      | user1    | password1 |
      | user2    | password2 |
      | admin    | password  |