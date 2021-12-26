import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

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
        "ASIAYN2RGTSOE5Q4C5V4",
        "sRZ9yFppgxacwQKwD73vCMtwParngli8mffeRg6n",
        "FwoGZXIvYXdzEDYaDPkDdnVcKp2hbQrumCK9Afy4RrM7l6rVnVqRbkI" +
            "Gmy9ejYdcfUfPZA8lBAZIhT02zIZ9YkQYSNUOnmCYZUTHXBJjt9w1PdkNrXtK" +
            "0PXj0fcjOPsPLg8g91mJ+cgpb+N/McC+XL94Vl/pDkws0xEo1fZzUjZ4VLSXXA" +
            "z86jjU2LDpaSNZ10tPEwXhrx8dHU2BClyKaScAI6EfV1tX+gd3JrcnWANwxB3C" +
            "QhmGna8Mxv4M1f2L4lE1Nq/kM7f3iSo/4jjsRqtitkKc537bBiix7caKBjItF38" +
            "tpoHmhJolOXA1qZEg9IBegO9ReYuyvU66KD7KR3ijp8rNDtuk82W4LQZ6");

    // Establishing connection with the Amazon S3 service
    // and storing it in the s3Object
    AmazonS3 s3Object = AmazonS3ClientBuilder.standard().withCredentials
            (new AWSStaticCredentialsProvider(sessionCredentials))
        .withRegion(Regions.US_EAST_1)
        .build();

/*
    // Establishing connection with the Amazon S3 service
    // and storing it in the s3Object
    AmazonS3 s3Object = AmazonS3ClientBuilder.standard()
        .withRegion(Regions.US_EAST_1)
        .build();
*/

    // Returning the s3Object
    return s3Object;
  }

  // The public method to upload the file to a S3 bucket
  public void fileUploadToS3Bucket(String fileName,
                                   AmazonS3 s3Object,
                                   String bucketName) {
    try {
      // Creating a new file with the passed fileName
      File file = new File(fileName);

      // Uploading the file to the S3 bucket
      s3Object.putObject(bucketName, fileName, file);

      // Printing to the console
      System.out.format("The file '%s' is pushed to the '%s' bucket \n",
          fileName, bucketName);

      // Catching the exception
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
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
}
