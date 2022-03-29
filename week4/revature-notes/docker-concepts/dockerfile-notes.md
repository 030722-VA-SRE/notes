# Dockerfile 

Defines everything needed for an image. It outlines the starting point, dependencies and commands that make up all the processes needed for an image and in turn a container. 

Dockerfiles go step by step. 

Dockerfiles always begin with the instruction FROM *image name*. 
(Technically a dockerfile might have parser directives, ARG commands, or comments first. )

- The command FROM indicates the image that you start from, either: 
    - a *parent image* some pre-existing image the container is based on 
    - a *base image* which is when the container is built from the command `FROM scratch` 

Note, while technically a *base image* and *parent image* are different you might hear them used interchangeably.   

After that essentailly each instruction forms anothe layer of the docker image. (These layers are cached to speed up the build.)

Dockerfile commands include things such as installing software in the container, copying and adding files to the container from local or remote systems, defining environment variables needed for the container, and executing commands such as running the intended app in the container. [More on dockerfile commands.](../docker-workflow/dockerfile-keywords.md)

### References
- [Dockerfile Best Practices](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)
- [Dockerfile Reference](https://docs.docker.com/engine/reference/builder/)
- [Docker glossary](https://docs.docker.com/glossary/)
