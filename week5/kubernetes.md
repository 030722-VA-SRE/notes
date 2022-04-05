# Kubernetes

Kubernetes, also known as K8s, is an open-source system for automating deployment, scaling, and management of containerized applications.

Features of Kubernetes:
- Service discovery and load balancing Kubernetes can expose a container using the DNS name or using their own IP address. If traffic to a container is high, Kubernetes is able to load balance and distribute the network traffic so that the deployment is stable.
- Storage orchestration Kubernetes allows you to automatically mount a storage system of your choice, such as local storages, public cloud providers, and more.
Automated rollouts and rollbacks You can describe the desired state for your deployed containers using Kubernetes, and it can change the actual state to the desired state at a controlled rate. For example, you can automate Kubernetes to create new containers for your deployment, remove existing containers and adopt all their resources to the new container.
- Automatic bin packing You provide Kubernetes with a cluster of nodes that it can use to run containerized tasks. You tell Kubernetes how much CPU and memory (RAM) each container needs. Kubernetes can fit containers onto your nodes to make the best use of your resources.
- Self-healing Kubernetes restarts containers that fail, replaces containers, kills containers that don't respond to your user-defined health check, and doesn't advertise them to clients until they are ready to serve.
- Secret and configuration management Kubernetes lets you store and manage sensitive information, such as passwords, OAuth tokens, and SSH keys. You can deploy and update secrets and application configuration without rebuilding your container images, and without exposing secrets in your stack configuration

## Architecture of Kubernetes
<img src="https://d33wubrfki0l68.cloudfront.net/2475489eaf20163ec0f54ddc1d92aa8d4c87c96b/e7c81/images/docs/components-of-kubernetes.svg"/>

### Master nodes
- Also referred to as control plane/ head nodes
        - in charge of managing the cluster
            - shouldn't be running application
- because they are in charge of the cluster
    - multi-master control plane
        - multiple master nodes
            - generally 3
            - for extra resiliency, 5 is ok 
            - usually only 1 master is actually making changes to a cluster
                - "leader"
                - other are proxies
- Have to run on a linux system
- Components of a master node
    - kube-apiserver
        - gateway to the cluster
        - receiving all communication for the control plane
            - from users interacting with the cluster via kubectl
                - sending yml manifest files describing the app to the API server
                    - apiserver handles authorization/authentication/validation of the request
                        - instructs the other control plane features to deploy and manage the application
            - from worker nodes
            - from other components within the control plane
        - Restful API
            - consumes yml, json
    - cluster store
        - only persistent component within the entire control plane
            - where config and the state of a cluster is stored
                - etcd
                    - based on a mySQL database
        - usually have on in a control plane
            - can distribute it and have replicas
    - kube-control manager
        - controller of controllers
            - has controllers responsible for different aspects of the cluster
                - node controller
                - deployment controller
            - each of these watch the cluster for what its responsible for and makes sure that the observed state of the cluster matches the desired one
    - kube-scheduler
        - watches the apiserver for new work/applications
        - assigns work to cluster nodes
### Worker Nodes
<img src="https://startkubernetes.com/static/ed77ff8be09a6293d24b21f4dadc55d7/5a190/k8s-architecture.png"/>

- can be on either linux or windows
- responsible for work coming from the scheduler
    - in k8s, work comes in the form of pods
        - one or more containers packaged together as a single deployable unit
- Components of a worker node
    - kubelet
        - main kubernetes agent that runs of every cluster node
        - registers the node to the cluster
            - adds the cpu, ram, and other resources to the cluster's resource pool
        - watches the API server for work (coming from the scheduler)
            - pull the specs and run the pods
        - NOTE: Kubernetes and Kubelet don't actually know how to run containers
                - don't know how to build images/start containers
                    - container runtime comes into play
    - container runtime
        - used to always be Docker and still is most of the time
        - pluggable: Container Runtime Interface (CRI)
            - abstracts away Containerization tool
                - kind of like Hibernated abstracting away SQL dialect
        - in charge of stopping and running containers
    - kube-proxy
        - networking component of the node
        - to make sure that every pod gets its own unique ip address
            - if multiple containers are in the same pod, they all share the same ip address
            - reach out different containers via ports
        - lightweight load balancing across all the pods
            - behind a service
                - service is a way to hide multiple pods behind a stable network address
                - like a load balancer
                - balances requests across all of the pods that it manages

### Declarative model and desired state
- declarative model
    - a manifest file that describes an end state is given to the API server
        - desired state of application/cluster is described
            - NOTE: not a list of commands to get there(imperative)
        - kubernetes takes care of all of the work involved in making happen and maintaining it
    - if something goes down/wrong the observed state drifts away from the desired state
        - kubernetes tries to reconcile the desired and the observed state

### Pods

<img src="https://matthewpalmer.net/kubernetes-app-developer/articles/pods-on-node.gif"/>

- In Kubernetes, the atomic unit of deployment is the pod
    - containers ALWAYS run in a pod
        - can have multiple containers within the same pod
- pod is a wrapper around containers
    - provides a shared execution environment
            - collection of "things" that the app might need to run
                - ip address/ports
                - file system
                - shared memory
            - containers within the same pod share all of these
                - might be helpful in certain cases
- in general, better practice to have a single container by pod unless they absolutely need to share resources
    - loose coupling (good)
- pods are atomic and motal
    - is ready only if all the containers are running successfully
    - pods are discarded all the time
- pods are great for metadata
    - labels, annotations...
    - resource constraints

### Services
<img src="https://d33wubrfki0l68.cloudfront.net/7a13fe12acc9ea0728460c482c67e0eb31ff5303/2c8a7/docs/tutorials/kubernetes-basics/public/images/module_04_labels.svg">

- highlevel abstraction point for multiple pods
    - sit in front of pods
    - have stable ip and dns name
        - meaning that they ALWAYS have this address
    - once requests are received, load balances to the pods it manages
- defined in the manifest
    - keeps a list of the pods ips that it manages
    - manages pods via labels using a SELECTOR
        - note: if an unrelated pod has the same label, redirects traffic there as well
            - pls no
    - only sends traffic to healthy pods
        - if health check doesn't pass, traffic isn't routed there

### Deployments
    - handled by deployment controller
        - watches the API server for new deployments
        - once one comes in, implements them and sits in a loop
            - constantly compare the observed state with the desired state
                - chances are, if there is discrepency, handles it without human intervention
            - behind the scenes works with the replica set controller
                - responsible for managing the number of replicas
                - deployment sits on top of the replica set and manages them
    container => pod => rs => deployment
        - container: contains the application
        - pod: manages labels, annotations
        - replicaset: replica count, self healing, versioning
        - deployment: manages update rollbacks

<img src="https://matthewpalmer.net/kubernetes-app-developer/articles/deployment-yaml-diagram.gif">

    - Deployment file
            - contains the properties a of deployment object
### Kubernetes API
    - almost everything in Kubernetes is a object within the Kubernetes API
        - think of all of the objects as tools with different purposes/ features
    - api server
        - Restful Api
            - supports HTTP methods
        - kubectl