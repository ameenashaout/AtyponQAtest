Feature: book test
  As a tester I want to test book page

  @web @chrome
  Scenario: open book page
    Given launch book page
    When the button <delete> clicked on id <1>
    Then result for <book> id <1> are disapper

  Scenario Outline: open book page
    Given the button <title> is enter
    When user add <test> to title and add <year> to year
    Then user submit result and book show

    Examples:
      | title| test |year|
      | edit | War and Peace| 1866|
      | creat| Selenium Fundamentals| 2018|