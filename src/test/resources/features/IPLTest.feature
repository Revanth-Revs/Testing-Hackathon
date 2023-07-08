Feature: IPL Website Validation

#  Scenario: Validate the Players and Get Screenshot in IPL  Application
#    Given user navigates to IPL Application
#    When user selects the required category of players
#    And user gets all the details of Players that satisfies given condition and makes API call
#    Then user takes the screenshot of that player and add it to report
    
  Scenario: Validate Teams Winning Years
  	Given user navigates to IPL Application
  	When user makes a Get call to API and get the Team required and Hovers on it to get year of winnings
  	Then user validates the years using API
  	