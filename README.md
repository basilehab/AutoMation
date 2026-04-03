<img src="src/main/resources/images/D.png" alt="Mee" width="200" height="200" style="display:block; margin-left:auto; margin-right:auto;"/>

### 🔧 Technologies.

* Java Development Kit [JDK-21](https://www.oracle.com/java/technologies/downloads/#jdk17-windows) as a Development
  Environment.
* [Maven](https://maven.apache.org/) as a build tool, that automate the process of compiling computer source code into
  binary code.
* [TestNG](https://testng.org/) as a Unit Test Automation framework.
* [Selenium WebDriver](https://www.selenium.dev/documentation/en/) for Web App GUI Test Automation.
* [Appium](https://appium.io/) for Mobile App GUI Test Automation.
* [Rest assured](https://javadoc.io/doc/io.rest-assured/rest-assured/latest/index.html) for REST/GraphQl API Test
  Automation.
* [SHAFT_Engine Framework](https://github.com/ShaftHQ/SHAFT_ENGINE.git)
* [Allure Report Framework](https://docs.qameta.io/allure/) for generating test execution report.
* [Extent Report Framework](https://www.extentreports.com/docs/versions/4/java/) for generating test execution report.
* [Data Driven Testing framework](https://www.guru99.com/data-driven-testing.html) to read from data files and store
  them in variables in test scripts.
* [Docker](https://docs.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/overview/) for running Selenium Grid.
* [Selenium Grid](https://www.selenium.dev/documentation/grid/) for remote execution.
* [GitHub Actions](https://docs.github.com/en/actions) for continuous integration.
* Applying Hybrid Test Automation Framework

---

## 📝 Project Design patterns:

* [WebElement Extension Methods](https://toolsqa.com/selenium-webdriver/c-sharp/webelement-extensions-method/) (Selenium
  Wrapper).
* Implementing the ***Test Automation Pyramid*** by have 2 different test automation levels which are SERVICE and GUI
  layers
* Applying
  the [Page Object Model (POM) design pattern](https://www.browserstack.com/guide/page-object-model-in-selenium#:~:text=Page%20Object%20Model%2C%20also%20known,application%20as%20a%20class%20file.)
  .
* Applying the [Fluent design](https://java-design-patterns.com/patterns/fluentinterface/) approach.
* Configurations.Set from [Properties File](src/main/resources/properties)
* [Managing test data](https://www.ontestautomation.com/managing-test-data-in-end-to-end-test-automation/?fbclid=IwAR3JVpSg8jkhxVMgcPzihHDPzSWebbPxLZ7RxX22QQeJlSwQBNhNiXq-koU)
  in end-to-end test automation by approach `Creating test data during test execution`.

---

## ✏ Project Structure:

``` bash

├──   GithubActions
│     ├── workflows
│     │    └── CI.yml
│     └── dependabot.yml 
├──   extent-reports
└──   src
│      ├── main
│      │   ├── com.dentolize 
│      │   │   └── modules
│      │   │       ├── api
│      │   │       │   ├── schema
│      │   │       │   └── CRUD operations
│      │   │       └── gui
│      │   │           ├── web pages
│      │   │           └── mobile screens  
│      │   ├── engine 
│      │   └── resources
│      │       └── properties -> configerations
│      └── test
│          ├── testcases 
│          │   └── modules --> Test and Assert Functions
│          │       ├── Test GUI
│          │       └── Test APIs
│          ├── testSenarios
│          │   └── end_to_end
│          └── resources
│              ├── testData
│              ├── testSuits
│              ├── uploads files
│              └── docker-compose.yml
├──   generate_allure_report.bat
├──   pom.xml
└──   README.md
```

---
<br/>
  <details>
    <summary>
      <strong> 👉 Click here Run to the Test cases locally using IntelliJ IDEA </strong> 
    </summary>


Pre-requisites: jdk-17 and maven should be installed

* Set the [properties](src/main/resources)  including all the configurations
* Set the test Data from [TestData](src/test/resources/testDataFiles)
* Edit your run configuration templates before running your tests by following these steps:
  <br/>- Open 'Edit Run/Debug Configurations' dialog > Edit Configurations... > Edit configuration templates...
  <br/>- Select <b>TestNG</b> > Listeners > and add this listener:
  <br/>`com.shaft.tools.listeners.AlterSuiteListener`, `com.shaft.tools.listeners.SuiteListener`
  , `com.shaft.tools.listeners.InvokedMethodListener`

* Execute All tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn clean test
```

* Execute All API tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn -Dtest=Api* test
```

* Execute All web tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn -Dtest=Web* test
```

* Execute All mobile tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn -Dtest=Mob* test
```

* Execute All smoke tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn test -Dgroups=smokeTest
```

* Execute All regression tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn test -Dgroups=regression
```

* Execute package tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn -Dtest=packageName.tests.**
```

* Execute multiple packages tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn -Dtest=packageName1.tests.**, mvn -Dtest=packageName2.tests.**
```

* Execute multiple packages tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash 
mvn -Dtest=inventory.tests.**, mvn -Dtest=packageName2.tests.**
```

* Execute class tests using Command-line opening a terminal on the project root path and run the
  following command:

```bash
mvn -Dtest=Web_CRUD_Patients_Tests test
```

* After executing,The report will be generated automatically after running the test.
* Find the Extent Report [ExtentReports.html](ExtentReports.html) in the project root path for the latest execution and
  open by any browser

  </details>

---
<br/>
  <details>
    <summary>
      <strong> 👉 Click here to the Run the Test remotely using Selenium-Grid and Docker: </strong> 
    </summary>

Pre-requisites: Docker Desktop should be installed.

* To start selenium-grid using docker-compose; at the root directory of the project, run the following command:

```bash
docker-compose -f src/test/resources/docker-compose.yml up --scale chrome=2 --remove-orphans -d
```

* Open [http://localhost:4444/grid/console](http://localhost:4444/grid/console) to monitor selenium grid.
* Run the test using the following command:

```bash
mvn test
```

* To end/down selenium grid; at the root directory, run the following command:

```bash:
docker-compose -f src/test/resources/docker-compose.yml down --remove-orphans
```

</details>

---


