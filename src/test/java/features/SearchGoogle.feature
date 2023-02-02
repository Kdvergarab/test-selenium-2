Feature: Google Search

  Background:
    Given Load Google website

  @Test1 @All
  Scenario: Simple Google search
    When Look up the word Delfin
    Then Result is displayed Delfin

  @Test2 @All
  Scenario: Simple Google search
    When Look up the word Cat
    Then Result is displayed Cat