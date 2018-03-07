package io.lsoftware.examples.java;

import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegrationTestConfig {

  @Bean(destroyMethod = "quit")
  public WebDriver webDriver() {
    return new HtmlUnitDriver();
  }

  @Bean
  public URI getSiteBase() throws URISyntaxException {
    return new URI("http://localhost:8080");
  }

}
