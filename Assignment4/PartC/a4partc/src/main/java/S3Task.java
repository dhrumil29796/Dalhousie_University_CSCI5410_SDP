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
        "ASIAYN2RGTSOCFYC5PB7",
        "ECRW41KLbKOJCisVIJGJ7gRO3MqRjj7MCYTPvNG6",
        "FwoGZXIvYXdzEL7//////////wEaDAPLDINS8X9b3Yl2kiK9AfBQe8LP" +
            "1e/v7N9QRogfsC9khyBL5vvLuXqo66Ye3tBpMfs916BrOmvkWnP3a57liTkxY4g" +
            "bQF4NLUpDTUnKtXnvk8XIkb886FfFeRAjIACvsmELndeBR74X2csdS0wuo3kXY/" +
            "RPVF/0reWIKFlORqVDk57DZP8h4Fca5/NB8xKk3lO4U9f4otkJw1l0PPdwkwGyqF" +
            "3GD/kwM4TQOnJWpb1lRqICCl/wMdm6otBZnF2N46iDOR/3hFJCC84yWyjP4sWMBj" +
            "ItmmHhhBaw9yHv1HWzF0LLXMYcP93uQEIts3gwkeyhkqivRRoDEs0E6mkiOOy+");

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
  public void fileUploadToS3Bucket(AmazonS3 s3Object, String fileName,
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
}
