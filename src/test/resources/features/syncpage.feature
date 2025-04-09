Feature: Sync page Functionalities

  Scenario Outline: Synchronize the project and verify it sync sucessfully
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    And click on the sync page
    Then click on the sync with paratext button
    And verify that the project synced sucessfully

    Examples: 
      | project |
      | PDR     |
