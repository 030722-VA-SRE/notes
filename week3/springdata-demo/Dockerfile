#FROM openjdk:8
#COPY target/henry-demo.jar aaron.jar
#ENTRYPOINT ["java", "-jar", "/aaron.jar"]

#Base image with jdk 8 and maven
FROM maven:3.6.3-openjdk-8 as builder

#Copy source code and the pom.xml from host to container
COPY src/ src/
COPY pom.xml pom.xml

#Build our application
RUN mvn package -Pprod -Dmaven.test.skip
#The jar file has been generated

#As a separate stage, save the resulting artifact and discard maven from previous stages
FROM java:8 as runner
#Base image which only needs a JRE

#Copying the jar file from our previous stage into the runner stage
COPY --from=builder target/henry-demo.jar springdata.jar

#Run our application
ENTRYPOINT ["java", "-jar", "/springdata.jar"]