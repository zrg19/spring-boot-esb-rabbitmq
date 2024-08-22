# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's JAR file
ARG JAR_FILE=target/spring-boot-esb.jar

# Add the application's JAR file to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
