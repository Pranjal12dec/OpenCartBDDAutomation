@Smoke
  Feature: Verify that the website loads properly
    Description: To verify that all elements appear on opening the opencart website. Also, verify the login feature

    Scenario: Running the Smoke test
    Given The user is on the Opencart Homepage
    Then The header should be available on the page
    And the Navigation Links should be available on the page
    And the Hero Image carousel should be available on the page
    And the Feature section items should be shown on the page
    And the Brand carousel should be available on the page
    And the Footer Links should be available on the page