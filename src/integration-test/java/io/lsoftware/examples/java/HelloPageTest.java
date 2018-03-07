package io.lsoftware.examples.java;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloPageTest {

  @Autowired
  private WebDriver webDriver;

  @Test
  public void openingHelloPageWithNameParameterShouldDisplayName() {
    webDriver.get("http://localhost:8080/hello?name=Foo");
    WebElement nameElement = webDriver.findElement(By.id("name"));

    assertTrue(nameElement.getText().equals("Hello, Foo!"));
  }

}
