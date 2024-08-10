@tag
Feature: Purchase the product from ecommerce website.
	
	Background:
	Given I landed on Ecommerce page
	
  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with <email> and <password>
    When I add <product> to cart
    And  I proceed to checkout and place order
    Then Verify "Thankyou for the order." is displayed in confirmation page
    And  Close the browser

    Examples: 
      | 		email 				| 		password 		 |		product	 			|
      | anshika@gmail.com |     Iamking@000	 | 	ZARA COAT 3	|
      