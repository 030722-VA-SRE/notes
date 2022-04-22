# This builder stage is used to generate our application's jar file
FROM maven:3.6.3-jdk-8 as builder
# WORKDIR allows us to specify a directory in the container's filesystem to have the "work" be conducted
# Otherwise everything is performed at the root level of the container's filesystem 
WORKDIR /app

COPY pom.xml pom.xml
COPY src/ src/

RUN mvn clean package -Dmaven.test.skip=true

# This stage will download the Pinpoint APM agent from github: https://github.com/pinpoint-apm/pinpoint/releases/tag/v2.3.3
# Also extracts the archive to provide the .jar file and needed dependencies
FROM ubuntu:20.10 as extractor

WORKDIR /pinpoint-agent

# The ADD directive downloads the archive for the pinpoint agent directly and adds it to our container
ADD https://github.com/pinpoint-apm/pinpoint/releases/download/v2.3.3/pinpoint-agent-2.3.3.tar.gz pinpoint-agent-2.3.3.tar.gz

# Extract the archive
RUN tar -xzf pinpoint-agent-2.3.3.tar.gz
# including the WORKDIR, this will result in a nested folder structure: /pinpoint-agent/pinpoint-agent-2.3.3/
FROM java:8 as runner

WORKDIR /app

# Copy the pinpoint agent to this stage
COPY --from=extractor /pinpoint-agent/pinpoint-agent-2.3.3/ /pinpoint-agent
# Add custom config file, copying and pasting
# The default values of the config file can be found in the pinpoint-agent-2.3.3.tar.gz
# This allows us to override those values and provide our own config
COPY pinpoint.config /pinpoint-agent/pinpoint.config

# Copy Artifact from builder stage
COPY --from=builder /app/target/demo.jar demo.jar

# Runs our application with the Pinpoint Java Agent
ENTRYPOINT ["java", "-javaagent:/pinpoint-agent/pinpoint-bootstrap-2.3.3.jar", "-Dpinpoint.config=/pinpoint-agent/pinpoint.config", "-Dpinpoint.agentId=demo-app", "-Dpinpoint.applicationName=demo-application", "-jar", "demo.jar"]
