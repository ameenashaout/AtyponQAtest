Feature: home page test
As a tester I want to test first page and the button in vertical menu bar and search button

  Background:
    Given launch home page
  @web @chrome
  Scenario: open home page
    When the button <home> entered
    Then result for <home> are show

  Scenario: open home page
    When the phrase <test> added in text area
    And the button <search> entered
    Then result for <search> are show

  Scenario: open home page
    When the button <author>  entered
    Then result for <author> are show
