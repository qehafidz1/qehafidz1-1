Feature: Register to Account
  As a User
  I want to register my account
  So my account can be registered

  Scenario: Register an account with valid input and valid fullname
    Given I set on the register endpoint
    When I send valid email and valid input and valid fullname
    And I receive status code 200
    Then My account is registered

  Scenario: Register an account with valid email and invalid password and valid fullname
    Given I set on the register endpoint
    When I send valid with valid email and invalid password and valid fullname
    And I receive status code 400
    Then My account is not registered




