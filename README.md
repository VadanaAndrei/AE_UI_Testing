# UI Automation Framework (Java + Selenium)

This is a modular test automation framework built to test web applications. I created it to demonstrate a structured approach to UI testing using **Java**, **Selenium WebDriver**, and **JUnit 5**.

The project focuses on writing clean, maintainable code by separating locators, business logic, and assertions.

## Tech Stack

* **Java 8+**
* **Selenium WebDriver** (v4.x)
* **JUnit 5** - Test runner
* **Maven** - Build & dependency management
* **Allure Report** - For detailed test execution reports
* **AssertJ** - For readable, fluent assertions
* **Owner** - For managing configuration properties

## Architecture

I used the **Page Object Model (POM)** pattern but split the responsibilities into clear layers:

* `pages` → Stores WebElements and locators.
* `steps` → Contains the user actions and business logic.
* `assertions` → Custom validation logic separate from the test files.
* `tests` → The actual test scripts.

## How to Run

### Prerequisites
Make sure you have **Java** and **Maven** installed on your machine.

### Run the Tests
To run the full test suite defined in `pom.xml`:

```bash
mvn clean test
```
After the tests finish, use this command to generate and open the Allure HTML report:
```bash
mvn allure:serve
```
