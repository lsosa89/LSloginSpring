# LSloginSpring
Login  Java Spring + Springboot  +  Mariadb + maven


This is a basic example of a login app using Spring and Spring boot framework.

For the porpoise of this app,  I was using a MVC approach connected to a data base (MariaDB). 
Additionally, it is possible to consume a resource (User) thought the  api.


 ![Alt text](Login/src/main/resources/Doc/structure_project.png?raw=true "Structure of the project:")
 
 This document will be divided by:
 1. View
 2. Controller
 3. restController
 4. Service
 5. Model
 6. Test 
 7. Dependencies 
 
 ## The View:
  It is stored in the folder resource/templates, This is a very simple view, I'm not using any kind of css
  code to make it pretty, in this case I'm focusing on the backend.
  
  
 ![Alt text](Login/src/main/resources/Doc/view_login.png?raw=true "Structure of the project:")
 ![Alt text](Login/src/main/resources/Doc/login.png?raw=true "view")
 
 
 ## The controller:
 In this app I have created 2 folders to manage the controllers. One in called 
 controller and the other one is called RestController.
 ### Controller: 
 Manage the MVC requests. Basically if you go to the url / (index) you will be 
 redirected to the login view .
 
 In this case I'm creating a userService variable to have access to the different services provided
 by the class user, because this is a simple example, the methods provided are the the tradicional CRUD
 and search user by email.
 
 Second there is a static variable called log. It is used to generate logs.
 Spring have different mechanism for creation and formating of message for the logs.
 
 authUser is the method used to authenticate the users. Spring boot have a specific module to control
 the authentication, it is called spring-boot-starter-security. In this case, I'm using a simple 
 validation of password.
 
 Simplification: it is really important to limit for the users the access to the different 
 resources, this is done generally through an access control list plus roles,
 In this case I'm not implementing this features. For simplicity,  Password in this case is plain text, it
 shouldn't be a simple text, this must be hashed normally using a one way direction hash function.  
 
    
 ![Alt text](Login/src/main/resources/Doc/controller_code.png?raw=true "Structure of the project:")
 ### RestController:
 In the rest controller is where we handle all the petition to the resources.
 
 ![Alt text](Login/src/main/resources/Doc/rest_controller_folder.png?raw=true )
 
 ![Alt text](Login/src/main/resources/Doc/user_resource_code.png?raw=true )
 
 In this case I have implemented 2 method for the endpoint user. GetUser and getAllUser.
 Once you are logein in the app, you will see the information of the user in json format. If the user 
 is not found in the DB. It will show a controlled message.
 ##### response User 
  ![Alt text](Login/src/main/resources/Doc/user_json.png?raw=true ).
 ##### response Users 
 ![Alt text](Login/src/main/resources/Doc/users_json.png?raw=true ).
 
 ##### curl response
 ![Alt text](Login/src/main/resources/Doc/curl_ok.png?raw=true ).
 
 ## Service:
 This is the implementation of the basics method to interact with the class user. As you can see
 I'm taking advantage of the repository in Spring to implement the CRUD operation very fast. 
 Additionally, I have added a new method called findByEmail find a user by the email address.
 
 ![Alt text](Login/src/main/resources/Doc/user_service_folder.png?raw=true )
 
 ![Alt text](Login/src/main/resources/Doc/user_service.png?raw=true )

 ## Model:
 In this case we have only one class in our model. the Class user have 4 attributes, username, email, password
 and the unique id.
 
 the configuration of the data base is done in the application.properties file:
 ![Alt text](Login/src/main/resources/Doc/application_properties.png?raw=true )

 
 ![Alt text](Login/src/main/resources/Doc/user_model.png?raw=true )
  
 ![Alt text](Login/src/main/resources/Doc/user_model_code.png?raw=true )

 
 ## Test:
  ![Alt text](Login/src/main/resources/Doc/user_test.png?raw=true )
  
I have created a simple test for our User service just to validate that the creation of the user was
working correctly. Because all the code was builded in a modular way it is really easy to create our test.

![Alt text](Login/src/main/resources/Doc/user_test_code.png?raw=true )
 
 
 ## Dependencies 
 ![Alt text](Login/src/main/resources/Doc/maven.png?raw=true )
 
 All the dependencies were managed by maven.
 For more information about which dependencies were used, take a look in the pom.xml file.
 
 
 Author :Luis Sosa
 
 
 