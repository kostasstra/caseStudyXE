Feature: Save search

  Background:
    Given User is on the second home page "https://www.xe.gr/"

  @SelectLandForSaleAndSaveSearch
  Scenario Outline: Select land for sale and save search

    And I click on the land for sale
    And I click on the search with button
    And I click on the save search
    And I click on the login with <username> and <pass>
    When search existed delete it
    Then Then search is saved


    Examples:
      | username                 |   pass                            |
      | kostasstra@yopmail.com   |   QaStratigosAutomation!1900      |