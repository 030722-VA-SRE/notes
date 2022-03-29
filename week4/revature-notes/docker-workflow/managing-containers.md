# Managing containers
## References 
- [Docker CLI reference](https://docs.docker.com/engine/reference/commandline/cli/)
    - [docker container ls](https://docs.docker.com/engine/reference/commandline/container_ls/)
    - [docker ps](https://docs.docker.com/engine/reference/commandline/ps/)
    - [docker container exec](https://docs.docker.com/engine/reference/commandline/container_exec/)
    - [docker container logs](https://docs.docker.com/engine/reference/commandline/container_logs/)
    - [docker container port](https://docs.docker.com/engine/reference/commandline/container_port/)
    - [docker container kill](https://docs.docker.com/engine/reference/commandline/container_kill/)
    - [docker container stop](https://docs.docker.com/engine/reference/commandline/container_stop/)
    - [docker pause](https://docs.docker.com/engine/reference/commandline/pause/)
    - [docker unpause](https://docs.docker.com/engine/reference/commandline/unpause/)
    - [docker container rm](https://docs.docker.com/engine/reference/commandline/container_rm/)
    - [docker container prune](https://docs.docker.com/engine/reference/commandline/container_prune/)
    - [docker volume rm](https://docs.docker.com/engine/reference/commandline/volume_rm/)
- [Introducing docker 1.13](https://www.docker.com/blog/whats-new-in-docker-1-13/)
- [SIGTERM and SIGKILL](https://linuxhandbook.com/sigterm-vs-sigkill/) 
- [cgroup freezer](https://www.kernel.org/doc/Documentation/cgroup-v1/freezer-subsystem.txt)
- [Container names and ids](https://docs.docker.com/engine/reference/run/#name---name)

## Contents
- [List Containers](#List-containers)
- [Run Commands](#Run-a-command-in-a-running-container) 
- [View Container Logs](#View-a-containers-logs) 
- [List Port Mappings](#List-port-mappings-between-containers-ports-and-hosts)
- [Stop Containers](#Stop-a-container) 
- [Pause Containers](#Pause-and-unpause-a-container) 
- [Start Containers](#Start-a-container) 
- [Remove Containers](#Remove-a-container) 
- [Remove Volumes](#Remove-a-volume) 

## Introduction
When a docker container is first created, it's assigned a name and a container id. You can use these to manage the state of the container and the processes running inside of it. The name is a unique string- either generated or assigned by you using a flag. Meanwhile an id is a UUID identifier that will always come from the docker daemon. 

As you know, in any given container there is one primary process to which the lifecycle of the container is tied and there may be any number of other adjacent processes that run in the container as well. 

These basic container management commands allow us to check in on and manipulate both the containers and the processes running within them. 

**Note**: In most cases the container id can be replaced with the first three characters of the container's id or the container's name.

## Container Management Commands

### List containers: 
- running containers: 
    - `docker container ls` 
    - `docker ps`
- all containers 
    - `docker container ls -a` (or --all instead of -a)
    - `docker ps -a`

- These commands will specify the container id's, when they were created, their state, from what image repository they came, a name, etc. 
- This really comes in handy to identify the particular container id you need for subsequent commands.
- There is no difference between the output of ps and ls. Though docker ps came first and docker has expressed interest in at some point moving toward grouped commands. (The commands where you begin docker logical object command- i.e. docker container ...)
- ps stands for process status while ls stands for list

### Run a command in a running container: 
- `docker container exec flags container-id command`
- The container must be *running*.
- You can identify the container with it's full id or the first three characters if they are unique. 
- flags might include things like `it` if the command you wanted to run would run a commandline in a particular container
- flags might also include `-a STDOUT` where STDOUT could be STDOUT, STDIN, STDERR depending on which stream you wished to attach to the shell from which you run the exec command 
```console 
docker container exec -it 563 bash
```
- This would run an interactive bash in container 563. 


### View a container's logs:
- View a container's output 
- `docker container logs container-id`
    - The logs of a container include anything written by the container's processes to STDOUT or STDERR
    - the container does not have to be running for you to view the logs
```console
docker container logs 563
```

### List port mappings between container's ports and hosts: 
- `docker container port containerid`
    - This is useful when you need to determine what ports a container is listening on 
```console
docker container port 563
```
### Stop a container: 
- `docker container kill containerid`
    - the main process, to which the container is tied, receives a `SIGKILL`
        - a `SIGKILL` forces a process to terminate along with any of its threads
        - it cannot be ignored or handled gracefully

- `docker container stop containerid`
    - the main process, to which the container is tied, receives a `SIGTERM`
        - the polite way to ask a process to terminate- allowing a process to handle shutting down as it sees fit- including ignoring the signal  
    - if this fails after some grace period will send a `SIGKILL` to the same main process 
- [also see remove a container](#remove-a-container) 

### Pause and unpause a container:
- `docker container pause containerid`
- `docker pause containerid`
    - to pause a container pauses all the processes running within the container 
    - on a Linux machine, under the hood, this command uses the cgroup freezer --- this means the processes are unaware they are being paused
    - `docker container pause ...` is just the newer version of the the `docker pause ...` command
- `docker container unpause containerid`
- `docker unpause containterid`
    - to unpause a container---unpausing all running processes within the container
    - on Linux, also uses cgroup freezer to begin running the processes again without them knowing they had ever stopped

### Start a container 
- `docker container start containerid`
    - start a created container that is not running
- `docker container restart containerid` (if the container may or may not already be running)
- starts main process to which container is tied

### Remove a container: 
- `docker container rm flags containerid`
    - note optional flag -f to force the removal of a running container
    - note optional flag -v to remove anonymous volumes with a container-- this will not remove named volumes that you have created 
- `docker container prune`
    - Remove exited containers

### Remove a volume:
- `docker volume rm volumename`
    - **Note:** You cannot remove volumes that are being used by a container
    - to remove a volume removes the container's access to that named persistent and shared memory 
    - [See the notes on volumes.](../docker-concepts/docker-volumes.md)

