Feature: Edit Book
  As a user,
  I want to edit existing book information
  So I can update details or correct any mistakes.

  Scenario: I can edit a Book with Valid Data
    Given I am on the main page
    When I click the Edit button
    And I am directed to the Edit page
    And I input valid data including Title, Author, and Publish Year
    And I click the Edit Book button
    Then I am directed to the Information Page

  Scenario: I cannot edit a Book with Missing Title
    Given I am on the main page
    When I click the Edit button
    And I am directed to the Edit page
    And I input data including Author and Publish Year but with a missing Title
    And I click the Edit Book button
    Then I remain on the Edit page
    And An error occurs

  Scenario: I cannot edit a Book with Missing Year
    Given I am on the main page
    When I click the Edit button
    And I am directed to the Edit page
    And I input data including Author and Title but with a missing Year
    And I click the Edit Book button
    Then I remain on the Edit page
    And An error occurs
