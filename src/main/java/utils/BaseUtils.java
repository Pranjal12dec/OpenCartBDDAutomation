package utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtils {

  private static final Logger log = LogManager.getLogger(BaseUtils.class);

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
        log.error("--------------------------------------------------------------------------");
        log.error(
            givenurl + " ---> " + connection.getResponseCode() + connection.getResponseMessage()
                + " --> is a broken link");
        log.error("--------------------------------------------------------------------------\n\n");
        System.out.println(givenurl + " is having issues");
      } else {
        log.info("-----------------------------------------------------------------------------");
        log.info(givenurl + " --> " + connection.getResponseCode() + " "
            + connection.getResponseMessage());
        log.info("--------------------------------------------------------------------------\n\n");
      }
    } catch (Exception e) {
      log.error("Unable to connect using HTTP connection");
    }
  }

  public void waitUntilPageTitleIsFound(WebDriver driver, String pageTitle){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    log.info("::::: Waiting for Page Title::::: "+pageTitle+" To be displayed");
    wait.until(ExpectedConditions.titleContains(pageTitle));
  }
}