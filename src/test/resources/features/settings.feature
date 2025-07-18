Feature: Settings Page functionalities

  #Scenario Outline: Delete the Project
  #Given Navigate to Scriptureforge
  #When clicking on login button
  #Then login with valid user name and password
  #And select the "<project>" and click connect button
  #Then verify that the project is connected successfully
  #When clicking on the Settings
  #And click on the Delete button
  #
  #Examples:
  #| project |
  #| PDR     |
  Scenario Outline: Adding the source project
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    When clicking on the Settings
    And click on the source project field
    Then select the "<source>" project from the list
    And verify that the source project is added

    Examples: 
      | project | source |
      | PDR     | EASY   |

  Scenario Outline: Enable/Disable the translation suggestions
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    When clicking on the Settings
    And "<enable/disable>" the translation suggestions

    Examples: 
      | project | enable/disable |
      | PDR     | enable         |

  Scenario Outline: Enable/Disable the Biblical Terms
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    When clicking on the Settings
    And "<enable/disable>" the biblical terms

    Examples: 
      | project | enable/disable |
      | PDR     | enable         |

  Scenario Outline: Enable/Disable the Community checking
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    When clicking on the Settings
    And "<enable/disable>" the community checking

    Examples: 
      | project | enable/disable |
      | PDR     | enable         |
