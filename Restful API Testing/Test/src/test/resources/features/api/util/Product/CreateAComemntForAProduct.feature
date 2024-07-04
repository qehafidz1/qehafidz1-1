Feature: Comment API
  As a User
  I want to create a comment for a product with valid authentification token
  So The comment should be successfully created in the database

  Scenario: User creates a comment for a product
    Given I have a valid user authentication token
    When I send a POST request to the comment creation endpoint with valid comment data
    Then I receive status code 200
    And the comment should be successfully created in the database

  Scenario: User creates a with invalid token
    Given I have a valid user authentication token
    When I send a POST request to the comment creation endpoint with invalid input
    Then I receive status code 500
    And the comment should not be created in the database