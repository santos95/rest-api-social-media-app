# stage 1
FROM maven:3.8.5-openjdk-17 AS build

# SET THE WORKING DIR
WORKDIR /app

# COPY THE MAVEN FILES
COPY pom.xml .
COPY src ./src

# package the app
RUN mvn clean package -DskipTests

# stage 2 - create the runtime
FROM tomcat:9-jdk17

# Remove the default web apps from tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file from the the build stage
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/social-media-app.war

# Expose the tomcat port
EXPOSE 8080

# Command to run tomcat (Default)
CMD ["catalina.sh", "run"]
