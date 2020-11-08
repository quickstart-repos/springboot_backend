# Basic spring project

## Features

This project bootstraps a simple backend REST application that connects to a SQL database (H2 database) and also 
provides basic security features. In order to run this project, you must export some environment variables defined
at the application property files. Right now, we have the following environment variables:

1. DB_USERNAME
2. DB_PASSWORD

The server will run at the 3333 port. It is also provided a Dockerfile, which you can use to run this service into a container
and change the used port at will.

## Project Structure

We are using a layered architecture, that is organized as follows:

```
|-- com.quickstart.backend
	BackendApplication.java (Main class)
    |-- com.quickstart.backend.models (Classes defined at the database)\
    |-- com.quickstart.backend.dao (Code that controls the interface between the structured data at the DB and the classes at the Java code)
    |-- com.quickstart.backend.service (Transaction layer for the database operations. Allow rollback on errors)
    |-- com.quickstart.backend.exception (Error handling layer)
    |-- com.quickstart.backend.controllers (Classes that control the REST endpoint)
    |-- com.quickstart.backend.security (Security layer configuration)
    	|-- com.quickstart.backend.security.adapters (Package that contains the security providers)
 ```
 
 At the security provider package, we use an hexagonal architecture, so we define a security provider interface and an actual implementation
 should be provided depending on the specific authentication method. 