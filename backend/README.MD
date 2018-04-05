# PH Assignment - backend

## Technologies used
* I've chosen Java 9, Spring 5/Spring Boot 2 and maven just to see how this goes.   
I spent last couple of months writing in Kotlin/gradle, so this will be a nice reminder :)

* Underlying database is Embedded MongoDB, because it's great for prototyping and there was no requirement for the datastore to be persistent between runs.  
Other thing is that using a proper MongoDB server is as easy as running `docker run -p 27017:27017 mongo` and changing the DB URL.  
Second factor is that I just wanted to play around with embedded MongoDB :)  
In a real system a choice of a DB is usually a pretty important one and there is a lot to consider there.

* Spock is used for testing, because there is no better tool for testing. Period.

* API Documentation - Swagger endpoint is available here: `http://localhost:8080/documentation`
Every decent system should have some form of API documentation. This one comes almost for free, so I decided to use it here.  
API is sometimes a bit strange (returning `Customer` from a `removeNote` method), but that makes frontend integration easier, which means faster (not better).  

* Monitoring - basic metrics are exposed via the API.  
Normally data should be collected by an external system, for example Graphite/Grafana, Datadog or others.  
Example requests:

    ```text
    http://localhost:8080/actuator/metrics/
    http://localhost:8080/actuator/metrics/http.server.requests
    http://localhost:8080/actuator/metrics/http.server.requests?tag=uri:/customers
    ```
* Logging - there is some manual logging (method entry for example) that could be managed with AOP.  
All requests and responses could also be logged using an interceptor.  
I enabled only a console logger. In a normal application I would also set up a RollingFileAppender or something similar. Logs should be then collected by some 
external system like Splunk, ELK or something similar.  
I also enabled TRACE as the default logging level for this app. This should be managed on environments other than DEV.  

## Building
Run `mvn clean package`.  
You can find the package in `target` folder.

## Running
There are two ways to run the application:  
1. `Dev` - Run the `main` method in `Application` class using your favourite IDE.  
2. `Prod` - run `java -jar backend-*.jar`  

## Deploying
Just drop the package, using any method you like, on a server and run it  
It would also be a good idea to wrap it in a docker container (same goes for the frontend), but (again) due to time restriction - I will not follow that path.
