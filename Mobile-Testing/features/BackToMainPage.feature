Feature: Back to Main Page
  As a User, I want to go back to main page,
  So that I'm on Main Page

  Scenario: Back to Main Page
    Given I am on the Main Page
    When I click the Plus Button
    Then I am redirected to the Add a new item page
    Then I click the Back button
    Then I redirected to the Main Page
