# 🚀 Test Automation Framework

This project is a Java-based Test Automation Framework developed using modern automation testing practices.

A robust, scalable, and data-driven test automation framework built with Java 11 and TestNG, supporting local browser execution as well as cloud-based testing via **LambdaTest**. 

The framework supports:

- Selenium WebDriver based automation
- TestNG test execution and reporting
- Data-Driven Testing
- Cloud execution using LambdaTest
- Headless browser execution
- Detailed reporting using Extent Reports
- Logging using Log4j
- Maven-based build and execution
- Parallel execution support
## 🚀 About Me
Hi, My name is Sweta Singh and I have 10 years of experience in Automation testing using technologies like Selenium WebDriver, Rest Assured.

My major expertise is in Java Programming Language. 


## Author

- [@CodeCheckSweta](https://github.com/CodeCheckSweta)
- EmailAddress: sweta.singh0322@gmail.com



## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/CodeCheckSweta)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/swetasingh22/)


## ✅ Prerequisites

Before running this framework, ensure the following are installed and configured on your machine:

1. **Java 11** — [Download JDK 11](https://adoptium.net/)
   ```bash
   java -version
   # Expected: openjdk version "11.x.x"
   ```

2. **Apache Maven 3.x** — [Download Maven](https://maven.apache.org/download.cgi)
   ```bash
   mvn -version
   # Expected: Apache Maven 3.x.x
   ```

3. **Browser Drivers** (for local execution only)
   - **Chrome**: ChromeDriver matching your Chrome version
   - **Firefox**: GeckoDriver matching your Firefox version
   - **Edge**: EdgeDriver matching your Edge version
   - Ensure drivers are added to your system `PATH`, or the framework uses WebDriverManager to auto-manage them.

4. **LambdaTest Account** (for cloud execution only)
   - Sign up at [lambdatest.com](https://www.lambdatest.com/)
   - Retrieve your **Username** and **Access Key** from the LambdaTest dashboard.


## Features

- Built using Java 11, Selenium WebDriver, and TestNG.
- Supports local and LambdaTest cloud execution.
- Supports Chrome, Firefox, and Edge browsers.
- Configurable headless and headed execution modes.
- Data-driven testing using CSV, JSON, and Excel files.
- Dynamic test data generation using Java Faker.
- Command-line execution through Maven Surefire Plugin.
- Runtime configuration using Maven parameters.
- Parallel test execution support through TestNG.
- Detailed execution reporting using Extent Reports.
- Centralized logging using Log4j.
- Scalable and maintainable Page Object Model (POM) design.
- Reusable utility classes for test data and common operations.
- CI/CD-ready framework design for easy pipeline integration.

## 🛠 Tech Stack

| Category              | Technology / Library         | Version     |
|-----------------------|------------------------------|-------------|
| Language              | Java                         | 11          |
| Test Framework        | TestNG                       | Latest      |
| Build Tool            | Maven                        | 3.x         |
| Browser Automation    | Selenium WebDriver           | Latest      |
| Cloud Execution       | LambdaTest                   | —           |
| Data-Driven (CSV)     | OpenCSV                      | Latest      |
| Data-Driven (JSON)    | Gson                         | Latest      |
| Data-Driven (Excel)   | Apache POI                   | Latest      |
| Fake Data Generation  | Java Faker                   | Latest      |
| Reporting             | ExtentReports                | Latest      |
| Logging               | Log4j                        | Latest      |
| Surefire Plugin       | Maven Surefire Plugin        | Latest      |
## ⚙️ Setup & Installation

### 1. Clone the Repository

```bash
git clone https://github.com/CodeCheckSweta/Test-Automation-Framework.git
cd Test-Automation-Framework
```

### 2. Install Dependencies

```bash
mvn clean install -DskipTests
```

This downloads all required Maven dependencies declared in `pom.xml`.

---

## ▶️ Running Tests

### Running Locally

Run tests on a local Chrome browser (default settings):

```bash
mvn test -X
```

---

### Running on Chrome Browser on Local machine in Headless Mode

Headless mode skips the browser UI and runs tests faster — ideal for CI/CD pipelines.

```bash
# Headless on Chrome (local)
mvn test -Dbrowser=chrome -DisHeadless=true -X
```

---

### Running on LambdaTest (Cloud)

```bash
# Run on LambdaTest with Chrome, in headless mode
mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
```

After execution, test results are also available on the **LambdaTest Automation Dashboard** at:
👉 [https://automation.lambdatest.com](https://automation.lambdatest.com)

## 📈 Reports & Logs

### ExtentReports

After every test run, a detailed HTML report will be automatically generated at:

```
./report.html
```

The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.


---

### Log4j Logs

Detailed execution logs are written to the `logs/` directory using **Log4j**:

```
logs/
└── automation.log    # Rolling log file
```

**Log levels used:**
- `INFO` — Test step execution, navigation events
- `DEBUG` — Element interactions, data reads
- `WARN` — Non-critical issues, fallback actions
- `ERROR` — Test failures, exceptions, driver errors

**Log4j configuration** is located at:
```
src/test/resources/log4j2.xml
```

## Integrated the project Github Actions
This Automation Framework is integrated with github actions. The tests will be executed at 11:30PM IST every single day.

The reports will be archieved in gh-pages branch.
You can view the html reports at:

```
https://codechecksweta.github.io/Test-Automation-Framework/report.html
```
