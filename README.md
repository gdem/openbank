# Raiffeisen Openbank API

An open source RESTful API platform for banks that supports accounts, transactions, transfers (payments), etc.

## Documentation
[Openbanking Developer Zone](https://openbanking.atlassian.net/wiki/spaces/DZ/overview)

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `ch.raiffeisen.openbank.OpenBankApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```


### Usage

- Launch the application and go on [http://localhost:8080/](http://localhost:8080/)
- Spring Boot can automatically initializes the database. It loads SQL from the standard root classpath locations: data-h2.sql, respectively. You can modify the SQL script to provide your own data.
- Launch the h2-console and go on [http://localhost:8080/h2-console/](http://localhost:8080/h2-console) to inspect your database.


## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/gdem/openbank/blob/master/LICENSE) file.
