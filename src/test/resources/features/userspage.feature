Feature: Users page Functionalities


  Scenario Outline: Send an Invite link via mail and verify the email sent message
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login via "<loginvia>" with "<username>" and "<password>"
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    And click on the users
    Then enter the email, select role and invitation language and send
    And verify that the invite has been sent

    Examples: 
      | username                  | password | loginvia | project |
      | naveen.n@ecgroup-intl.com | pass     | paratext | PDR     |


  Scenario Outline: Copy the invite URL and verify
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login via "<loginvia>" with "<username>" and "<password>"
    And click on the connected project "<project>"
    Then verify that the project is connected successfully
    And click on the users
    Then click on the share button
    And verify that the invite has been copied

    Examples: 
      | username                  | password | loginvia | project |
      | naveen.n@ecgroup-intl.com | pass     | paratext | PDR     |
      
      @userrole
  Scenario Outline: Change checker user to viewer user
  
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login via "<loginvia>" with "<username>" and "<password>"
     And click on the connected project "<project>"
    Then verify that the project is connected successfully
    When click on the users
    Then click on the three dot button
    And Open the Edit roles and permission dialog
    Then Change the checker user to viewer user
    And verify that the user role updated to viewer user

    Examples: 
      | username                  | password | loginvia | project |
      | naveen.n@ecgroup-intl.com | pass     | paratext | PDR     |
      
