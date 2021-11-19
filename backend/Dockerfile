FROM java:8

WORKDIR /app

COPY . .

EXPOSE 443

RUN ./mvnw install

CMD ["java","-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
