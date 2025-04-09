Feature: Users page Functionalities

  Scenario Outline: Send an Invite link via mail and verify the email sent message
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    And click on the users
    Then enter the email, select role and invitation language and send
    And verify that the invite has been sent

    Examples: 
      | project |
      | PDR     |

  Scenario Outline: Copy the invite URL and verify
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    And click on the users
    Then click on the share button
    And verify that the invite has been copied

    Examples: 
      | project |
      | PDR     |

  Scenario Outline: Update non PT User role
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    When click on the users
    Then click on the three dots button of "<user>"
    And Open the Edit roles and permission dialog
    Then Change the role of the user to "<role>"
    And verify that the "<user>" role updated to "<role>"

    Examples: 
      | project | user    | role      |
      | PDR     | Checker | Commenter |
