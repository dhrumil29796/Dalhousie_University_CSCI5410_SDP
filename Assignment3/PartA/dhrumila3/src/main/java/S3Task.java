import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

/**
 * Author: Dhrumil Rakesh Shah
 * Version: 1.0
 * Class: The AWS SDK for Java helper class
 */
public class S3Task {

  // The method to get connection object of the AWS account
  public AmazonS3 getConnection() {

    // Storing the AWS credentials to establish the connection
    BasicSessionCredentials sessionCredentials = new BasicSessionCredentials(
        "ASIAYN2RGTSOBPUQ5DBV",
        "4vxZQggC1hSF7QblDgErSuMJ0e0Ab6GfknBvjNUg",
        "FwoGZXIvYXdzEIn//////////wEaDD+7t6vcfZOA5QcwKCK9AdS25YlT" +
            "jDdeanTXWoWVa8zMqIdPeqwgbpsfSVptCU+2bi0DBGkcFv5czXVtsyg9Wv615wt" +
            "c4mOKjYGkh9Uh6bhn6qLYshVu4EtXloqrD+Ye7xO8r3wUXrT2SydHJtmv1oWBcCr" +
            "9XoxY64vs9jJByICeL930Ozybwsn7hzZYeQ1weumC5zE2SL8UukXJrM/n0MVI9Pz" +
            "pPa57zlkmeOYIDOkjF82PgUxrGOUeH1Nnh73Z8RjT5aW/sPeg9dN5MCjv8IGMBjI" +
            "tHprRFHAYt+KUKGnwPxf5JzDDl2MX2BYaNDPVFrM4roZzpXDAR5gOAGSRJpGm");

    // Establishing connection with the Amazon S3 service
    // and storing it in the s3Object
    AmazonS3 s3Object = AmazonS3ClientBuilder.standard().withCredentials(
            new AWSStaticCredentialsProvider(sessionCredentials))
        .withRegion(Regions.US_EAST_1)
        .build();

    // Returning the s3Object
    return s3Object;
  }

  // The public method to create a new S3 bucket
  public void createBucket(String bucketName, AmazonS3 s3Object) {
    try {
      // Creating a new S3 bucket using the s3Object
      s3Object.createBucket(bucketName);

      // Printing to the console
      System.out.format("A new bucket '%s' is created.\n", bucketName);

      // Catching the exception
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  // The public method to upload multiple files to a S3 bucket
  public void fileUploadToS3Bucket(AmazonS3 s3Object,
                                   String bucketName) {
    try {
      // Looping through the files in tech folder
      for (int i = 1; i <= 401; i++) {

        // Declaring the filePrefix and fileName
        String filePrefix = "";
        String fileName = "";

        // Conditioning through the files in tech folder
        if (i < 10) {
          filePrefix = "00" + i;
          fileName = "tech/00" + i + ".txt";
        } else if (i > 9 && i < 100) {
          filePrefix = "0" + i;
          fileName = "tech/0" + i + ".txt";
        } else {
          filePrefix = "" + i;
          fileName = "tech/" + i + ".txt";
        }

        // Instantiating the PutObjectRequest class
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
            filePrefix, new File(fileName));

        // Uploading the file to the S3 bucket
        s3Object.putObject(putObjectRequest);

        // Printing to the console
        System.out.format("The file '%s.txt' is pushed to the '%s' bucket \n",
            filePrefix, bucketName);

        // Adding a delay of 200 milliseconds after adding a new file to the bucket
        Thread.sleep(200);

        // Printing that 200 milliseconds sleep is added
        System.out.println("Added delay of 200 millis");
      }
      // Catching the exception
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  // Method to test the working of extractFeatures Lambda function
  public void testLambda(AmazonS3 s3Client) {
    String bucketName = "firstb00870600";
    String filePrefix = "001";
    String fileName = "tech/001.txt";
    try {
      PutObjectRequest request = new PutObjectRequest(bucketName, filePrefix, new File(fileName));
      s3Client.putObject(request);

      // Printing to the console
      System.out.format("The file '%s.txt' is pushed to the '%s' bucket \n",
          filePrefix, bucketName);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
