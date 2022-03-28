## *Running* `nsnake` *Container in an EC2* 

1. SSH into an EC2 instance.  You will only need 1 security rule which is supplied to you by default (SSH port 20).

2. Once you've ssh's in, run the following commands:

``` sh
# Install Docker
sudo yum install docker
# Create a group of users within your EC@ instance with Docker permissions
sudo groupadd docker
sudo usermod -a -G docker ec2-user
sudo service docker start
# Make a folder to contain your Dockerfile -> cd into it
mkdir snakedocker
cd snakedocker
# Use the nano command to open up a text editor
nano Dockerfile
# The following commands go inside your Dockerfile
# FROM specifies the base image, running an ubuntu OS
FROM ubuntu:18.04
# RUN specifies the duty of the container.  It should install this software
RUN apt-get update && apt-get install -y libncurses5-dev && apt-get install -y nsnake
# CMD specifies the instruction that is to be executed when a Docker container starts
# In this case, we are running the executable located at /usr/games/nsnake within the nginx container
CMD ["/usr/games/nsnake"]
```

3. Exit the `nano` text editor with the keyboard commands `ctrl` + `X`, then press `Y` to save.

4. Build the image from the `Dockerfile` with the following command: 
    >`sudo docker build -t snake:auto .`
    
5. Finally, run the image with the following command and you'll load up the game thanks to the `CMD` command.
    >`sudo docker run -it snake:auto` <br>
        the `-it` flag allows you to interact with the executable file, which, in this case, is the game itself.
<br>

<hr>

<br>