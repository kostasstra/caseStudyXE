Feature:Test new feature

  Background:
    Given User is on home page "https://www.xe.gr/"

  @SearchOfSaleHouseAndCheckIfTheresultsAreGreaterThanFiveHundredThousand
  Scenario Outline: Search of sale house and check if the results are Greater Than Five hundred Thousand

    And And I select the sale from dropdown list
    And I click on the button search
    And I click on the price filter
    When I press enter on the keyboard with <price>
    Then the price is greater than <price>


    Examples:
      | price |
      | 500000|