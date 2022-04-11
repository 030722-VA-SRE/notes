# Project 2 requirements

## Description (Due: 04/25/2022)

Project 2 will be a group project focusing on the deployment and monitoring of an application. Each group will be comprised of 3-4 team members. Each group will select one of the team members p1 to build off of.

The goal is to introduce working in a group and researching SRE principles.

## Methodology

Each group should follow an Agile approach and implement the SCRUM methodology.
- Each team will designate a team leader and decide on a team name
- Each team will choose a project from one of their member's Project 1's.
- Each team will create a folder in the common repository and store their stand-up notes there
- Each team should track the tasks being worked on (recommendation: Github Project)


## Requirements

Teams are allowed to create a new namespace on our common AWS cluster for project 2, the application should be deployed in the new namespace.

1. Each team must define SLO for their application. (resources: https://sre.google/sre-book/service-level-objectives/, https://sre.google/workbook/implementing-slos/)
    - Must include error rates as well as latencies
    - Must include their custom metrics
2. Each team must configure Loki and Prometheus to retrieve logs/metrics from the deployed application
    - teams must create at least 1 custom metrics through the micrometer API
        - Should be incorporated into the SLOs, should indicate something about the quality of the application
3. Each team must define alerting rules based on their SLO
4. Each team must create at least 1 Grafana dashboard with multiple panels to track all of the metrics associated with their SLO
    - Examples could be tracking relevant logs of the application or cpu/memory usage from Prometheus
    - The idea is to have visualizations that might indicate that a problem might occur soon, even if an alert has not fired yet
5. Each team must have a full DevOps pipeline built using Jenkins
    - This pipeline must be configured through a Jenkinsfile and triggered in response to a webhook
    - The pipeline must also be configured with a SonarCloud quality gate
        - This additionally means that the project must have unit tests
        - The only requirement will be to have minimum 70% test coverage for the service package
    - The project will be deployed with a canary deployment model