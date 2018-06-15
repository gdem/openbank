package ch.raiffeisen.openbank.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Swagger 2 Configuration for REST API documentation.
 * 
 * @see EnableSwagger2
 * @author Goekhan Demirkiyik
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private static final String API_V1_ANT_PATTERN = "/api/**";

  @Inject
  private Environment env;

  /**
   * Creates a {@code Docket} instance.
   */
  @Bean
  public Docket docket() {
    // @formatter:off
    return new Docket(DocumentationType.SWAGGER_2)
              .select()
              .paths(PathSelectors.ant(API_V1_ANT_PATTERN))
              .build()
              .ignoredParameterTypes(Pageable.class, PagedResourcesAssembler.class)
              .useDefaultResponseMessages(false)
              .apiInfo(buildMetadata());
    // @formatter:on
  }

  private ApiInfo buildMetadata() {
    // @formatter:off
    return new ApiInfoBuilder()
        .title(env.getProperty("swagger.title"))
        .description(env.getProperty("swagger.description"))
        .version(env.getProperty("swagger.version"))
        .license(env.getProperty("swagger.license"))
        .licenseUrl(env.getProperty("swagger.licenseUrl"))
        .termsOfServiceUrl("swagger.termsOfServiceUrl")
        .contact(new Contact(
            env.getProperty("swagger.contact.name"), 
            env.getProperty("swagger.contact.url"), 
            env.getProperty("swagger.contact.email")
            ))
        .build();
    // @formatter:on
  }
}
