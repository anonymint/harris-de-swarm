# Harris De Swarm [![Build Status](https://travis-ci.org/anonymint/harris-de-swarm.svg?branch=master)](https://travis-ci.org/anonymint/harris-de-swarm)
 
Note: Build on Travis is on hold! 
 
This is just prove of concept of *Single Sign On* or *SSO* implemented as separated to 3 applications. 
Based on Spring Cloud oauth2 and docker, I put everything up here so we can just `docker-compse up`  

### Authorization 

This is simple authorization server with default `admin/admin` 

### Resource

Let just imagine this is where we put security on top of all resources, we need to authorize with proper token to get access

### UI Application

Just a POV client to connect to Authorization server in order to access Resource.

### How to run 

#### IDE

In the project has 3 repos Authorization, Resource and UI powered by spring boot. To run it from IDE, we just run each application main to start up `spring boot` with `java8` installed 

#### Maven

    mvn clean verify spring-boot:run
    
#### Docker
Less hassle if you don't want to install anything, it will start 3 apps and link everything.

    docker-compose up -d 
