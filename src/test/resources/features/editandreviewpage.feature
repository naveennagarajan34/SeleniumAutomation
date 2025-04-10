Feature: Edit and Review page functionalites

  Scenario Outline: Navigate to the book and chapter page
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    And click on the Edit and review page
    Then select the given "<book>" and chapter

    Examples: 
      | project | book     |
      | PDR     | Ruth 2:5 |

  Scenario Outline: Open the given (biblical, history, draft or resource) tab
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    And click on the Edit and review page
    Then click on add tab button
    And select the "<tab>" and verify

    Examples: 
      | project | tab      |
      | PDR     | biblical |
