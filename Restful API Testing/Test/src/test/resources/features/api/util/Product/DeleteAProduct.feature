Feature: Delete a product
  As an Administrator
  I can delete a product with valid ID
  So the product is deleted

  Scenario: Delete a product with valid ID
    Given I set on the endpoint to delete the product
    When I send DELETE request to server with valid ID
    Then I get status code 200 DELETE
