Feature: Get a product
  As a Administrator
  I can get a product with based on a valid ID
  So I can see a product

  Scenario: Send GET request to retrieve a product with a valid ID
    Given I set endpoint API to retrieve a product with valid id
    When I send GET request to retrieve a product to server with valid ID
    And I receive status code 200 meaning suceed to request GET to server
    Then I receive the product

  Scenario: Send GET request to retrieve a product with an invalid ID
    Given I set endpoint API to retrieve a product with invalid id
    When I send GET request to retrieve a product to server with invalid ID
    And I receive status code 404
    Then I receive the error message


