Feature: Login functionality for Scriptureforge

  Scenario Outline: User login with valid credentials
    Given Navigate to Scriptureforge
    When clicking on login button
    Then login with valid user name and password
