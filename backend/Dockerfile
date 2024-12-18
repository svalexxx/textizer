# Use a suitable JDK image
FROM amazoncorretto:21-alpine3.19

# Set the working directory
WORKDIR /app

# Copy the build artifact
COPY build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8888

COPY wait-for-mongo.sh /wait-for-mongo.sh
RUN chmod +x /wait-for-mongo.sh
ENTRYPOINT ["/wait-for-mongo.sh", "&&", "java", "-jar", "app.jar"]

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]