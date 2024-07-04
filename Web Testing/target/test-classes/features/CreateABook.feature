Feature: Create Book
  As a user
  I want to create a new book with valid data
  So I can add it to the system and manage my collection effectively

  Scenario: I can create a Book with Valid Data
    Given I am on the main page
    When I click the plus button
    Then I am directed to the Create page
    When I input valid data including Title, Author, and Publish Year
    And I click the Create Book button
    Then I am directed to the main menu page
    And My input is saved and visible on the info button
#    And I receive an ID, creation update, and last update

  Scenario: I cannot create Data with Missing Title
    Given I am on the main page
    When I click the plus button
    Then I am directed to the Create page
    When I input data including Author and Publish Year but with a missing Title
    And I click the Create Book button
    Then I remain on the Create page
    And An error occurs

  Scenario: I cannot create Data with Negative Year
    Given I am on the main page
    When I click the plus button
    Then I am directed to the Create page
    When I input data including Author and Title but with a negative Year
    And I click the Create Book button
    Then I remain on the Create page
    And An error occurs

#    And Input is not saved on the main page
