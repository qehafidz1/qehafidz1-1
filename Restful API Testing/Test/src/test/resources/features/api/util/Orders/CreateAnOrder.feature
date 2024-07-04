Feature: Create Order API
  As a user
  I want to create an order with valid or invalid details
  So the order should be processed or rejected accordingly

  Scenario: User creates an order with valid details
    Given I have set order on point
    When I send a POST request to the order creation endpoint with valid data
    And the order should be successfully created in the database

  Scenario: User creates an order with invalid details
    Given I have set order on point
    When I send a POST request to the order creation endpoint with invalid data
    Then I receive status code 400
    And the order should not be created in the database
