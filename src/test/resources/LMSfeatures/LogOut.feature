Feature: US:2 Logout

  Background:
    Given user navigate to LMS login page
    When user enters the valid username and password
    And click on login button

  @Run  @Reggresion
  Scenario: Logout after making DateSheet
    And user click on the Student Services
    And go to make date sheet option
    And clicks on the login button
    And click on singin button
    And click on logout button
    And move to main page
    And click the right corner picture of user on application
    And click on LogOut button
    Then user will be LogOut
