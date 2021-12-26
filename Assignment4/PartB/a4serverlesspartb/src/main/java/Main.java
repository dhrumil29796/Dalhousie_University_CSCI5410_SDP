import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
  public static void main(String[] args) throws IOException {

    // The ID of your GCP project
    String projectId = "csci-5410-326706";

    // The ID of your GCS bucket
    String bucketName = "sourcedatab00870600";

    for (int i = 1; i <= 299; i++) {
      // The ID of your GCS object
      String objectName = "";

      // The path to your file to upload
      String filePath = "";

      if (i < 10) {
        objectName = "00" + i;
        filePath = "Train/00" + i + ".txt";
      } else if (i > 9 && i < 100) {
        objectName = "0" + i;
        filePath = "Train/0" + i + ".txt";
      } else {
        objectName = "" + i;
      }

      Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
      BlobId blobId = BlobId.of(bucketName, objectName);
      BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
      storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));
    }
  }
}
