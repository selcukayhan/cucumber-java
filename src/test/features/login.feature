Feature: Login Tests for Amazon

  Scenario: Valid Login
    Given I am a user of amazon.com
    When I log in using valid credentials
    Then  I should be logged in

  Scenario: Invalid Login
    Given I am a user of amazon.com
    When I log in using invalid credentials
    Then I should not be logged in