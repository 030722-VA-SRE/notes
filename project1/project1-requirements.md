# Item Shop Refactor

## Description (Due: 04/08/2022)

   Project 1 will be divided into two phases, the first one will be a p0 refactor using Spring and the second will be shared later during training.

   Both phases will be due on Friday April 8th. 

## Requirements - Phase 1
1. Refactor your application and leverage Spring Technologies
    - Spring Boot
    - Spring WebMVC
    - Spring Data JPA
2. Incorporate User functionality, for example:
    * As a user, I can login.
    * As a user, I can register for a customer account.
    * As an employee, I can add an item to the shop.
    * As a customer, I can view the available items.
    * As a customer, I can purchase an item.
    * As an employee, I can remove an item from the shop.
    * As a customer, I can view the items that I own.
3. Logging and Testing

## Phase 1 bonus

Be creative and incorporate other topics into your project, they do not have to have been covered by our curriculum. Here are some suggestions:
* Mocking (Mockito)
* Password hashing
* JWT
* MockMvc (Testing the web layer)

## Requirements - Phase 2
1. Containerize your application and a database instance using Docker and Docker Compose.
2. Log your application thoroughly using MDC
    - create a custom pattern
    - try leveraging different logging levels
3. Log aggregation using Promtail, Loki, Grafana

## Phase 2 bonus
    - EC2 deployment
    - Prometheus
    - determining SLIs