import com.amazonaws.services.s3.AmazonS3;

import java.util.Scanner;

/**
 * Author: Dhrumil Rakesh Shah
 * Version: 1.0
 * Class: The Main class containing the boilerplate code of AWS SDK for Java
 * for Assignment 3
 */
public class Main {
  // The driver method
  public static void main(String[] args) {

    try {

      // Instantiating the Scanner object to read user input
      Scanner sc = new Scanner(System.in);

      // Declaring & Initializing the choice to 0 that stores the
      // choice made by the user
      int choice = 0;

      S3Task s3TaskObject = new S3Task();

      AmazonS3 s3Object = s3TaskObject.getConnection();

      // Looping through the menu
      while (choice != -1) {
        System.out.println("Choose any of the below tasks.");
        System.out.println("1. Create two new buckets.");
        System.out.println("2. Upload all files in tech folder to the " +
            "firstb00870600 bucket.");
        System.out.println("3. Testing the extractFeatures Lambda function.");
        System.out.println("4. Exit.");

        // Reading the user entered choice
        choice = sc.nextInt();

        // Switching through the different choices
        switch (choice) {
          // Creating a new bucket
          case 1:
            s3TaskObject.createBucket("firstb00870600", s3Object);
            s3TaskObject.createBucket("secondb0870600", s3Object);
            break;
          case 2:
            // Uploading the file to the created bucket
            s3TaskObject.fileUploadToS3Bucket(s3Object,
                "firstb00870600");
            break;
          case 3:
            // Testing the extractFeatures Lambda function
            s3TaskObject.testLambda(s3Object);
          case 4:
            // Exiting the application
            System.exit(0);
          default:
            // Default switch case
            System.out.println("Enter a valid option.");
            break;
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
