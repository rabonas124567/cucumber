Feature: Login feature

  @login
  Scenario: Valid admin login
    When user enters the valid username and password
    And click on login button
    Then user is successfully logged in

  @smoke @Reggresion
  Scenario: InValid admin login
      When user enters the Invalid username and password
      And click on login button
      And get a message print this message
      Then user is successfully not logged in



