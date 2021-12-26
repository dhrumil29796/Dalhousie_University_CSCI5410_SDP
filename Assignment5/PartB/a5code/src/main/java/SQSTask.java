import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Dhrumil Rakesh Shah
 * Version: 1.0
 * Class: The AWS Java SDK for SQS Task
 */
public class SQSTask {

  // Driver method
  public static void main(String[] args) {

    // Try block
    try {

      // Storing the AWS Credentials
      final String ACCESS_KEY = "ASIAYN2RGTSOGA6ZYIE2";
      final String SECRET_KEY = "BcgD1ln6Y8gY90QsY6l0whR5OznwN3i6UTcKaPXU";
      final String ACCESS_TOKEN = "FwoGZXIvYXdzEM///////////wEaDCqYi9cXMaFjc9x" +
          "vjCK9Abd7RpfRzv4725PcABPAHVE40KnEjwBc1FKJjGReXphB0VWhVUgX/PIXnk1P7Wg" +
          "tvRC/RIdubskJzTF78BUt/vznCBZ8IWr6EAycYzj8bgZKnkqpwISzK0+1ZRXsp12YT3D" +
          "bvrdWnyZQCch5J+YW4ZYw6DPi9GQw7v1iAt9rnCV5tRD5OG/RDbgfBJWuNpAdHD/J7aT" +
          "JEvY2VmpbTaCD59+Ft/XksAnWkMETvrjqAx287Y6y7ylNfw1ny1u9Oijc5YGNBjItoj" +
          "ODj2BmU0AYPB2IWKX9kMTtEfzfzbRCvib1MOT859JDnNre9Pogh/lo22Bv";

      // Storing the SQS Queue Name
      final String QUEUE_NAME = "HalifaxDine";

      // Creating an AWS Credentials object used to connect to the AWS Services
      AWSCredentials awsCredentials = new BasicSessionCredentials(
          ACCESS_KEY, SECRET_KEY, ACCESS_TOKEN);

      // Creating a AWS SQS object using the AWS Credentials
      AmazonSQS amazonSQS = AmazonSQSClientBuilder
          .standard()
          .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
          .withRegion(Regions.US_EAST_1).build();

      // Creating the queueURL that fetches it from the Queue Name
      String queueURL = amazonSQS.getQueueUrl(QUEUE_NAME).getQueueUrl();

      // Creating two ArrayLists storing the foodOrder and orderQuantity
      List<Integer> orderQuantity = new ArrayList<>();
      List<String> foodOrder = new ArrayList<>();

      // Adding the food items in the foodOrder ArrayList
      foodOrder.add("Pav Bhaji");
      foodOrder.add("Vada Pav");
      foodOrder.add("Pani Puri");
      foodOrder.add("Sandwich");
      foodOrder.add("Sizzler");
      foodOrder.add("Lassi");

      // Adding the order quantity in the orderQuantity ArrayList
      orderQuantity.add(1);
      orderQuantity.add(2);
      orderQuantity.add(3);
      orderQuantity.add(4);
      orderQuantity.add(5);
      orderQuantity.add(6);

      // Looping through the ArrayLists and randomly adding orders to the SQS Queue
      for (int i = 0; i < orderQuantity.size(); i++) {
        System.out.println(foodOrder.get(i) + ": " + orderQuantity.get(i));

        // Creating a sendMessageRequest object to make the MessageBody
        // and send to the AWS SQS
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
            .withQueueUrl(queueURL)
            .withMessageBody(foodOrder.get(i) + " " + orderQuantity.get(i))
            .withDelaySeconds(5);
        amazonSQS.sendMessage(sendMessageRequest);
        System.out.println(sendMessageRequest);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
