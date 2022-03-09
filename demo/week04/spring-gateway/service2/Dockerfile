FROM openjdk:11.0.14-jdk-slim AS step1
WORKDIR /demo
COPY . .
RUN ./mvnw clean package

FROM openjdk:11.0.14-jre-slim
WORKDIR /work
COPY --from=step1 /demo/target/service2-0.0.1-SNAPSHOT.jar ./demo.jar
ENTRYPOINT ["java","-jar", "./demo.jar"]