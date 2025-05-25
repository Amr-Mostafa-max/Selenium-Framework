Feature: Automated E2E Scenario
Check that the suer can register, add product to cart , check out and downlaod the invoice

Scenario Outline:
Given the user opens the home page
When  the user clicks on register link "<Name>", "<email>"
And   enter all valid required data  "<fName>", "<lName>", "<pass>", "<address>", "<country>", "<state>", "<city>", "<zCode>", "<mobNo>"
And   add product to the cart 
Then  the user can check out and download thier invoice successfully  "<commentArea>" ,  "<cardName>" ,	"<cardNum>" , "<cvvNum>", "<expMonth>", "<expYear>"

Examples:

    | Name        | email                  | fName | lName | pass        | address       | country | state      | city        | zCode | mobNo           |commentArea                 |  cardName |   cardNum  | cvvNum     |expMonth    |expYear   |                                                                 
    | John Doe    | Amwluu.d@example.com    | John  | Doe   | P@ssw0rd123 | 123 Main St   | Canada  | California | Los Angeles | 90001 | +1-555-123-4567 | Please I want free delivery| Amr Fady  |   12674354  | 432        | 12         | 2029     |

