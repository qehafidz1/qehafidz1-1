Feature: Login to Account
  As a User
  I want to log my account
  So my account can be logged

  Scenario: Register an account with valid input
    Given I set on the Login endpoint
    When I send valid email and valid input
    And I receive status code 200
    Then My account is Logged

  Scenario: Register an account with valid email and invalid password
    Given I set on the Login endpoint
    When I send valid with valid email and invalid password
    And I receive status code 400
    Then My account is not Logged




