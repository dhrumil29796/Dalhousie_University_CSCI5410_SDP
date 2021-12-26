import com.amazonaws.services.s3.AmazonS3;

import java.util.Scanner;

/**
 * Author: Dhrumil Rakesh Shah
 * Version: 1.0
 * Class: The Main class containing the boilerplate code of AWS SDK for Java
 * for Assignment 4
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

      String fileName = "file_mongo_tweets.txt";

      S3Task s3TaskObject = new S3Task();

      AmazonS3 s3Object = s3TaskObject.getConnection();

      // Looping through the menu
      while (choice != -1) {
        System.out.println("Choose any of the below tasks.");
        System.out.println("1. Create a new bucket.");
        System.out.println("2. Upload the tweets file to the " +
            "twitterdatab00870600 bucket.");
        System.out.println("3. Exit.");

        // Reading the user entered choice
        choice = sc.nextInt();

        // Switching through the different choices
        switch (choice) {
          // Creating a new bucket
          case 1:
            s3TaskObject.createBucket("twitterdatab00870600", s3Object);
            break;
          case 2:
            // Uploading the file to the created bucket
            s3TaskObject.fileUploadToS3Bucket(s3Object, fileName,
                "twitterdatab00870600");
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
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
