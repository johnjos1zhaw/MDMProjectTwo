# Use the official Maven image as the build environment
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper files
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file to download the dependencies
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src src

# Package the application into a JAR file
RUN mvn package -DskipTests

# Use the official OpenJDK image as the runtime environment
FROM openjdk:17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime stage
COPY --from=build /app/target/joshmdmtwo-0.0.1-SNAPSHOT.jar .

# Copy the static files
COPY src/main/resources/static static

# Copy the necessary files for inference
COPY trace_cased_disitlbertqa.pt .
COPY distilbert_vocab.txt .


# Expose the port on which your application runs
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "joshmdmtwo-0.0.1-SNAPSHOT.jar"]
