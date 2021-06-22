#Author: Ganesh@your.domain.com
Feature: Add Tariff Plan Validation

  Scenario Outline: tariff plan flow validation
    Given user launch telecom application
    And user click on add tariff button
    When user need to fill up the plan details "<MR>","<FLM>","<FIM>","<FSP>","<LPMC>","<IPMC>","<SPC>"
    And user clicked on the submit button
    Then user verify congratulation message

    Examples: 
      | MR  | FLM | FIM | FSP | LPMC | IPMC | SPC |
      | 122 |  22 | 333 | 111 |  111 |   33 |  22 |
      | 122 |  22 | 333 | 111 |  111 |   33 |  22 |
      | 122 |  22 | 333 | 111 |  111 |   33 |  22 |
