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


## Prerequisites prior running the application
- Create a new Schema in MySql called bank_system (this can be changed in application.properties)
- Create a new database user called bankUser and with password password (different credentials can be used as long as the application.properties database config are changed)
- VERY IMPORTANT the system does not expose any database ids since all exposed ids are encoded, thus is is crucial to copy local_policy.jar & US_Export_policy.jar (located in this project in JRE_Security folder) and paste both files in your JRE Security Folder (On my mac it is located in /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/security/)


## Running The Application
Once Db and Java security jar are in place running the app is very easy, just go in the project folder from terminal and execute mvn spring-boot:run

## Testing the system
Below please find link to my Postman collection in order to run all Apis

https://www.getpostman.com/collections/e69a7d2f46be361e5fbf


## Contact me
If you find an issue please feel free to contact on christmagro@gmail.com