## Hosting Static Sites on S3
You can use Amazon S3 to host a static website. On a *static website*, individual webpages include static content.

> By contrast, a *dynamic website* relies on server-side processing, including server-side scripts such as PHP, JSP, or ASP.NET. Amazon S3 does not support server-side scripting, but AWS has other resources for hosting dynamic websites. To learn > more about website hosting on AWS, see [Web Hosting](https://aws.amazon.com/websites/).

* To configure your bucket for static website hosting, you can use the AWS Management Console without writing any code.
* You can also create, update, and delete the website configuration programmatically by using the AWS SDKs. The SDKs provide wrapper classes around the Amazon S3 REST API. If your application requires it, you can send REST API requests directly from your application.
* To host a static website on Amazon S3, you [configure an Amazon S3 bucket for website hosting](./s3-bucket-configuration.md) and then upload your website content to the bucket.

### Steps to Host a Static Website on your Previously Created S3 Bucket
1. Click on your bucket in your S3 Management Console
2. Select `Overview` > `Create Folder` - this is where you will upload static HTML files from your computer to be hosted on the S3 bucket.

3. Copy and Paste the following dummy HTML text into a file titled `index.html` on your computer. 

```html
<html>
<head>
    <title>Here's a title, displayed at the top of the window.</title>
</head>
<body>
    <h1>A main heading, usually the same as the title.</h1>
    <p>Be <b>bold</b> in stating your key points. Put them in a list: </p>
    <ul>
        <li>The first item in your list</li>
        <li>The second item; <i>italicize</i> key words</li>
    </ul>

    <p>Add a link to your favorite <a href="https://revature.com/learn-to-code/">Web site</a>.
        Break up your page with a horizontal rule or two. </p>
    <hr>
    <p>Finally, link to <a href="page2.html">another page</a> in your own Web site.</p>
    <!-- A copyright notice.-->
    <p>&#169; Revature 2020</p>
</body>

</html>
```

4. Select `Upload` and upload the `index.html` file you just saved to your computer.
5. Select `Properties`
6. Select `Static website hosting`
7. Select `Use this bucket to host a website` > enter the name of the file we're hosting: `index.html`.
8. Return to your bucket > click on the uploaded `index.html` file > click `Make public`.
9.  Visit the `Object URL` and you will see your static webpage hosted on your configured S3 bucket!


### References
* [Configuring a bucket as a static website using the AWS Management Console](https://docs.aws.amazon.com/AmazonS3/latest/dev/HowDoIWebsiteConfiguration.html)
