## Final IT Bootcamp project - Selenium Test Automation

This is Java based project example for automating tests with Selenium WebDriver,
Maven, and TestNG using the web application [My Awesome App](https://vue-demo.daniel-avellaneda.com/).<br />
Project is organized using the Page Object Model design pattern which provides better maintainability and structure for
automating UI tests.<br/> Page classes are organized into Landing, Login, Signup, Profile, Navigation, 
Message pop up and Cities page. They are located in `src/main/java/pages` directory.<br/>
You can extend or modify them to accommodate changes in the application.<br/>
Test scripts can be found in `src/test/java/tests` directory.<br/>

### All tests are organized into six categories:<br/>

📌 **Login Tests**: login page functionality, successful login, error messages, input fields and button (**[test cases](test_scenarios/TS_LOGIN_PAGE.md)**) <br/>
📌 **Signup Tests**: signup functionality, error messages, successful sign up, input fields and button (**[test cases](test_scenarios/TS_SIGN_UP_PAGE.md)**)<br/>
📌 **Admin Cities Tests**: add, edit and delete functionality for cities page (**[test cases](test_scenarios/TS_ADMIN_CITIES_PAGE.md)**)<br/>
📌 **Auth Routes Tests**: route protection in case user is not authenticated (**[test cases](test_scenarios/TS_AUTH_ROUTES.md)**)<br/>
📌 **Locale Tests**: language buttons functionality, page content in different languages (**[test cases](test_scenarios/TS_LOCALE.md)**)<br/>
📌 **Profile Tests**: profile page functionality, editing a user profile, error messages and successful edit (**[test cases](test_scenarios/TS_PROFILE_PAGE.md)**)

### Requirements

Before running the tests, ensure you have the following dependencies installed:

- Java Development Kit (JDK)
- Maven
- TestNG
- Chrome WebDriver





For running testng file from command line use command: `mvn clean test -Dsurefire.suiteXmlFiles=testng.xml`

