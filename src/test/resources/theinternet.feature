Feature: Forgot Password Flow on The Internet

  Scenario: Complete forgot password flow and login
    Given I am on the login page
    When I navigate to the forgot password page
    And I submit a forgot password request with email "test@example.com"
    And I verify the confirmation message
    And I return to the login page
    And I login with valid credentials
    Then I should be logged in successfully
