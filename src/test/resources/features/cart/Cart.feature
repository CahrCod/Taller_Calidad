Feature: As a registered customer I want to manage the products in my shopping cart So that I only pay for what I really need

Background:
 Given I am a customer registered and logged in to the store

Scenario Outline: Adding a product to the cart
 When I add the product "<product>" to the cart
 Then the product "<product>" is in the shopping cart
 And the product "<product>" has the price "<price>" and the quantity "1"

  Examples:
    | product       | price     |
    | Blue Top      | Rs. 500   |
    | Men Tshirt    | Rs. 400   |
    | Stylish Dress | Rs. 1500  |

Scenario: Removing a product from the cart
 Given I have a product in the shopping cart
 When I remove that product from the cart
 Then the cart no longer contains that product
