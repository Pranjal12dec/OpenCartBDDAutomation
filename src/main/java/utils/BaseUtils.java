package utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

public class BaseUtils {

  public void findBrokenElements(List<WebElement> elements, String elementTag) {
    List<String> urlList = new ArrayList<String>();
    for (WebElement listelement : elements) {
      String url = listelement.getAttribute(elementTag);
      urlList.add(url);
    }
    urlList.parallelStream().forEach(this::checkURL);
  }

  private void checkURL(String linkURL) {
    try {
      URL givenurl = new URL(linkURL);
      HttpURLConnection connection = (HttpURLConnection) givenurl.openConnection();
      connection.setConnectTimeout(5000);
      connection.connect();
      if (connection.getResponseCode() >= 400) {
        System.out.println(
            givenurl + "--->" + connection.getResponseMessage() + " is a broken link");
      } else {
        System.out.println(givenurl + "-->" + connection.getResponseMessage());
      }
    } catch (Exception e) {
      System.out.println("Unable to connect using HTTP connection");
    }
  }
}