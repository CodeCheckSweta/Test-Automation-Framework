# Test Automation Framework

<p align="center">
  <strong>Scalable Selenium Web Automation Framework using Java, TestNG and Maven</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-11+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Selenium-4.44.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white" />
  <img src="https://img.shields.io/badge/TestNG-7.12.0-EF2D5E?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
</p>

## 📌 Overview

This project demonstrates a **Java + Selenium WebDriver test automation framework** for end-to-end UI testing of an e-commerce application.

The framework is designed around maintainability, reusable components, data-driven testing, parallel execution, configurable browser execution, and CI-friendly test runs.

## 🎯 Automated Scenarios

The current TestNG suite covers key user journeys including:

- 🔐 Valid login
- 🚫 Invalid login
- 🏠 Adding a new address
- 🔎 Product search
- 🛒 Product checkout

The TestNG suite is configured for **parallel method execution with four threads**, supporting faster regression execution. fileciteturn9file0L2-L5

## 🧰 Technology Stack

| Technology | Purpose |
| --- | --- |
| **Java 11+** | Programming language |
| **Selenium WebDriver** | Browser automation |
| **TestNG** | Test execution, grouping and parallel execution |
| **Maven** | Build and dependency management |
| **Gson** | JSON/data handling |
| **OpenCSV** | CSV-based test data |
| **Apache POI** | Excel data handling |
| **Log4j2** | Application/test logging |
| **ExtentReports** | Test reporting |
| **JavaFaker** | Dynamic test data generation |
| **LambdaTest** | Cloud browser execution |

The project's Maven configuration includes Selenium, TestNG, Gson, OpenCSV, Apache POI, Log4j2, ExtentReports and JavaFaker dependencies. fileciteturn8file0L2-L5

## 🏗️ Framework Capabilities

### Page Object Model

Application pages and test logic are separated to improve readability, reuse, and maintainability.

### Data-Driven Testing

The framework supports external test data through formats such as **CSV and Excel**, with utilities for reading and processing test data.

### Parallel Execution

TestNG is configured for parallel method execution with a thread count of four, reducing overall regression execution time. fileciteturn9file0L2-L2

### Configurable Browser Execution

Browser and execution behaviour can be supplied as Maven system properties:

```bash
mvn clean test \
  -Dbrowser=chrome \
  -DisLambdaTest=false \
  -DisHeadless=true
```

The Maven Surefire configuration passes these values into the TestNG execution. fileciteturn8file0L2-L2

### Cloud Execution

The framework supports LambdaTest execution through the `isLambdaTest` configuration, allowing the same automation suite to be used for local and cloud-based browser testing.

### Reporting & Logging

**ExtentReports** is used for test reporting and **Log4j2** for logging, providing useful execution visibility when diagnosing failures.

## 📂 Project Structure

```text
Test-Automation-Framework/
├── pom.xml
├── testng.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/ui/
    │           ├── pages/
    │           └── utils/
    └── test/
        └── java/
            └── com/ui/tests/
                ├── LoginTest.java
                ├── InvalidCredLoginTest.java
                ├── AddNewFirstAddressTest.java
                ├── SearchProductTest.java
                └── ProductCheckoutTest.java
```

## ▶️ Getting Started

### Prerequisites

- Java 11 or later
- Maven 3.8+
- Chrome/Firefox/Edge browser
- Git

### Clone

```bash
git clone https://github.com/CodeCheckSweta/Test-Automation-Framework.git
cd Test-Automation-Framework
```

### Run locally in headless Chrome

```bash
mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
```

### Run with a visible browser

```bash
mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=false
```

### Run against LambdaTest

```bash
mvn clean test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
```

> Replace the LambdaTest configuration/credentials with your own environment-specific values. Never commit credentials to the repository.

## 🧪 Example Execution Flow

```text
TestNG Suite
     ↓
Browser / Environment Configuration
     ↓
Page Objects
     ↓
Test Data & Utilities
     ↓
UI Test Execution
     ↓
Assertions
     ↓
Extent Report + Logs
```

## 📊 Quality Engineering Practices Demonstrated

- ✅ Page Object Model
- ✅ Data-driven testing
- ✅ Parallel execution
- ✅ Configurable browser execution
- ✅ Local + cloud browser testing
- ✅ Dynamic test-data generation
- ✅ Structured logging
- ✅ HTML test reporting
- ✅ Maven-based execution
- ✅ CI/CD-ready architecture

## 🚀 Potential Enhancements

- [ ] Add GitHub Actions workflow
- [ ] Add Docker-based execution
- [ ] Add automatic screenshot/video capture on failure
- [ ] Add retry handling for transient UI failures
- [ ] Add environment configuration files
- [ ] Add richer test categorisation with TestNG groups
- [ ] Add accessibility testing
- [ ] Add API + UI hybrid workflows

## 👩‍💻 Author

**Sweta Singh — Senior QA Engineer / SDET**

Focused on **test automation, Selenium, Playwright, API testing, CI/CD, Docker, and quality engineering**.

[GitHub Profile](https://github.com/CodeCheckSweta) · [LinkedIn](https://www.linkedin.com/in/swetasingh22/)

---

⭐ If you find this framework useful, consider starring the repository.
