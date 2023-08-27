@Search
Feature: Validate Order process by searching and ordering a couple of items
  Description: To validate that the user can place an order by searching the desired product and
  adding it to the cart.

  Scenario Outline: User is searching and adding an item to the cart
    Given The user is on the Opencart Homepage
    And User navigates to the login page
    When The login screen appears
    Then The user enters the "<username>" and "<password>"
    And User clicks the signin button
    Then The user searches for 'MacBook' SKU
    And All searched item should be of 'MacBook' type
    And User adds the "MacBook Pro" SKU item to the cart
    And User adds the "MacBook Air" SKU item to the cart
    Then The user proceeds with the checkout
    And User should be able to place the order successfully

    Examples:
      | username                | password       |
      | qaopencart1@yopmail.com | QAopencart@123 |