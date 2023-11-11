## Spring Boot and RabbitMQ

### Requirements

- Java 17
- Docker
> **Note:** Add JAVA_HOME path environment variable with the value of Java 17 folder

### Run

To run application, use the following commands:

1.
   ```bash
   docker-compose up -d
   ```
2. 
   ```bash
   ./gradlew :publisher-service:bootRun
   ```
3. 
    ```bash
    ./gradlew :subscriber-service:bootRun
    ```
### Usage

[Swagger Link](http://localhost:8888/swagger-ui/index.html)