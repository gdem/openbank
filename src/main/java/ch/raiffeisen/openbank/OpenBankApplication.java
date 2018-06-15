package ch.raiffeisen.openbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * This class is the entry-point to start the Spring Boot Application.
 *
 * @see SpringBootApplication
 * @author Goekhan Demirkiyik
 */
@SpringBootApplication
public class OpenBankApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(OpenBankApplication.class);
  }

  /**
   * Starts the application by the given array of arguments.
   *
   * @param args the array of arguments to start with. Will be ignored, because spring boot does not
   *        need any arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(OpenBankApplication.class);
  }
}
