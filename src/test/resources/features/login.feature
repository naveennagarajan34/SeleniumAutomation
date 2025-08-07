@smoke
Feature: Login functionality for Scriptureforge

  @valid @DOK_101
  Scenario: User login with valid credentials
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And verify that the user is loggedin successfully

  @invalid @DOK_102
  Scenario Outline: User login with invalid credentials
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with invalid "<username>" and "<password>"
    And verify that wrong email or password banner appeared

    Examples: 
      | username                     | password |
      | test@example.com             |    12345 |
      | naveennagarajan+qa@gmail.com |      123 |

  @logout @DOK_103
  Scenario Outline: User logout
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the profile icon in the header
    Then click on the logout button and verify
