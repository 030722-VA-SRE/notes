# Package Managers
In Unix, if you wish to install software, you generally use a package manager. There are many package managers available and we will talk about a few.

## RPM
The Red Hat Package Manager or RPM is a package management system that manages `.rpm` files. It was created for Red Hat Linux but is used in many distributions.
## APT
Advanced Package Tool or APT is a package manager used on many Linux distributions. It allows you to retrieve, configure, and install/uninstall software packages.
## yum
The Yellowdog Updater, Modified or yum is a package-management utility for computers running RPM. When you create an EC2 using an Amazon Linux AMI, yum is installed.

As you are most likely to run into yum when you are working with Amazon linux, here are a few examples:
```
# update installed pacakges
sudo yum update
# Install git
sudo yum install git
# Uninstall git
sudo yum remove git
```
## dpkg
Debean Package is a low-level tool that manages `.deb` files. It was created for Debian and its derivatives.