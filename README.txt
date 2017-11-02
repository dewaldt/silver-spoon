DvW 2 November 2017
Purpose: Microservice example JSON application to calculate between imperial and metric with unit and integration testing examples to run as a docker application

How to run: 

1. Build JAR
mvn package && java -jar metric-0.0.1.jar

 
2. Build docker file
 dockerfile:build
 mvn install dockerfile:build
 
3. Should receive message: 

Image will be built as springio/metric:latest
 
 
4. Run docker file 
docker run -p 8080:8080 -t springio/metric:latest

5. Run services

Examples:

Temperature implementation
http://localhost:8080/temperature/celsius/3
Will give fahrenheit:35 in JSon

http://localhost:8080/temperature/fahrenheit/45
Will give celsius:7.22


Distance examples

http://localhost:8080/distance/foot/7

http://localhost:8080/distance/metre/8

http://localhost:8080/distance/inch/30

http://localhost:8080/distance/cm/188








