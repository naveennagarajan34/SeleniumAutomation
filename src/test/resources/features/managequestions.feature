Feature: Manage Questions page

  Scenario Outline: Add a question from manage questions page
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    Then click on the manage questions
    And click Add Questions button and enter the scripture reference "<startref>","<endref>","<question>" and verify

    Examples: 
      | project | startref | endref  | question                |
      | PDR     | GEN 1:1  | GEN 1:2 | This is sample question |


  Scenario Outline: Archive a question from manage questions page
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    Then click on the manage questions
    And click Add Questions button and enter the scripture reference "<startref>","<endref>","<question>" and verify
    Then click on the archive button on the "<book>"

    Examples: 
      | project | startref | endref  | question                | book    |
      | PDR     | GEN 1:1  | GEN 1:2 | This is sample question | Genesis |
