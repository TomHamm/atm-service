# ATM Machine - Zinkworks 2 Day Java Home Assignment

## Requirements to Run

You need to have the following installed:

- Java 8
- PostgreSQL
- Maven
- Docker

## DB Setup

The Application Interacts with a Postgress Database so a DB will have to be set up locally

This can be Done using PG Admin and creating a database - atm

![alt text](https://github.com/TomHamm/Resources/blob/main/database.jpg)

The application.properties file will define the connection to the DB - see Credentials being used below

![alt text](https://github.com/TomHamm/Resources/blob/main/databaseCredentials.jpg)

Required Tables will be created on startup of the Application

## Running the Application Locally

When the Repo has been cloned locally, run the following commands in the root directiory to start the Application

- mvn clean install
- spring-boot:run

## Running on Docker

![alt text](https://github.com/TomHamm/Resources/blob/main/Dockerfile.jpg)

When the Repo has been cloned locally, run the following commands in the root directiory to run the Application on Docker

- docker build -f Dockerfile -t atm-service .
- docker run -p 8081:8081 atm-service

Note: When running on Docker the ip address and port being used to conect to Postgress will differ per machie 

## Manual Tests - Postman
