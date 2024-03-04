FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

FROM openjdk:17
ADD /target/adm-azs-shipping.jar adm-azs-shipping
ENTRYPOINT [ "java", "-jar", "adm-azs-shipping" ]
