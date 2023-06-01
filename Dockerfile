FROM openjdk:17-jdk-alpine3.14

COPY "./target/kv-web.jar" "/application/kv-web.jar"

CMD ["java", "-jar", "/application/kv-web.jar"]
