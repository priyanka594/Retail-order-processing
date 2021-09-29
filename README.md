# Retail-order-processing
Retail management system 

Retail management system is a Java application built on Springboot framework. The application connect to the mongo db to store the data and uses Apache kafka as the messaging queue. the application is secured using JWT authentication using Spring security.

## Components
* Spring Initiliser tool to create a Springboot project, gradle is the build tool used.
* Mongo db 
* Apache Kafka

## Endpoints

* POST	/api/auth/signup	signup new account

* POST	/api/auth/signin	login an account

* POST /createorder       creates an order

* GET /prevorder          fetches all the orders by user




