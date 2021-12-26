import com.amazonaws.services.s3.AmazonS3;

import java.util.Scanner;

/**
 * Author: Dhrumil Rakesh Shah
 * Version: 1.0
 * Class: The Main class containing the boilerplate code of AWS SDK for Java
 */
public class Main {

  // The driver method
  public static void main(String[] args) {

    // Instantiating the Scanner object to read user input
    Scanner sc = new Scanner(System.in);

    // Declaring & Initializing the choice to 0 that stores the
    // choice made by the user
    int choice = 0;

    // Storing the fileName of the file created
    String fileName = "Dhrumil.txt";

    // Storing the bucket name in a String
    String bucketName = "dhrumil-shah-bucket";

    // Creating a new S3Task class object
    S3Task s3TaskObject = new S3Task();

    // Calling the getConnection method in the S3Task class
    // Storing the connection object in s3Object
    AmazonS3 s3Object = s3TaskObject.getConnection();

    // Looping through the menu
    while (choice != -1) {
      System.out.println("Choose any of the below tasks.");
      System.out.println("1. Create a new bucket.");
      System.out.println("2. Upload a file to the bucket.");
      System.out.println("3. Exit.");

      // Reading the user entered choice
      choice = sc.nextInt();

      // Switching through the different choices
      switch (choice) {
        // Creating a new bucket
        case 1:
          s3TaskObject.createBucket(bucketName, s3Object);
          break;
        case 2:
          // Uploading the file to the created bucket
          s3TaskObject.fileUploadToS3Bucket(fileName, s3Object, bucketName);
          break;
        case 3:
          // Exiting the application
          System.exit(0);
        default:
          // Default switch case
          System.out.println("Enter a valid option.");
          break;
      }
    }
  }
}
