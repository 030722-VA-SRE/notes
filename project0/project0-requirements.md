# Item Shop

## Description (Due: 03/23/2021)

   The Item Shop app is a simple API that facilitates interactions with some kind of item, the choice is up to you. 
	
## Purpose

   We want to see that you can meet deadlines and that you can code. You are expected to complete the following requirements and give a 5 minute presentation of your project to our QC team.

## Requirements
1. Functionality should reflect the below user stories.
2. Data is stored in a database.
3. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
4. HTTP handling in Java will be done using Javalin.
5. All public service layer methods must have at least one JUnit test.
6. Logging is implemented to log events to a file.
7. The project should be maintained in a git repository leveraging good practices.

## MVP Requirements

* As a user, I can view all items.
    * GET /items
* As a user, I can add a new item.
    * POST /items
* As a user, I can update a item.
    * PUT /items/{id}
* As a user, I can view items by ID.
    * GET /items/{id}
* As a user, I can search items by a criteria.
    * GET /items?someCriteria=
    * GET /items?someOtherCriteria=

## Bonus Requirements
Once the MVP has been achieved, try to refactor your application by adding roles: (do leverage git and a proper branching structure to always have a working copy of your project)

* As a user, I can login.
* As a user, I can register for a customer account.
* As an employee, I can add an item to the shop.
* As a customer, I can view the available items.
* As a customer, I can purchase an item.
* As an employee, I can remove an item from the shop.
* As a customer, I can view the items that I own.

## Extra bonus

Be creative and incorporate other topics into your project, they do not have to have been covered by our curriculum. Here are some suggestions:
* File I/O
* Mocking (Mockito)
* Password hashing
* JWT