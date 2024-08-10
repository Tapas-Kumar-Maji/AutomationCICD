
@tag
Feature: Error Validation
	
	Background: 
		Given I landed on Ecommerce page

  @tag2
  Scenario Outline: To validate correct error toast
    When I login with <email> and <password>
    Then toast message is "Incorrect email or password."
    And Close the browser

    Examples: 
      | 			email  			 |	password 	 |
      | tapasmaj@gmail.com | #1Tapasmaji |
      