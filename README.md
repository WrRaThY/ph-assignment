# PH Assignment
this project is a recruitment task  
company name was redacted for a reason :)

## Goal
the project is pretty simple. 

The backend is supposed to persist customers and provide an API for accessing their information.   
Customers can then be displayed on the frontend.

The user should be able to:  
- Filter and sort the list of customers.  
- Click on a customer in the list to view their details and add/edit notes for that customer.  
- Change their status.  


Customers have the following information associated with them:  
- Unique customer identifier.  
- Status: one of "prospective", "current" or "non-active".  
- Creation date and time.  
- General information like name and contact details.  

## Project Structure
you can find two modules in this project: `frontend` and `backend`. Names are pretty self-explanatory...

each module has its own `README.MD` file that describes:
- technologies used (briefly)  
- how to build it  
- how to run it  

## General comments
I'll try to make a comment here whenever I make a shortcut as a result of a tight deadline.
 
* Tests - the service is so simple, that writing a whole battery of tests would be an overkill.  
If you want to see that I can write them - please visit one of those repositories: [one][cli-rpg-test], [two][trade-validator-test]  
Here I provided only some simple integration tests, which just help me develop faster.  
* Model - db / view models are the same, so there was no point in separating them, hence the model is very simplistic. Maybe even too much sometimes... For a more complicated 
app I couldn't do that.  
* HATEOAS - Might be helpful in some cases, but it's not worth exploring here. Especially, becase the description does not provide any information about a state machine based on 
statuses. One can change statuses without any additional rules.  
* Paging/sorting - since it's a simple test app - there is no paging and sorting is done on the client side. For a real system - it would have be analyzed and a proper solution 
chosen.  
* Error handling - there is not to much to do here, so I just placed one `orElseThrow(...)` and cought it in an `ExceptionHandler` just to show I know how. Other possibility 
would be to return a `ResponseEntity` with a proper code.    
* Monitoring, Logging, API Documentation - more info in `backend/README.md`

[cli-rpg-test]: https://github.com/WrRaThY/cli-rpg/tree/master/src/test/java/priv/rdo/rpg  
[trade-validator-test]: https://github.com/WrRaThY/trade-validator/tree/master/src/test  
