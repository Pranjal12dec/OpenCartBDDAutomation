# OpenCartBDDAutomation Project
![Logo](https://demo.opencart.com/image/catalog/opencart-logo.png)

### OpenCart is an online store management system. It is PHP-based, using a MySQL database and HTML components. Support is provided for different languages and currencies. It is freely available under the GNU General Public License.

#### This project is created to demonstrate the automation scope for the manual test cases

## Run Locally

Clone the project
```bash
  git clone https://github.com/Pranjal12dec/OpenCartBDDAutomation.git
```

Go to the project directory
```bash
  cd OpenCartBDDAutomation-project-location
```

Run the test without sending an email
```bash
  mvn test
```

Run the test & send an email after the test execution
```bash
  mvn clean install
```

## Configuration (Available at src/resources/configs/Configuration.properties file)

Following are the configurations available in the Configuration.properties file:

`aut_url:` URL where the test is running

`environment:` local or remote (Currently, only local is supported)

`browser:` Available browser type = Chrome, firefox, edge, safari

`windowMaximize:` if set to false, then the browser will launch in the default window size

`implicitWaitTime:` Implicit wait duration in seconds

`to_email_address:` Replace with your email address to receive email

`from_email_address:` Please don't change this

`from_email_address_password:`Please don't change this

#### Note: Please update the new email configurations in the Configuration.properties file if changing the from_email_address and from_email_address_password fields

## Tech Stack

**Automation Tool:** Selenium 4.11

**Framework:** Cucumber Framework (BDD) version 7.13.0

**Language:** Java 17, Gherkin

**Reporting:** Extent Report 5.1.0

**Testing Library:** TestNG 7.8.0

**Logging:** Log4J Version 2.20.0

**Parallel Execution:** Yes, with Maven Surefire Plugin and ThreadLocal

**Code Formatting Styleguide:** Google Styleguide


## Features

- BDD Framework on the latest Cucumber version

- Page Object Pattern using Selenium Page Factory

- Singleton Design Pattern

- Managers like Page Object Manager, File Reader Manager, and WebDriver Manager

- Config File Reader

- Sharing Test Context using PicoContainer

- Hooks

- Sharing Scenario Context

- Cucumber Report Plugins

- Extent Reports with Screenshots

- Sending email after test execution using Exec-Maven-Plugin & Jakarta Mail API

- Generating PDF Reports

- Latest Log4J version 2 implementation

- TestNg

- ThreadLocal

- Browser Utilities

## Author

- [@Pranjal12dec](https://github.com/Pranjal12dec)
