# Docker Daemon
Long running process that is responsible for managing Docker objects. 

`dockerd` command allows you to run and configure the docker daemon (working with flags and config files)

Listens for calls from the exposed REST API to manage *containers*, *images*, *volumes* etc. 

Can communicate w/other Docker daemons -- in the case of Docker Services -- can be used to set up a *swarm*. (A *swarm* allows you to set up multiple docker daemons the behave like a cluster.)

#### Daemon Configuration
- Flags can be used when running the dockerd command
    - i.e. `dockerd --debug`
    - above specifies to run the daemon in debug mode
- JSON file 
    - /etc/docker/daemon.json on Linux systems 
    - C:\ProgramData\docker\config\daemon.json on Windows
    - MacOS go to the whale in the taskbar > Preferences > Daemon > Advanced

    The file might look as simple as: 
    ```
    { debug: true }
    ```

- Each configuration options should be configured using either a flag in conjunction with the dockerd command or in the config file. 

- Persists all Docker data in a particular directory
    - By Default 
        - /var/lib/docker on Linux
        - C:\ProgramData\docker on Windows

Note: In a Windows System it may not be clear to the OS where to find the dockerd.exe to run the Docker Deamon and it's command. The Docker Desktop app will help your OS to understand `docker` without any extra effort. To find the dockerd.exe (to run the `dockerd` command specifically) look under the resources folder in with in the Docker folder in Program Files. 

### References 
- [dockerd command reference docs](https://docs.docker.com/engine/reference/commandline/dockerd/)