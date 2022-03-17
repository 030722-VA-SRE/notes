## Security Groups
A **security group** acts as a virtual firewall for your EC2 instances to control incoming and outgoing traffic based on their IP address. 

* Security group rules enable you to filter traffic based on protocols and port numbers.
* Security groups are stateful — if you send a request from your instance, the response traffic for that request is allowed to flow in regardless of inbound security group rules. Responses to allowed inbound traffic are allowed to flow out, regardless of outbound rules.
* You can add rules to each security group that allow traffic to or from its associated instances. You can modify the rules for a security group at any time. 

*When demoing configuring an EC2 instance, you should set the security groups before you launch your instance.  You can set your first Security Group to `Anywhere`, so that it is easiest to connect from any IP address.*

### Changing an instance's security groups
After you launch an instance into a VPC, you can change the security groups that are associated with the instance. You can change the security groups for an instance when the instance is in the running or stopped state.

#### To change the security groups for an instance using the console

1. Open the Amazon EC2 console at https://console.aws.amazon.com/ec2/.
2. In the navigation pane, choose `Instances`.
3. Open the context (right-click) menu for the instance and choose `Networking` > `Change Security Groups`.
4. In the `Change Security Groups` dialog box, select one or more security groups from the list and choose `Assign Security Groups`.
