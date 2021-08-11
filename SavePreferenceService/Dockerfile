FROM openjdk:11.0.12-jdk-oracle

COPY target/SavePreferenceService.jar SavePreferenceService.jar

# Make port 8084 available to the world outside this container
EXPOSE 8084

# Run the jar file 
ENTRYPOINT ["java","-jar","SavePreferenceService.jar"]
