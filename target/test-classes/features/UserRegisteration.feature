Feature: User registration
  Check that the user can register successfully to our website

  Scenario Outline: User registration
    Given the user is on the home page
    When the user clicks on the register link "<Name>", "<email>"
    And enters all required valid data "<fName>", "<lName>", "<pass>", "<address>", "<country>", "<state>", "<city>", "<zCode>", "<mobNo>"
    Then the user register the account and can log in

  Examples:
    | Name        | email                  | fName | lName | pass        | address       | country | state      | city        | zCode | mobNo           |
    | John Doe    | jllnnq.d@example.com   | John  | Doe   | P@ssw0rd123 | 123 Main St   | Canada  | California | Los Angeles | 90001 | +1-555-123-4567 |
    | Emily Clark | eollyn.lqrk@example.ca | Emily | Clark | Em!ly#2025  | 456 Maple Ave | Canada  | Ontario    | Toronto     | 98754 | +1-416-555-7890 |