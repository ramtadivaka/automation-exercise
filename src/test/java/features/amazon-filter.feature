#Author: Ram Tadivaka

Feature: Filtering Samsung Mobile Phones on Amazon

  Scenario: User filters Samsung phones by specific criteria

    Given I am on the Amazon home page
    When I navigate to the Mobile Phones category
    And I apply the following filters
      | Brand   | Camera        | Year | Price Range       |
      | Samsung | 20 MP & above | 2023 | 50 - 100       	 |
    Then I should see a list of "Samsung" phones matching these criteria
