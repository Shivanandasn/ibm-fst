@activity3
Feature: alert

  @SmokeTest
  Scenario: Testing alerts
    Given User is on importinga1 Page
    When simple alert
    Then switch focus to alerts
    And read the text
    And accept alert
    When confirm alert
    Then switch focus to alerts
    And read the text
    And accept alert
    When prompt alert
    Then switch focus to alerts
    And read the text
    And write the input
    And accept alert

