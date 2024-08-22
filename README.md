# Spring Boot RabbitMQ ESB

This project demonstrates how to build an Enterprise Service Bus (ESB) architecture using Spring Boot 3.3.2 and RabbitMQ with Docker. The application includes components for message production, consumption, routing, and transformation, all integrated into a Spring Boot environment.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Clone the Repository](#clone-the-repository)
    - [Setting Up RabbitMQ with Docker](#setting-up-rabbitmq-with-docker)
    - [Build and Run the Spring Boot Application](#build-and-run-the-spring-boot-application)
    - [Accessing the Application](#accessing-the-application)
- [Usage](#usage)
- [Monitoring](#monitoring)
- [Summary](#Summary)

## Features

- **Message Queues:** RabbitMQ configured with Docker.
- **Producers & Consumers:** Message producers and consumers implemented using Spring Boot.
- **Message Routing & Transformation:** Business logic for routing and transforming messages.
- **Docker Integration:** Full Docker support for RabbitMQ and Spring Boot.

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.2**
- **RabbitMQ**
- **Docker**
- **Docker Compose**

## Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- **Java 17 or higher**
- **Maven 3.8+**
- **Docker and Docker Compose**

## Getting Started

### Clone the Repository

Start by cloning this repository to your local machine:

```bash
git clone https://github.com/zrg19/spring-boot-esb-rabbitmq.git
cd spring-boot-esb-rabbitmq
```
### Setting Up RabbitMQ with Docker
RabbitMQ is configured to run in a Docker container. Follow these steps to get RabbitMQ up and running:

Create and start the RabbitMQ Docker container:

```bash
docker-compose up -d rabbitmq
```

This will start RabbitMQ with the management UI accessible at http://localhost:15672. The default username and password are guest/guest.

### Build and Run the Spring Boot Application
#### Build the application using Maven:


```bash
./mvnw clean package -DskipTests
```

### Run the application:

If you want to run the Spring Boot application locally without Docker, use:

```bash
./mvnw spring-boot:run
```
### Build the docker image with Dockerfile

```bash
docker build -t spring-boot-esb:latest .
```

### To run the application inside a Docker container:

```bash
docker-compose up -d --build
```

This will start the Spring Boot application along with RabbitMQ in Docker containers.

### Accessing the Application
Spring Boot Application: http://localhost:8080
RabbitMQ Management UI: http://localhost:15672 (Username: guest, Password: guest)

### Usage
#### Send a Message:
You can send a message to the system using a REST API endpoint or directly from the code.

#### Receive and Process Messages:
Messages will be consumed from the respective RabbitMQ queues and processed by the consumers defined in the application.

### Monitoring
Spring Boot Actuator is enabled for monitoring. You can check the application's health and other metrics:

- Health Check: http://localhost:8080/actuator/health

### Summary

- **Clone the Repository:** Explains how to clone the repository from GitHub.
- **Setting Up RabbitMQ with Docker:** Provides commands to start RabbitMQ using Docker.
- **Build and Run the Spring Boot Application:** Covers building the application using Maven and running it locally or in a Docker container.
- **Accessing the Application:** Specifies how to access the Spring Boot application and RabbitMQ management UI.
- **Usage and Monitoring:** Details on sending and receiving messages and monitoring the application with Actuator.