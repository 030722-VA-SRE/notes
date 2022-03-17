## EC2 Autoscaling
Amazon EC2 Auto Scaling helps you maintain application availability and allows you to automatically add or remove EC2 instances according to conditions you define. 

<img src="./images/autoscaling.png" width="500">

### Benefits

1. Improve Fault Tolerance
2. Increase Application Availability
3. Lower Costs

##### Improve Fault Tolerance
Amazon EC2 Auto Scaling can detect when an instance is unhealthy, terminate it, and replace it with a new one.  

##### Increase Application Availability
Amazon EC2 Auto Scaling ensures that your application always has the right amount of compute, and also proactively provisions capacity with Predictive Scaling.

##### Lower Costs
Amazon EC2 Auto Scaling adds instances only when needed, and can scale across purchase options to optimize performance and cost.


### Auto-Scaling Groups
**Groups** are collections of EC2 instances with similar charcteristics.  Using the auto scaling groups you can increase the number of instances to improve your application performance and also you can decrease the number of instances depending on the load to reduce your cost. The auto-scaling group also maintains a fixed number of instances even if an instance becomes unhealthy.

### Launch Configuration
The launch configuration is a template used by auto scaling group to launch EC2 instances. You can specify the Amazon Machine Image (AMI), instances type, key pair, and security groups etc.. while creating the launch configuration.

### Scaling Plans
Scaling plans tells Auto Scaling when and how to scale. Amazon EC2 auto-scaling provides several ways for you to scale the auto scaling group.

* Schedules Scaling
* Dynamic Scaling
* Predictive Scaling

### How to Configure Autoscaling
In order to configure autoscaling, you must create an AMI and launch template.  You can find [full autoscaling documentation here](https://docs.aws.amazon.com/autoscaling/ec2/userguide/GettingStartedTutorial.html#gs-tutorial-next-steps).  The basic steps are as follows:

1. Create a launch template
2. Create an Auto Scaling group
3. Verify your Auto Scaling group
4. Customize Auto Scaling plan.
5. (Optional) Delete your scaling infrastructure
