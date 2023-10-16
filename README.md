# Selenium Test Automation Project - My Awesome App

This repository contains a Java project for automating tests using Selenium WebDriver,
Maven, and TestNG to test the web application [My Awesome App](https://vue-demo.daniel-avellaneda.com/).<br />
The project follows the Page Object Model (POM) design pattern, providing a structured and maintainable
framework for automating UI tests.<br /> The tests are categorized into the following sections:

- **Login Tests:** Verify user login functionality.
- **Signup Tests:** Verify signup functionality.
- **Admin Cities Tests:** Tests edit and delete functionality for table with cities.
- **Auth Routes Tests:** Tests route protection for user that is not authenticated.
- **Locale Tests:** Tests page content in different languages.
- **Profile Tests:** Tests profile form and functionality for editing a profile.

## Prerequisites

Before running the tests, ensure you have the following dependencies installed:

- Java Development Kit (JDK)
- Maven
- TestNG
- Chrome WebDriver

## Page Objects

The project follows the Page Object Model (POM) design pattern.
Page objects are located in the `src/main/java/pages` directory. You can extend or modify them to accommodate changes in the application.