package utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebElement;

public class BaseUtils {

  public void findBrokenElements(List<WebElement> elementList, String elementTag)
      throws IOException {
    for (WebElement element : elementList) {
      HttpURLConnection connection = (HttpURLConnection) new URL(
          element.getAttribute(elementTag.toLowerCase())).openConnection();
      connection.connect();
      assertThat(connection.getResponseMessage()).isEqualToIgnoringCase("OK");
      connection.disconnect();
    }
  }
}
