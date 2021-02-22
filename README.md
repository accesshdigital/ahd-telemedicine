
# AHD Telemedicine microservices built with Spring Cloud
[![License: MPL 2.0](https://img.shields.io/badge/License-MPL%202.0-brightgreen.svg)](https://opensource.org/licenses/MPL-2.0)


Telemedicine refers to the practice of caring for patients remotely when the provider and patient are not physically present with each other. Modern technology has enabled doctors to consult patients by using video-conferencing tools.

Microservices is an architectural style that has been adopted by many organizations like Netflix, Amazon and so on. Microservices architecture technically just structures the entire application as a collection of autonomous services that are loosely coupled, independently developed as well as deployed, highly maintainable, and testable. It allows the organizations to evolve in the technology stack as per the required functionality of the application.




### AHD Telemedicine Microservices Implementation

Spring Boot is the core technology that is used for AHD Telemedicine microservices implementation. It simplifies the implementation of the tasks of building REST-based microservices. Spring Boot also simplifies mapping HTTP style verbs (GET, PUT, POST and DELETE) to URLs and JSON protocol sterilization to and from Java objects. Also, mapping of java exceptions back to HTTP error codes. 



1. **AHD Telemedicine Cloud Configuration:** Spring Cloud Configuration handles the management of cloud configuration data via centralized configuration which separates the application configuration data with the deployed microservices. It ensures that regardless of any new number of microservices being introduced in the application, their configurations remain the same. The spring cloud config has its property management repository but sometimes it integrates with open source projects like Git, Consul & Eureka. 
2. **AHD Telemedicine Service Discovery:** In spring Cloud service discovery, the physical location of the servers deployed is hidden from the clients and it is consumed using services. Thus, the servers call the business logic for the server using the name assigned to it rather than the physical location of the logic. It also handles the bootstrap services and registration as well as the deregistration of the services. Some of the common examples for the service discovery are Consul and Eureka.
3. **AHD Telemedicine Hystrix and Ribbon:** Spring Cloud relies and integrates heavily on Netflix open source projects. For microservices client resiliency patterns, Spring cloud mixes Netflix Hystrix and Ribbon project. With Netflix Hystrix libraries, it implements the service client resiliency patterns like Circuit breaker as well as bulkhead patterns. With Netflix Ribbon projects, it simplifies integration with the service discovery projects like Eureka, it also helps with the client-side load-balancing of the service calls from a customer. It further allows the client to execute the service calls even when service discovery is not available. 
4. **AHD Telemedicine Zuul Gateway**: Spring Cloud utilizes Netflix Zuul Project for a microservice application to help with the service routing capabilities. Zuul is a service gateway that delegates service requests and assures that all calls to microservices go via a single front controller before the targeted service is called. This results in the centralization of the service calls, which can later help us in enforcing service policies like security authorization, service authentication, content filtering, and routing rules. 
Zuul provides a range of different types of filters that allows us to quickly and nimbly apply functionality to our edge service. The filters perform the following functions:

* Authentication and Security: It provides authentication requirements for each resource.
* Insights and Monitoring: It tracks meaningful data and statistics that give us an accurate view of production.
* Dynamic Routing: It dynamically routes the requests to different backed clusters as needed.
* Stress Testing: It increases the traffic to a cluster in order to test performance.
* Load Shedding: It allocates capacity for each type of request and drops a request that goes over the limit.
* Static Response Handling: It builds some responses directly at the edge instead of forwarding them to an internal cluster.
* Multi-region Resiliency: It routes requests across AWS regions in order to diversify our ELB usage.

   **Zuul 2.x components:**

* zuul-core: It is a library that contains the core functionality of Zuul 2.0.
* zuul-sample: It is a sample driver application for Zuul 2.0 
Setting up Zuul API Gateway Server
There are three steps to set up the Zuul API Gateway:

Create a component for the Zuul API Gateway
Decide the things that the Zuul API Gateway should do
All the important requests are configured to pass through the Zuul API Gateway
Follow the steps to set up the Zuul API Gateway server.

**Step 1: Open Spring Initializr https://start.spring.io.**

**Step 2: Provide the Group name. We have provided com.javatpoint.microservices.**

**Step 3: Provide the Artifact. We have provided netflix-zuul-api-gateway-server.**

**Step 4: Add the following dependencies: Zuul, Eureka Discovery, Actuator, and DevTools.**

![GitHub Logo](https://static.javatpoint.com/tutorial/microservices/images/zuul-api-gateway.png)

**Step 5: Click on the Generate button. It starts packing the project into zip file and download it.**

**Step 6: Extract the zip file and paste it in the Spring Tool Suite’s workspace.**

**Step 7: Import the project in the STS IDE.**

File -> Import -> Existing Maven Projects -> Browse -> Select netflix-zuul-api-gateway-server -> Select Folder -> Finish

It takes some time to import.

**Step 8: Open the NetflixZuulApiGatewayServerApplication.java file and enable zuul proxy and discovery client by using the annotations @EnableZuulProxy and @EnableDiscoveryClient, respectively.**



NetflixZuulApiGatewayServerApplication.java

```java
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;  
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;  
@EnableZuulProxy  
@EnableDiscoveryClient  
@SpringBootApplication  
public class NetflixZuulApiGatewayServerApplication   
{  
public static void main(String[] args)   
{  
SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);  
}  
} 

```

application.properties

```java
spring.application.name=netflix-zuul-api-gateway-server  
server.port=8765  
eureka.client.service-url.default-zone=http://localhost:8765/eureka
```


**Step 9: Open application.properties file and configure the application name, port, and eureka naming server.**




5. **AHD Telemedicine Cloud Stream:** Spring Cloud Stream is a framework for building highly scalable event-driven microservices connected with shared messaging systems. The framework provides a flexible programming model built on already established and familiar Spring idioms including support for persistent pub/sub semantics, consumer groups, and stateful partitions. Using Spring Cloud Stream, we can integrate our microservices with message brokers like RabbitMQ as well as Kafka. It can also build microservices that execute asynchronous events as they occur. 
6. **AHD Telemedicine Sleuth/Zipkin:** Spring Cloud Sleuth helps integrate tracking identifiers into message brokers (RabbitMQ & Kafka) and HTTP calls being used in the microservices. These tracking identities are also known as trace IDs or Correlation, it allows the application to track the transactions flow in the microservices application. In Spring Cloud Sleuth, these tracking IDs are automatically stored in any logging statements of the microservices application. Sometimes, the spring cloud sleuth is combined with logging technology tools like Papertrail (It is a cloud-based logging platform that helps in clustering all the logs in real-time from various microservices into one database) and Tracing tools like Zipkin (It helps in taking data from the spring cloud sleuth and visualizing the flow of the service calls involved in a single transaction).
7. **AHD Telemedicine Patient Registraion:** AHD Telemedicine Patient Registraion microservices provides functionalities related to patient registration. 

8. **AHD Telemedicine Appointment:** AHD Telemedicine Appointment provides functionalities related to patient appointment. 

9. **AHD Telemedicine Patient Registraion:** AHD Telemedicine Patient Registraion microservices provides functionalities related to patient registration. 
10. **AHD Telemedicine Subjective:** AHD Telemedicine Subjective microservices  provides functionalities related to patient appointment. 
11. **AHD Telemedicine Objective :** AHD Telemedicine Patient Objective microservices provides functionalities related to patient objective. 
12. **AHD Telemedicine Assessment:** AHD Telemedicine Assessment microservices provides functionalities related to patient assessment. 
13. **AHD Telemedicine Plan :** AHD Telemedicine Patient Plan microservices provides functionalities related to patient Plan. 
14. **AHD Telemedicine Referral:** AHD Telemedicine Referral microservices provides functionalities related to patient referral. 
15. **AHD Telemedicine Patient Portal:** AHD Telemedicine Referral microservices provides functionalities related to Patient Portal. 


### Starting AHD Telemedicine services locally without docker-compose:

Every microservice is a Spring Boot application and can be started locally using IDE ([Lombok](https://projectlombok.org/) plugin has to be set up) or ../mvnwspring-boot:run command. 

Please note that supporting services (Config and Discovery Server) must be started before any other application. Start-up of Tracing server, an Admin server, Grafana, and Prometheus is optional. If everything goes well, you can access the following services at a given location:



*   **AHD Telemedicine Discovery Server** - [http://localhost:8761](http://localhost:8761/)
*   **AHD Telemedicine Config Server** - [http://localhost:8888](http://localhost:8888/)
*   **AHD Telemedicine Tracing Server (Zipkin)** - [http://localhost:9411/zipkin/](http://localhost:9411/zipkin/) (we use [openzipkin](https://github.com/openzipkin/zipkin/tree/master/zipkin-server))
*   **AHD Telemedicine Admin Server (Spring Boot Admin)** - [http://localhost:9090](http://localhost:9090/)
*   **AHD Telemedicine Grafana Dashboards** - [http://localhost:3000](http://localhost:3000/)
*   **AHD Telemedicine Prometheus** - [http://localhost:9091](http://localhost:9091/)
*   **AHD Telemedicine ELK Server** - [http://localhost:8282](http://localhost:8282/)
*   **AHD Telemedicine JWT Auth Service** - [http://localhost:8080](http://localhost:8080/)
*   **AHD Telemedicine Hystrix** - [http://localhost:8181](http://localhost:8181/)
*   **AHD Telemedicine Zipkin Server** - [http://localhost:9411](http://localhost:9411/)
*   **AHD Telemedicine Admin Server (Spring Boot Admin)** - [http://localhost:9090](http://localhost:9090/)
*   **AHD Telemedicine Registraion** - [http://localhost:3000](http://localhost:8284/)
*   **AHD Telemedicine Appointment** - [http://localhost:9091](http://localhost:9091/)
*   **AHD Telemedicine Subjective** - [http://localhost:9202](http://localhost:9202/)
*   **AHD Telemedicine Object** - [http://localhost:9092](http://localhost:9092/)
*   **AHD Telemedicine Plan** - [http://localhost:8087](http://localhost:8087/)
*   **AHD Telemedicine Assessment** - [http://localhost:8182](http://localhost:8182/)
*   **AHD Telemedicine Patient Portal Server** - [http://localhost:7212](http://localhost:7212/)





You can tell Config Server to use your local Git repository by using native Spring profile and setting GIT_REPO environment variable, for example, Dspring.profiles.active=native -DGIT_REPO=/projects/spring-mvp-microservices-config

### Starting AHD Telemedicine services locally with docker-compose:

To start an entire infrastructure using Docker, you have to build images by executing./mvnw clean install -P build docker from the project root. Once images are ready, you can start them with a single command docker-compose up. Containers' start-up order is coordinated with dockerize script. You can track service availability using the Eureka dashboard available by default at _http://localhost:8761._

The master branch uses an Alpine Linux with JRE 8 as a Docker base. You will find a Java 11 version in the release/java11 branch.

NOTE: Under MacOS or Windows, make sure that the Docker VM has enough memory to run the microservices. The default settings are usually not enough and make the docker-compose up painfully slow_._

### Understanding the AHD telemedicine application:



1. **AHD Telemedicine Cloud Config Server:** Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server, we have a central place to manage external properties for applications across all environments.**   **
2. **AHD Telemedicine Cloud Eureka Server:** A distributed system typically comprises many services that communicate with each other to perform certain operations. Service discovery is the process of one service dynamically discovering the network location (IP address and port) of another service to communicate with it.
3. **AHD Telemedicine Cloud Gateway Server:** An API Gateway acts as a single-entry point for a collection of microservices. Any external client cannot access the microservices directly but can access them only through the application gateway. In a real-world scenario, an external client can be any one of the three: Mobile Application, Desktop Application, and External Services or third-party Apps. 
4. **AHD Telemedicine Admin Server:** Monitoring microservice applications by using Spring Boot Actuator Endpoint is slightly difficult. Because, if we have ‘n’ number of applications, every application has separate actuator endpoints, thus making monitoring difficult. Spring Boot Admin Server is an application used to manage and monitor all microservices using a single dashboard.

5. **AHD Telemedicine Cloud ELK Server:** The ELK Stack is a collection of three open-source products — Elasticsearch, Logstash, and Kibana.
ELK Stack is designed to allow users to take data from any source, in any format, and to search, analyze, and visualize that data in real time. ELK provides centralized logging that is useful when attempting to identify problems with servers or applications. It allows you to search all your logs in a single place. It also helps to find issues that occur in multiple servers by connecting their logs during a specific time frame.

6. **AHD Telemedicine JWT Auth Server:** JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed. JWTs can be signed using a secret (with the HMAC algorithm) or a public/private key pair using RSA. This server is used for providing authentication & authorization of all microservice communication.

7. **Hystrix:** Netflix Hystrix allows us to introduce fault tolerance and latency tolerance by isolating failure and by preventing them from cascading into the other part of the system building a more robust distributed application. Netflix also provides a feature to monitor all of the services within the distributed application boundary.
Hystrix stream provides information on a single application, Turbine provides a way to aggregate this information across all installations of an application in a cluster.

8. **Zipkin:** A Java-based distributed tracing application that helps gather timing data for every request propagated between independent services. It has a simple management console where we can find a visualization of the time statistics generated by subsequent services.

9. **Spring Cloud Sleuth:**  A Spring Cloud library that lets you track the progress of subsequent microservices by adding trace and span id’s on the appropriate HTTP request headers. The library is based on the MDC (Mapped Diagnostic Context) concept, where you can easily extract values put to context and display them in the logs.

10. **Custom metrics monitoring:** Grafana and Prometheus are included in the docker-compose.yml configuration, and the public-facing applications have been instrumented with [Micrometre](https://micrometer.io/) to collect JVM and custom business metrics. A JMeter load testing script is available to stress the application and generate metrics: mvp_test_plan.jmx

![Grafana metrics dashboard](https://raw.githubusercontent.com/accesshdigital/sea-mvp-microservice/master/docs/grafana-custom-metrics-dashboard.png)


### Using Prometheus:

Prometheus can be accessed from your local machine at [http://localhost:9091](http://localhost:9091/)

### Using Grafana with Prometheus:

Anonymous access and Prometheus data source are set up. 

A Spring mvpc Metrics Dashboard is available at the URL http://localhost:3000/d/69JXeR0iw/spring-mvpmetrics. You will find the JSON configuration file here: docker/grafana/dashboards/grafana-mvp-dashboard.json.

You may create your dashboard or import the Micrometer/SpringBoot dashboard via the Import Dashboard menu item. The id for this dashboard is 4701.

11. **AHD Telemedicine Patient Registraion:** AHD Telemedicine Patient Registraion microservices based on Access Health Digital Registraion MVP provides functionalities related to patient registration. 

12. **AHD Telemedicine Appointment:** AHD Telemedicine Appointment  microservices based on Access Health Digital Appointment MVP provides functionalities related to patient appointment. 

13. **AHD Telemedicine Patient Registraion:** AHD Telemedicine Patient Registraion microservices based on Access Health Digital Registraion MVP provides functionalities related to patient registration. 

14. **AHD Telemedicine Subjective:** AHD Telemedicine Subjective microservices based on Access Health Digital Subjective MVP provides functionalities related to patient appointment. 

15. **AHD Telemedicine Objective :** AHD Telemedicine Patient Objective microservices based on Access Health Digital Objective MVP provides functionalities related to patient objective. 

16. **AHD Telemedicine Assessment:** AHD Telemedicine Assessment  microservices based on Access Health Digital Assessment MVP provides functionalities related to patient assessment. 

17. **AHD Telemedicine Plan :** AHD Telemedicine Patient Plan microservices based on Access Health Digital Plan MVP provides functionalities related to patient Plan. 



### Using MDDS valuset with Telemed Application:

https://p193z7.deta.dev/facility_type_values

https://p193z7.deta.dev/health_individual_care_provider_number_type_values

https://p193z7.deta.dev/healthcare_plan_type_values

https://p193z7.deta.dev/admission_type_values

https://p193z7.deta.dev/discharge_status_values

https://p193z7.deta.dev/allergy_product_values

https://p193z7.deta.dev/icd10_master_values

https://p193z7.deta.dev/severity_codes_master_values

https://p193z7.deta.dev/status_codes_values

https://p193z7.deta.dev/medical_speciality_type_values

https://p193z7.deta.dev/registration_authority_values

https://p193z7.deta.dev/healthcare_applications_master_values

https://p193z7.deta.dev/health_service_provider_role_values

https://p193z7.deta.dev/blood_group_values

https://p193z7.deta.dev/ownership_authority_type_values

https://p193z7.deta.dev/alternate_uhid_type_values



PLease refer our MDDS XML/XSD for complete valuset refrence
