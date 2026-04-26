FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

###########3

# rohitkumar4praja/axisbank-app

# docker pull rohitkumar4praja/axisbank-app:15
# docker run -d -p 80:8080 rohitkumar4praja/axisbank-app-n