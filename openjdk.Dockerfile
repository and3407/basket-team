#FROM openjdk:11
#ADD /target/basketteam-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]


FROM maven:3.8.5-openjdk-11 as MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn clean package -DskipTests --no-cache

FROM openjdk:11

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/basketteam-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "basketteam-0.0.1-SNAPSHOT.jar"]

#FROM maven:3.8.5-openjdk-11
#WORKDIR /app
#COPY . .
#RUN mvn clean package -DskipTests
#CMD mvn spring-boot:run