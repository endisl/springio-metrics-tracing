# Metrics and Tracing with Spring

## Setting up the project
- Java 17
- Maven project
- Both the service and the client applications have the following dependencies:
  - Spring Reactive Web
  - Spring Boot Actuator
  - Lombok
  - Sleuth
  - Wavefront
- Applications properties are the same except for the server.port setted only in the service application.

## Running the application
The service is run first, then the wavefront link is opened in the browser, and finally the client is started.

## Using the Wavefront Dashboard
Metrics and Traces can be analyzed, for instance, to retrieve the requests with errors and their low cardinality.  
The data provided can also be enhanced with Business Context, to analyze for example, the type of item requested by our site's visitors.  
To do so, tags has to be customized in the service application so that they are captured by Spring Boot and given to Micrometer.
