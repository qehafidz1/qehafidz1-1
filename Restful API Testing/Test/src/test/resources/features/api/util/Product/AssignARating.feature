Feature: Assign a Rating
  As a User
  I want to assign a rating
  So The rating should be successfully created in the database

  Scenario: User creates a rating for a product
    Given I have a valid user authentication token
    When I send a POST request to the rating creation endpoint with valid rating data
    And I receive status code 200
    Then the rating should be successfully created in the database

  Scenario: User creates a with invalid input
    Given I have a valid user authentication token
    When I send a POST request to the comment creation endpoint with invalid URL
    Then I receive status code 400
