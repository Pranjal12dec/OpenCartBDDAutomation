Feature: Validate Login feature on Opencart Site
  Description: To validate the login feature behaviour when user attempts to login using
  valid and invalid credentials

  Scenario Outline: User is trying to login using valid and Invalid credentials
    Given The user is on the Opencart Homepage
    And User navigates to the login page
    When The login screen appears
    Then The user enters the "<username>" and "<password>"
    And User clicks the signin button
    Then The user should be logged in or shown error message based on credentials

    Examples:
      | username                | password       |
      | qaopencart1@yopmail.com | QAopencart@123 |
#      | qaopencart2@yopmail.com | QAopencart@123 |
