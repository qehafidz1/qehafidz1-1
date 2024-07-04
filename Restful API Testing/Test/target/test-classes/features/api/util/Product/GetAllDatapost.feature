Feature: Administrator can get all user
  As an Administrator
  I want to get all products
  So I can view the list of products

  Scenario: Send GET request to get all products
    Given I set API endpoint for retrieve all users
    When I send GET request to retrieve all products to server
    And I receive status code 200
    Then I receive all products

