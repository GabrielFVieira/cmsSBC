# CMS SBC

CMS API made for the TCC00340 class

## To run the application:

- Install docker, if its not already installed
- Download the project
- Inside the project folder open the command prompt
- Run "mvn clean install" to generate the .jar file
- Run "docker-compose up" to build the docker image of the application and download the mysql:5.7 image used to provide the needed database

After that a docker container should start, inside it there must be two services:

- An instance of mysql with a single database called 'csmsbc' running at the port 3306
- An instance of the csm running at the port 8088

## To test the application:

After the docker container start, open the following URL in your browser: "http://localhost:8088/". \
 It should redirect you to the Swagger UI page that has all the endpoints of the api and the description of the possible parameters for each one of them. \
 From that page is possible to test all the endpoints, but if you want you can test it from Insomnia, Postman or any other tool.
