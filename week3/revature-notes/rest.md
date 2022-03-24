# Web Services
---
A web service is a business-to-business (B2B) technology which makes resources available over the Internet using a standardized messaging protocol or architecture (such as REST or SOAP). 

Web services are self-contained, modular, distributed, dynamic applications that can be described, published, located, or invoked over the network to create products, processes, and supply chains. These applications can be local, distributed, or web-based.

---
## REST
REST, or REpresentational State Transfer, is an architectural style for providing standards between computer systems on the web, making it easier for systems to communicate with each other. REST-compliant systems, often called RESTful systems, are characterized by how they are stateless and separate the concerns of client and server.

REST defines 6 architectural constraints which make a web service truly RESTful:

- Uniform interface
- Client–server
- Stateless
- Cacheable
- Layered system
- Code on demand (optional)

Resource: 
* https://www.codecademy.com/articles/what-is-rest
* https://restfulapi.net/resource-naming/

---
### Characteristics of RESTful APIs
All RESTful APIs have few characteristics in common that distinguish them from other types of web services. Such characteristics include:

- The explicit use of HTTP to facilitate client-server communication
- The use of HTTP status codes to indicate the success or failure of request processing
- The uniform naming convention used to define the application's endpoints
- The server that processes requests does so in a stateless manner
- The use of any one of a variety of data interchange formats (JSON, XML, etc.)

# REST Architecture

Representational State Transfer is a software architectural style that defines a set of constraints to be used for creating web services.

## Architectural Constraints

In order to be considered a "true" RESTful API, our API must correctly implement the follow architectural constraints:

1. Uniform Interface

This constraint requires that we be consistent in the naming of our API's endpoints. Our resources should only one logical URI and they should provide recipients a way to obtain other related resources that it may encapsulate. This constraint also includes the consistent use of some language-agnostic format as response payload (JSON, XML, BSON, etc.). Additionally, this constraint requires that we leverage HTTP as the protocol for interacting with our API. The HTTP verbs (GET, POST, PUT, etc.) combined with the consistent and intuitive naming of resource endpoints helps our API to achieve a uniform interface.


2. Client-server

This constraint emphasizes that our server application (the API) and the client application (the consumer of the API) must be able to evolve separately from one another. The client application only needs to know the URIs to resources exposed by the API.


3. Stateless

This constraint requires that the interaction between our client and our server is a stateless one. The server will not store anything about the client's request, and every request is a new request from the perspective of the API. The client is responsible for maintaining the state of the application.


4. Cacheable

Resources which will not change often should always be cached (either by the client or the server). This is done in order to decrease latency for the retrieval of frequently accessed, often immutable (or rarely changed) resources.


5. Layered System

As the name implies, this constraints requires that our system architecture is layered. This means that the different domains of our application are physically and logically separate from one another.

Resource: 

https://restfulapi.net/rest-architectural-constraints

## Richardson Maturity Model

Resource: https://restfulapi.net/richardson-maturity-model/