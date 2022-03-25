## AWS S3 Bucket Configuration
* To upload your data (photos, videos, documents etc.) to Amazon S3, you must first create an S3 bucket in one of the AWS Regions. You can then upload your data objects to the bucket.
* Every object you store in Amazon S3 resides in a bucket. You can use buckets to group related objects in the same way that you use a directory to group files in a file system.
* Amazon S3 creates buckets in the AWS Region that you specify. You can choose any AWS Region that is geographically close to you to optimize latency, minimize costs, or address regulatory requirements. 

### To Create a Bucket
1. Sign in to the AWS Management Console and open the Amazon S3 console at https://console.aws.amazon.com/s3/.
2. Choose `Create bucket`.
3. In `Bucket name`, enter a DNS-compliant name for your bucket.  

    The bucket name must:
    * Be unique across all of Amazon S3.
    * Be between 3 and 63 characters long.
    * Not contain uppercase characters.
    * Start with a lowercase letter or number.  
<br />
4. In `Region`, choose the AWS Region where you want the bucket to reside.
5. In `Bucket settings for Block Public Access`, uncheck the `Block Public Access` settings that you want to apply to the bucket.
6. Choose `Create bucket`.

### Deleting a Bucket
Follow the steps provided in the [AWS User Guide for deleting a bucket](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/delete-bucket.html)

**Once you have created a bucket, you can use it to [host static websites](./static-site-hosting/md).**
