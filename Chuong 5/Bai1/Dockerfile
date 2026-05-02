FROM openjdk:21-slim

LABEL maintainer="student@example.com"
LABEL description="Salary Management Application - Design Patterns Chapter 5"
LABEL version="1.0"

WORKDIR /app

COPY src/main/java/com/salarymanagement/*.java /app/com/salarymanagement/

RUN javac -d . /app/com/salarymanagement/*.java

CMD ["java", "com.salarymanagement.MainApp"]