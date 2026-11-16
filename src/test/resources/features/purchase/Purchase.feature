Feature: As a registered customer I want to pay for the products in my cart So that my order is confirmed and shipped to my address

Background:
 Given I am a customer registered and logged in to the store

Scenario: Confirming the purchase order
 Given I have a product in the shopping cart
 When I complete the purchase details and confirm the order
 Then I see the message that the order has been placed
