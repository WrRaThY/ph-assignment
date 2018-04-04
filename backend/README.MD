# PH Assignment - backend

## Technologies used
I've chosen Java 9 and Spring 5/Spring Boot 2 just to see how this goes.   
I spent last couple of months writing in Kotlin, so this will be a nice reminder :)

Underlying database is MongoDB, because it lets me forget about problems with schema, but still provides a great searching / indexing mechanism. If the project was longer the 
choice would probably be more difficult, but Mongo seems great here.

Spock is used for testing, because there is no better tool for testing.   
This one was a no-brainer :)

## Building
Run `mvn clean package`.  
You can find the package in `target` folder.

## Running
There are two ways to run the application:  
1. `Dev` - Run the `main` method in `Application` class using your favourite IDE.  
2. `Prod` - run `java -jar backend-*.jar`  

## Deplying
Just drop the package, using any method you like, on a server and run it
