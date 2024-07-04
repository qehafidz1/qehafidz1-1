Feature: Add an Item
    As a user
    I can add an Item
    So The Item can be added

    Scenario: Add an Item with valid input
        Given I am on the Main Page
        When I click the Plus Button 
        Then I am redirected to the Add a new item page
        # Then I click Name input bar and type my name
        # Then I click the quantity input bar and input the item quantity with valid input
        # Then I click item categories button
        # Then I click the categories that i want
        # Then I click Add Item Button
        # Then I click Add Item
        # Then I redirected to the Main Page

    # Scenario: Add an Item with empty input
    #     Given I am on the Main Page
    #     When I click the Plus Button 
    #     Then I am redirected to the Add a new item page
    #     Then I click Name input bar and type my name
    #     Then I click the quantity input bar and input the item quantity with valid input
    #     Then I click item categories button
    #     Then I click the categories that i want
    #     Then I click Add Item Button
    #     Then I click Add Item
    #     Then I redirected to the Main Page

    # Scenario: Change the Category Choice
    #     Given I am on the Main Page
    #     When I click the Plus Button 
    #     Then I am redirected to the Add a new item page
    #     Then I click Name input bar and type my name
    #     Then I click the quantity input bar and input the item quantity with valid input
    #     Then I click item categories button
    #     Then I click and choose the category that i want
    #     Then I click the category and choose the category again
    #     Then The Categories is changed

    # Scenario: Reset the name
    #     Given I am on the Main Page
    #     When I click the Plus Button 
    #     Then I am redirected to the Add a new item page
    #     Then I click Name input bar and type my name
    #     Then I click the quantity input bar and input the item quantity with valid input
    #     Then I click item categories button
    #     Then I click the categories that i want
    #     Then I click the category

    # Scenario: Back to Main Page
    #     Given I am on the Main Page
    #     When I click the Plus Button 
    #     Then I am redirected to the Add a new item page
    #     Then I click the Back button
    #     Then I redirected to the Main Page 