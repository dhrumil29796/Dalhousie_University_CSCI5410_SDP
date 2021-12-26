import com.amazonaws.services.dynamodbv2.document.DynamoDB;

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

    // Storing the table name in a String
    String tableName = "Super_Volcanoes";

    // Creating a new DynamoDBTask class object
    DynamoDBTask dynamoDBTaskObject = new DynamoDBTask();

    // Calling the getConnection method in the DynamoDBTask class
    // Storing the connection object in dynamoDBObject
    DynamoDB dynamoDBObject = dynamoDBTaskObject.getConnection();

    // Looping through the menu
    while (choice != -1) {
      System.out.println("Choose any of the below tasks.");
      System.out.println("1. Add Last_Eruption_Period attribute to the Super_Volcanoes Table.");
      System.out.println("2. Retrieve items from the Super_Volcanoes Table.");
      System.out.println("3. Exit.");

      // Reading the user entered choice
      choice = sc.nextInt();

      // Switching through the different choices
      switch (choice) {
        case 1:
          // Adding attribute to the Super_Volcanoes table
          dynamoDBTaskObject.addAttributeToItem(tableName, dynamoDBObject);
          break;
        case 2:
          // Retrieving items form the Super_Volcanoes table
          dynamoDBTaskObject.retrieveItem(tableName, dynamoDBObject);
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


