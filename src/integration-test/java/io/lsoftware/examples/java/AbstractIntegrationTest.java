package io.lsoftware.examples.java;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractIntegrationTest {

  @Autowired
  private WebDriver webDriver;

  {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        if (webDriver != null) {
          webDriver.close();
        }
      }
    });
  }
}
