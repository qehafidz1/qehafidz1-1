Feature: Add an Item
    As a user
    I can add an Item
    So The Item can be added

    Scenario: Add an Item with valid input
        Given I am on the Main Page
        When I click the Plus Button 
        Then I am redirected to the Add a new item page
        When I click Name input bar and type my name
        When I click the quantity input bar and input the item quantity with valid input
        When I click item categories button
        When I click the categories that i want
        When I click Add Item Button
        Then I redirected to the Main Page

    Scenario: Add an Item with empty input
        Given I am on the Main Page
        When I click the Plus Button 
        Then I am redirected to the Add a new item page
        When I click Name input bar and type my name with empty input
        When I click the quantity input bar and input the item quantity with valid input
        When I click item categories button
        When I click the categories that i want
        When I click Add Item Button
        Then I remain on the Adding a New Item Page
    
    Scenario: Add an Item with float input
        Given I am on the Main Page
        When I click the Plus Button 
        Then I am redirected to the Add a new item page
        When I click Name input bar and type my name
        When I click the quantity input bar and input the item quantity with float input
        When I click item categories button
        When I click the categories that i want
        Then I remain on the Adding a New Item Page

