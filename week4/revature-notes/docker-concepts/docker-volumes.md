# Docker Volumes

## References 
- https://docs.docker.com/storage/volumes/
- https://docs.docker.com/storage/

## Overview

**Volumes** are a way to persist data for a container. 

Typically the goal is to have containers exist as mostly stateless. However, sometimes you need information for a container to remain even if the container stops. 

Volumes are managed using the CLI and the Docker API. 

(Note: While there are options for how to persist data, volumes are preferred.) 

They facillitate
- sharing data between many different containers
- decoupling of host and container 
- storing data remotely
- moving data between hosts or backing up data between hosts 

Volumes are also helpful because they allow Docker to keep the containers slim by saving data in the volume rather than the writable layer that dissappears with the container. 

