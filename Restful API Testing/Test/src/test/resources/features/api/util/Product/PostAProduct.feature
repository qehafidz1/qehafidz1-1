Feature: Create a product with valid input
  As an Administrator
  I can send POST request to the server to create a product with valid input
  So the server can create the product

  # Positive Test

    Scenario: Send post request to create a product with valid requirement
    Given I set on the endpoint to post a request
    When I send POST to server with valid requirement
    And I receive status code 201
    Then I receive the valid data for created product


 # Negative Test

  Scenario: Send post request to create a product without name
    Given I set on the endpoint to post a request
    When I send POST to server without name
    Then I receive status code 500
    And I receive error message bacause i wrote it without name


