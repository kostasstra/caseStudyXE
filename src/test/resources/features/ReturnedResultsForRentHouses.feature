Feature: Rent house tab

  Background:
    Given User is on the home page "https://www.xe.gr/"

  @ReturnedResultsForRentHouses
  Scenario: Returned results for rent houses

    And  I click on the real estate
    When I click on the search
    Then I click on the first search
