# WrkSpot - Customer Management App

This repository is for Managing customer applications. This application exposes REST services like create and get .

## Built With

* 	[JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot 2.3.1](https://spring.io/projects/spring-boot) - To ease the bootstrapping and development of new Spring Applications
* 	[Maven 3.3.3](https://maven.apache.org/) - Dependency Management
* 	[Lombok](https://projectlombok.org/) - Never write getter or equals method again, with one annotation your class has a fully featured builder,and much more.
* 	[JUnit5](https://junit.org/junit5/) - A simple framework to write repeatable tests.
* 	[Swagger 2](https://swagger.io/) - For API documentation
* 	[H2](https://www.h2database.com/html/main.html) - The Java SQL in-memory database

## Running The Application Locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.business.customermanagement.CustomerManagementApplication` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Note: Please make sure you have JDK 11 installed on your system as default runtime environment is set to Java 11. 
If you have any other version installed(should be higher than JDK 1.8), please make sure you change `java.version` property in pom.xml.

## Unit Testing

To verify every small change in the application, unit test cases have been written using JUnit5 and Mockito. You can run following command to run all test cases,

```shell
mvn test
```

## Request Details:

| Method        |                                       URL                                        | Request                                                                                                                                                                                                                                                                                  | 
| ------------- |:--------------------------------------------------------------------------------:|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| POST      |                      http://localhost:9091/api/v1/customers                      | { "firstName": "bala","lastName": "mukundh","age": 12,"mobileNumber" : "9876543210","spendingLimit" : 30000,"address": [{"address1": "No.412,First Main road,","address2": "mahatma gandhi street,","type":"tier1","state": "karnataka","city": "bangalore","country": "india","zipcode": "650008"}]} | 
| GET | http://localhost:9091/api/v1/customers?fname=bala&city=bangalore&state=karnataka | fname = firstname of the customer, city = city of the customer,  state = state of the customer(Query params are optional)                                                                                                                                                                |

## Docker Commands:

```shell
docker build -t customer-app .
docker images
docker run -p 8081:8081 customer-app
```
