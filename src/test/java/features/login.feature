Feature: Login Tests for Sahibinden

  Scenario: User should login with correct credentials
    Given User on www.sahibinden.com
    And Validates the Home Page
    When User click on sign in button
    And Validates the Login Page
    Then User enters username: "thisIsMyUsername" and password: "thisIsMyPassword"
    And User should be logged in

  Scenario Outline: User should not sign in with wrong credentials
    Given User on www.sahibinden.com
    And Validates the Home Page
    When User click on sign in button
    And Validates the Login Page
    Then User enters username: <username> and password: <password>
    And User should not be logged in
    Examples:
      | username            | password             |
      | correctUserName     | falsePassword        |
      | falseUserName       | correctPassword      |
      | falseUserName       | falsePassword        |
