# Dockerfile Keywords
## References
- [Dockerfile Reference](https://docs.docker.com/engine/reference/builder/)

## Dockerfile Commands

`FROM  image name`
- specifies the parent image from which the new image should be based. 
- forms the first layer of this new image. 
- might say `FROM imagename AS temp-name` if we want to have use multi-stage builds
    - This will essentially create our final image by building on the previous images that we set up in the same dockerfile. 
- i.e. If we wanted to start with a ubuntu OS base (where we would take advantage of multi-stage builds) we might have: 
```dockerfile
FROM ubuntu AS ubuntu-with-java-example
```


`RUN `
- There are two forms of the command. 
    - `RUN <command>` 
        - Runs the command in a shell by default (the particular shell depends on whether the parent image defines a linux or windows container)
    - `RUN ["executable", "param1", "param2" ]`
        - Runs the command in the executable form without using a shell       
- `RUN` will be used to set up your image- the state of the image after each run command is committed- forming a new layer 
- i.e. If we wanted to install some programs as part of the image, you might have: 
```dockerfile
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk 
```

`ADD <src> <destination>`
- adds files from build context or url to the image
- copy is preferred over add
- can perform auto-extraction into the image from a local tar file (this differs from copy and is one of the few instances add is preferred) 
-i.e. The following command would copy HelloWorld.java into a file of the same name in the container's working directory. 
```dockerfile
ADD HelloWorld.java HelloWorld.java
```

`COPY <src> <destination>`
- adds files from the build context to the image 
-i.e. The following command would copy HelloWorld.java into a file of the same name in the container's working directory. 
```dockerfile
COPY HelloWorld.java HelloWorld.java
```

`EXPOSE `
- outlines the ports that the are being listened on by processes in the container-- i.e. it suggests what ports to bind to host ports when running the image 
-The following example would inform the host to bind to port 80 in the container
```dockerfile
EXPOSE 80
```

`VOLUME ["/nameofdir"]`
- creates a mount point in the image and thus container with a particular name- it indicates that the files in this directory will be shared with the resources outside of the container  
- it indicates what directory to connect a volume to when running the docker container
-i.e. The following suggests that we should connect a volume to the data directory in the container when we spin it up. 
```dockerfile
VOLUME ["/data"]
```

`WORKDIR <nameofdirectory>`
- sets the working directory in the image and eventual container of commands that follow. 
i.e. 
```dockerfile
WORKDIR /example
RUN mkdir a
```
- Would make a directory *a* inside of the *example* folder. *example/a* 

`CMD `
- used to run the app, processes etc. needed inside of your container 
- only the last CMD will run when the built image is launched as a container
- `CMD ["executable","param1","param2"]` (exec form, this is the preferred form)
    - invokes the command with out a shell 
- `CMD ["param1","param2"]` (as default parameters to ENTRYPOINT)
    - the `ENTRYPOINT` instruction must be specified if you use the default format, it's another way you can specify the first commands to be run upon spinning up a 
- `CMD command param1 param2 (shell form)`
    - invokes the command inside of a shell in /bin/sh -c
- i.e. The last line of a docker file might be a command running a java program: 
```dockerfile
CMD ["java", "HiWorld"]
```

## Dockerfile Examples
**NOTE**: The dockerfile will typically be saved as Dockerfile without any extension. (Save-as all files.)

Let's look at this dockerfile that runs a simple Java HelloWorld example: 
```dockerfile
# Define the parent image
FROM ubuntu

# Install needed programs
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk 

# Within the image and thus container, set the working directory to the new directory example
WORKDIR /example

# Create Hello World Java program and save it in the appropriate file 
RUN echo 'public class HiWorld{ public static void main(String[] args){System.out.println("Hi world");}}'> HiWorld.java

# Compile the Java program, creating the file that the JVM can actually run 
RUN javac HiWorld.java

# Run the HelloWorld program in the container 
CMD ["java", "HiWorld"]

```

### Description of Example:
The first line of the Dockerfile indicates the parent image will be the official ubuntu image. It's common to see an image begin with a base OS and then install any needed programs on top of it. (Though typically, if java is the only needed program, one would might choose to use openjdk or some image that starts with java.) 

The next lines that begin `RUN ...` install the needed jdk. 

`WORKDIR` sets directory for any subsequent commands to be executed from the */example* folder. 

Thus, the lines `RUN echo... ` and `RUN javac ...` create the program that we will actually run. With more complex programs its likely you would use something like `COPY` to takes the whatever files are needed from the local system and copies them into the destination. 

Finally, the `CMD` line will execute the command `java HiWorld` from the *example* directory when the container starts up. It's important to remember that the lifecycle of the container will be tied to this initial process and the container will only exist long enough for the HiWorld program to run. 


We can also expand on this to create this same example taking advantage of multi-stage builds.
```dockerfile
# Define the parent image and give a name to the first stage of building our image
FROM ubuntu AS ubuntu-with-java-example
# Install needed programs
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk


# This time we are building from the image that we just defined
FROM ubuntu-with-java-example 
# Within the image and thus container, set the working directory to the new directory example
WORKDIR /example
RUN echo 'public class HiWorld{ public static void main(String[] args){System.out.println("Hi world");}}'> HiWorld.java
RUN javac HiWorld.java
# Run the HelloWorld program in the container 
CMD ["java", "HiWorld"]
```


