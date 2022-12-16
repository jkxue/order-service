# Getting started
## Environment
* java 11
* maven 3.6
## Run with IDE
if you have setup your local env, you can directly run the app with IDE


## Run with Maven

 ``` shell
mvn clean package spring-boot:run
 ```

## Using docker
 ``` shell
docker-compose up order-service
 ```
Service Url: http://localhost:8762/

build image
 ``` shell
 docker build -t order-service:1.0.0 .
 ```
