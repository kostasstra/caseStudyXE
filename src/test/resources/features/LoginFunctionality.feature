Feature: Login Functionality

  Scenario: Successful Login
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    Then they should be redirected to the dashboard
    And they should see a welcome message