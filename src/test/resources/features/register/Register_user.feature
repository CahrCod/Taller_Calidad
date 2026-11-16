Feature: As a new user I want to register on the website So that I can buy products and track my orders

Scenario: Arriving at the store
 Given I am a new user
 When I open the Automation Exercise store
 Then I see the home page
 And I see the option to sign up
 And I am not logged in

Scenario Outline: Successful registration
 Given I am a new user on the store home page
 When I register as "<name>" using a new email address
 Then I see the successful registration message
 And I am logged in as "<name>"

  Examples:
    | name |
    | Ana  |
    | Luis |

Scenario: Registration with an email address that already exists
 Given a user is already registered in the store
 When I try to sign up again with that same email address
 Then I see the message that the email address already exists
 And I remain on the signup page
