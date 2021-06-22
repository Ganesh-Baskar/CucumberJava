#Author: Ganesh@your.domain.com
Feature: Validating add customer flow

  Scenario: Add Customer validation
    Given user launches telecom application
    And user click on add customer button
    When user need to fill up the fields
    And user click on submit button
    Then user verify customer id is generated

  Scenario: Add Customer validation by 1D list concept
    Given user launches telecom application
    And user click on add customer button
    When user need to fill up the fields by oneDim list
      | Baskar | muthu | baskar@gmail.com | Address | 784523876 |
    And user click on submit button
    Then user verify customer id is generated

  Scenario: Add Customer validation by 1D map concept
    Given user launches telecom application
    And user click on add customer button
    When user need to fill up the fields by oneDim map
      | fname       | Baskar           |
      | lname       | muthu            |
      | email       | baskar@gmail.com |
      | addr        | Address          |
      | telephoneno |        784523876 |
    And user click on submit button
    Then user verify customer id is generated

  Scenario: Add Customer validation by 2D list concept
    Given user launches telecom application
    And user click on add customer button
    When user need to fill up the fields by twoDim list
      | Baskar | muthu | baskar@gmail.com | Address | 784523876 |
      | ragi   | math  | ragi@gmail.com   | Address | 784523876 |
      | vicki  | muthu | vicki@gmail.com  | Address | 784523876 |
      | velu   | muth  | velu@gmail.com   | Address | 784523876 |
    And user click on submit button
    Then user verify customer id is generated

  Scenario: Add Customer validation by 2D list concept
    Given user launches telecom application
    And user click on add customer button
    When user need to fill up the fields by twoDim list
      | fname  | lname | email            | addr    | telephoneno |
      | Baskar | muthu | baskar@gmail.com | Address |   784523876 |
      | ragi   | math  | ragi@gmail.com   | Address |   784523876 |
      | vicki  | muthu | vicki@gmail.com  | Address |   784523876 |
      | velu   | muth  | velu@gmail.com   | Address |   784523876 |
    And user click on submit button
    Then user verify customer id is generated
