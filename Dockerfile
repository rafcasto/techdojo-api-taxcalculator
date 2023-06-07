# Use a base image with Java 17
FROM amazoncorretto:17-alpine-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/calculator-0.0.1-SNAPSHOT.jar target/calculator-0.0.1-SNAPSHOT.jar

# Expose the port on which the application will run
EXPOSE 8081

# Set the command to run the application
CMD ["java", "-jar", "calculator-0.0.1-SNAPSHOT.jar"]
