# Docker Swarm
## References
- [Docker Swarm Key Concepts](https://docs.docker.com/engine/swarm/key-concepts/)
- [What is Orchestration? from Red Hat](https://www.redhat.com/en/topics/automation/what-is-orchestration#:~:text=Orchestration%20is%20the%20automated%20configuration,isn't%20a%20scalable%20strategy.)
- [Swarm deploy](https://docs.docker.com/get-started/swarm-deploy/)
- [Swarm and compose](https://docs.docker.com/compose/swarm/)
## Helpful tutorial
- [Helpful tutorial](https://docs.docker.com/engine/swarm/stack-deploy/)

## Background
As applications have to support more and more users and as we work to reduce the downtime of an application, having a single instance of an application on a single server becomes unsustainable; instead, developers have to move their application to running on a distributed system with multiple servers and support for replication of services.

This is where the concepts of *cluster management* and *orchestration* come into play. 

***Cluster management*** refers to the need to manage having more than one server or engine supporting a particular application. 

***Orchestration*** refers to managing, configuring, and coordinating applications and services automatically across computer systems. Essentially automating an entire complex workflow across disparate systems. 

## Overview 

**Docker Swarms** allow you to support cluster management and orchestration innately using Docker. 

A ***swarm*** is a collection of docker hosts running in something called ***swarm mode***. These hosts are either managers and/or workers; they coordinate and/or run services respectively. (Note: A docker host may be both a manager and worker.)

***Swarm mode's*** supporting technology is called ***swarmkit*** and it's built into the Docker Engine.  

The core idea is that you have some set of services each with a desired state and Docker works to keep the services in their desired states through the cluster of workers and managers.

A particular instance of a Docker engine within a ***swarm*** is considered a ***node*** or ***Docker node***. Multiple ***nodes*** may be on a single physical host, but typically deployments are distributed across more than one physical and/or cloud machine. 

A ***service*** is the definition of the ***tasks*** to execute. A ***service*** outlines which image to use and the commands to execute in the running containers. 

A ***task*** meanwhile is the running container. 

When you go to deploy an application to a swarm, you introduce your service definitions to a manager node that posts the ***tasks*** to the worker nodes. The manager works to ensure that your tasks maintain the desired state- i.e. are properly replicated and functioning on the appropriate workers. For instance if a worker becomes unavailable the manager schedules the tasks from that worker to other nodes. 

## Process of deploying a swarm

While multi-node swarms can't be deployed using Docker Desktop, you can run some simple swarm command to test out an application before deploying it to a distributed swarm. 

First, you have to initialize swarm mode. This can be done by running the following command. 

```console
docker swarm init
```
This turns your current host into a manager node. 

Then you'll typically use a *stack file* to describe your ***services***. This essentially defines an ***orchestration***, automatically coordinating your disparate stack of services. 

It's worth noting that ***services*** in the context of docker swarms includes scheduling and networking facilities, generating containers and supplying tools for routing requests to them. (Note that this is different from Kubernetes services.)

A ***stack file*** is a yml file that is essentially a special ***docker-compose*** file. The language and features of ***docker-compose*** yaml files and ***stack files*** is mostly the same from version three of ***docker-compose***. However, there are some key differences. In a traditional ***docker compose*** file you can use the build command to build an image to be used as the base of your container. You can't do this when you are using a ***docker-compose*** file as a ***stack file***, you must work from pre-existing images. (See the references section for more details on the differences.)

So let's take the following ***stack file*** and save it as *net-app-stack* in a new directory called *net-app-demo*. You'll notice that we specify the image as the Microsoft .Net app and we publish the appropriate port. 
```YAML
version: '3.7'

services:
  app:
    image: mcr.microsoft.com/dotnet/core/samples:aspnetapp
    ports:
      - "8000:80"
```
Then from the *net-app-demo* directory with (swarm mode initialized) we run the following command to deploy our app. 
```console
docker stack deploy -c net-app-stack.yaml demo
```
Then we can make sure everything worked by running the following command to list our services.  
```console
docker service ls
```
We should see something like this:
```console
ID                  NAME                MODE                REPLICAS            IMAGE                                             PORTS
8gzt58v0a19e        demo_app         replicated          1/1                 mcr.microsoft.com/dotnet/core/samples:aspnetapp   *:8000->80/tcp
```
We are really looking for 1/1 replicas. This tells us that our service is up and running. We can now open a browser to go to `localhost:8000` and see the Asp .net application up and running. 

Finally we can bring down the service by running:
```console
docker stack rm demo_app
```
