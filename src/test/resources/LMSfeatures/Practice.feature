Feature: class No:4


  @class41
  Scenario Outline: Valid admin login
    When user enters the valid "<StudentId>" and "<UserNmae>"
    Then user is successfully logged in
    Examples:
      |StudentId   |UserNmae|
      |Suga        |pinochio*1P |
      |Suga        |snobar|
      |bc200416975 |sysipus*2S|


  @class42
  Scenario: Valid admin login
    When user enters the valid "bc200416975" and  "sysipus*2S"
    And click on login button
    Then user is successfully logged in

    @class43
    Scenario Outline: Valid admin login
      When user enters the Invalid "<Username>"  "<Password>" and  "<Error>"
      And click on login button
      Then user is successfully logged in
      Examples:
      |Username|Password|Error|
      |bc200416975|suga|Incorrect user name or password. The account will be locked after 5 failed login attempts.|
      |bc20041697|sysipus*2S|Incorrect user name or password. The account will be locked after 5 failed login attempts.|
      |         |bc200416975|Enter Password|
      |sysipus*2S|             |Enter Student ID|



  @class44
  Scenario Outline: Valid admin login
    When user enters the valid "<USERNAME>"  "<PASSWORD>"
    And "<Text>" IS DISPLYED
    And click on login button
    Examples:
      |USERNAME|PASSWORD|Text|
      |bc200416975|sysipus*2S|Text|









  @class45
  Scenario: Valid admin login
    When user enters the valid USERNAME  PASSWORD
      |Username     |Password     |
      |bc200416975  |wrongpassword|
      |wrongusername|sysipus*2S   |
      |             |bc200416975  |
      |sysipus*2S   |             |
  @Dashboard
  Scenario: Verify all the options on the dashboard
    When user enters the valid username and password
    And click on login button
    Then user is successfully logged in
    Then user varify all the dashboard option
    |Pim|Peave|

    @Excel@class5
 Scenario: read the file from excel
       When user provide mutiple data from the excel file  using "EmployeData" sheet and logged in

            @class6
Scenario: PageFactory
  When Using methods from PageFactory

  @class7
  Scenario: All objects in one method so we can perform them in once instead of calling them one by one
    When user logged in








