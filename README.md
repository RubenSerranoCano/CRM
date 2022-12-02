**Rubén Serrano Cano**
# Assessment CRM
## Table of contents

 - Highlights
	 - Login and signup
	 - React UI
	 - Layered (MVC) back end
	 - Test driven development
	 - Password encoding
	 - Restricted access to URL paths
	 - Persistence with JPA, Hibernate and PostgreSQL
 - Design
	 - Database logical schema
	 - REST API
	 - React UI
 - Further improvements
	- REST API endpoints parameters
	- JWT and security
	- DTOs
## Highlights

**Login and signup**
A single form has been designed for user login and signup containing email and password fields and a pair of buttons: login and signup. Each button will consume an endpoint and provide the required data to the service, the back end will process this fields and determine whether the user can login or signup. With help of both ends, this form is able to deliver error messages to the user when necessary and to grant access to the front end app.
***
**React UI**
A web page has been made with the React library in order to fulfill the assessment requirements.
***
**Layered (MVC) back end**
A Spring Boot application has been developed to enable data management and scalability. This application is structure in the following layers, each one with a single responsibility:

 - Presentation: layer meant to enable communication between the front end and the services. This package contains REST Controllers. As a proof of concept, the *client* controller contains a controller advice to act as a middleman and return a response status and body whenever a custom exception is thrown.
 - Service: this is where the business logic takes place, is in charge of receiving data from the REST controller in order to manipulate it and allow its storage thanks to the repository layer. As a design rule, services can only be used by REST controllers and other services.
 - Persistence: this layer holds a model and a repository package; the model package is meant to represent the system entities whereas the repository holds interfaces that extend the JPA repository to enable data persistence.
***
**Test driven development**
The back end services have been designed through test driven development. First the test to be passed was designed, then the service interface was written, after that, the test was failed on purpose to prove the lack of implementation and finally the service was implemented to pass the test.
****
**Password encoding**
For security reasons, the sensible data stored into the database is encoded through one way encryption algorithms so that it is safe and legal to store it, this has been done for the user's password.
****
**Restricted access to URL paths**
In order to prevent an unauthorized user from user the service the front end URL paths are blocked if an access token is missing. This is not safe nor production ready but manages to provide a real user experience for testing and presentation purposes.
****
**Persistence with JPA, Hibernate and PostgreSQL**
Data persistence has been enabled with JPA, Hibernate and PostgreSQL. Hibernate is a framework and implementation of the JPA that can generate a database schema through annotations on Java classes. PostgreSQL is the SQL database used to store the data.
**** 
## Design

**Database logical schema**
![Database logical schema image](https://raw.githubusercontent.com/RubenSerranoCano/CRM/develop/CRMLogicalDBSchema.png)
****
**REST API**
The REST API documentation has been made with Swagger UI so it can be found at [Swagger UI](http://localhost:8090/swagger-ui/index.html#/) **when running the application** (otherwise it won't be available).
This is an image page content:
![enter image description here](https://raw.githubusercontent.com/RubenSerranoCano/CRM/develop/swagger-ui_index.png)
**REACT UI**
Login page
![enter image description here](https://raw.githubusercontent.com/RubenSerranoCano/CRM/develop/react-login.png)
## Further improvements

**REST API endpoints parameters**
It would be useful to add the user id to the endpoints parameters so that the data retrieved is the one actually linked to that user.
****
**JWT and security**
Security is key and at its current state the application is missing any kind of actual security.
****
**DTOs**
In order to provide the user with specific data matching its requests it would be useful to design data transfer objects.
****
