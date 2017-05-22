# Bank Account Management System

This is a basic fully functional Rest Api Account to Account System
 
## System Main features consist in the following:

- Basic user authentication (Using Bycrpt(11) Password)
- Global Exception Handling
- Client creation 
- List all Clients
- Create new Client Account
- Effect a transfer between 2 accounts (Taking care of all the Dr/Cr money movement)
- List Accounts for a particular client
- List transactions for a particular account (Including both Debit and Credit) 

## Some Technologies used
- Java
- Spring Boot, Security
- Hibernate
- MySql
- FlyWay
- Orika
- Lombok
- Docker


## Prerequisites prior running the application
- Docker is required to run the application

## Running The Application
- Go in the project folder and from the terminal execute mvn clean package docker:build
- Then execute docker-compose up in order to start MySQL DB and Application containers
- All APIs can be accesses using http://localhost:8080/


##Credentials:
In order to access api basic authentication is required using the below credentials
username:user1
password:password

Below please find link to my Postman collection in order to run all Apis
https://www.getpostman.com/collections/5d7b1f2d0cc71fd97c36

## Contact me
If you require any additional information please feel free to contact me on christmagro@gmail.com