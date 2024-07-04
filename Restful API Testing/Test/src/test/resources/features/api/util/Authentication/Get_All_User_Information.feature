Feature: Get All User Information
  As I user
  I want to send GET request to get all user information
  So I get all user information

  Scenario:
    Given I set on API Get All User on point
    When  I send GET request to retrieve all user information
    Then  I receive status code 200
    And   And I receive all user information
