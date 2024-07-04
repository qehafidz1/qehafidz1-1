Feature: Delete Data
  As a user
  I want to delete unnecessary or incorrect data
  So I can maintain the integrity and cleanliness of my book collection

  Scenario: I can delete Data
    Given I am on the main page
    When I click the "trash can" button
    Then a Pop-Up appears asking "Are you sure want to delete this book?"
    When I click the Yes button
    Then I am directed to the main menu page
