# Spring Hystrix Example
This project depicts the Hystrix with Spring Hystrix and Spring Data REST Example.

## Description
This Project shows the list of Users which are stored in another microservice `https://spring-boot-tech-primers.cfapps.io/users`. 
Using the following endpoints, different operations can be achieved:
- `/rest/users` - This returns the list of Users from another microservice(General)
- `/rest/users/hystriz` - This returns the list of Users and safegaurded by Spring Cloud Hystrix using Fallback implementation.

## Libraries used
- Spring Boot
- Spring REST Controller
- Spring Cloud Hystrix

## Git 2.10.0
- IntelliJ IDEA 2016.2.4

## Compilation Command
- `mvn clean install` - Plain maven clean and install
