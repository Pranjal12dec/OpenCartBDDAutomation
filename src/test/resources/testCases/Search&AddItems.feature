@search
Feature: Validate Search and Add to Cart feature on Opencart Site
  Description: To validate that the user can search for an item and add it to the cart

  Scenario Outline: User is searching and adding an item to the cart
    Given The user is on the Opencart Homepage
    And User navigates to the login page
    When The login screen appears
    Then The user enters the "<username>" and "<password>"
    And User clicks the signin button
    Then The user searches for 'Macbook'
    And adds the Macbook Pro SKU item to the cart
    Then the Macbook Pro SKU should get added to the cart

    Examples:
      | username                | password       |
      | qaopencart1@yopmail.com | QAopencart@123 |