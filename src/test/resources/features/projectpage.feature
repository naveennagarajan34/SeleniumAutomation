Feature: Projects page functionalities

  Scenario Outline: Connect to the given project
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And select the "<project>" and click connect button
    Then verify that the project is connected successfully

    Examples: 
      | project |
      | PDR     |

  Scenario Outline: Connect to the given already connected project
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully

    Examples: 
      | project |
      | PDR     |
