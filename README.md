# Harris De Swarm [![Build Status](https://travis-ci.org/anonymint/harris-de-swarm.svg?branch=master)](https://travis-ci.org/anonymint/harris-de-swarm)
 
This is just prove of concept of *Single Sign On* or *SSO* implemented as separated to 3 applications. 
Based on Spring Cloud oauth2 and docker, I put everything up here so we can just `docker-compse up`  

### Authorization 

This is simple authorization server with default `admin/admin` 

### Resource

Let just imagine this is where we put security on top of all resources, we need to authorize with proper token to get access

### UI Application

Just a POV client to connect to Authorization server in order to access Resource.

### How to run 

`docker-compose up -d` just for now but details will come soon!