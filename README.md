# Forgot Password Automation Testing Project

## Project Objective

This project demonstrates **automated testing of the complete forgot password workflow** on the-internet.herokuapp.com website. The automation validates the entire user journey from password reset request to successful login, showcasing modern test automation practices with comprehensive reporting.

## Technologies & Tools Used

### Core Technologies
- **Java 8+** - Primary programming language for test scripts
- **Selenium WebDriver 4.12.1** - Browser automation and web element interaction
- **TestNG 7.9.0** - Test framework for test management, execution, and reporting
- **Cucumber 7.15.0** - Behavior-Driven Development (BDD) framework with Gherkin syntax
- **Maven** - Project management and dependency resolution
- **WebDriverManager 5.6.3** - Automatic browser driver management (eliminates manual driver setup)

### Reporting & Documentation
- **Allure Reports 2.24.0** - Beautiful, interactive HTML test reports with screenshots
- **ExtentReports 5.0.9** - Alternative reporting framework
- **VS Code** - Development environment with integrated tasks

### Design Patterns & Best Practices
- **Page Object Model (POM)** - Clean separation of page elements and test logic
- **Configuration Management** - External `.properties` files for environment settings
- **Wait Strategies** - Explicit waits with WebDriverWait for reliable element interactions
- **Multiple Locator Strategy** - Fallback locators for robust element finding

## Project Structure

```
ForgotPassword/
├── .github/
│   └── copilot-instructions.md      # GitHub Copilot custom instructions
├── .vscode/
│   └── tasks.json                   # VS Code tasks for test execution
├── src/
│   ├── main/java/
│   │   ├── pages/                   # Page Object Model classes
│   │   │   ├── LoginPage.java       # Login page elements and actions
│   │   │   └── ForgotPasswordPage.java # Forgot password page elements
│   │   └── utils/                   # Utility classes
│   │       ├── ConfigReader.java    # Configuration file reader
│   │       └── AllureUtils.java     # Allure screenshot and attachment utilities
│   └── test/
│       ├── java/
│       │   ├── runner/
│       │   │   └── TestRunner.java  # Cucumber test runner
│       │   ├── stepdefs/
│       │   │   └── SaucedemoSteps.java # Cucumber step definitions
│       │   └── tests/
│       │       ├── LoginTest.java   # TestNG test class
│       │       └── ElementExplorerTest.java # Debug utility test
│       └── resources/
│           ├── config.properties    # Environment configuration
│           ├── allure.properties    # Allure reporting configuration
│           └── theinternet.feature  # Cucumber BDD scenarios
├── target/
│   ├── allure-results/             # Allure test execution data
│   ├── cucumber-reports/           # Cucumber HTML reports
│   └── surefire-reports/           # TestNG XML/HTML reports
├── pom.xml                         # Maven dependencies and build configuration
└── README.md                       # Project documentation
```

## Challenges & Obstacles Encountered

### 1. **Missing Forgot Password Link**
- **Problem**: Initial assumption that login page contained a "Forgot Password" link
- **Solution**: Direct navigation to `/forgot_password` endpoint instead of link clicking
- **Learning**: Always verify actual website structure before writing locators

### 2. **Incorrect Element Locators**
- **Problem**: `By.id("content")` locator for confirmation message failed
- **Solution**: Implemented multiple locator strategy with `By.id("flash")` as primary and `By.tagName("h1")` as fallback
- **Learning**: Build robust element finding with multiple strategies

### 3. **Browser Cleanup Issues**
- **Problem**: Browser windows remained open after test failures
- **Solution**: Added `@After` hooks in Cucumber and `@AfterMethod` in TestNG with try-catch blocks
- **Learning**: Proper cleanup is crucial for stable test execution

### 4. **ChromeDriver Version Compatibility**
- **Problem**: CDP warnings due to Chrome browser version 139 compatibility
- **Solution**: Used WebDriverManager for automatic driver version management
- **Learning**: Automated driver management prevents version conflicts

### 5. **Test Data Validation**
- **Problem**: Hard-coded expected message text caused failures
- **Solution**: Flexible validation accepting multiple message variations
- **Learning**: Make assertions resilient to minor UI text changes

## Final Results & Achievements

### Successful Test Implementation

1. **Complete Automation Pipeline**
   - Automated forgot password form submission
   - Confirmation message validation
   - Successful login with known credentials
   - End-to-end workflow verification

2. **Robust Test Framework**
   - Dual testing approach: TestNG + Cucumber
   - Page Object Model implementation
   - Configuration-driven test data
   - Comprehensive error handling

3. **Professional Reporting**
   - Allure Reports with interactive dashboard
   - Step-by-step execution details
   - Screenshots on failure
   - Test execution trends and statistics

4. **CI/CD Ready**
   - Maven-based build system
   - VS Code integrated tasks
   - Command-line execution support
   - Background report serving

### Test Execution Metrics

- **Test Coverage**: Complete forgot password workflow
- **Execution Time**: ~30-45 seconds per test run
- **Browser Support**: Chrome (extensible to other browsers)
- **Reliability**: Robust with multiple fallback strategies
- **Reporting**: Real-time HTML reports with screenshots

### Key Accomplishments

1. **Demonstrated Modern Test Automation Practices**
   - BDD approach with readable scenarios
   - Maintainable Page Object Model
   - Professional-grade reporting

2. **Problem-Solving & Debugging Skills**
   - Systematic approach to element location issues
   - Creative solutions for missing UI elements
   - Comprehensive error handling

3. **Tool Integration Mastery**
   - Seamless integration of multiple testing frameworks
   - Automated report generation and serving
   - Development environment optimization

## How to Run

### Prerequisites
- Java 8 or higher
- Maven 3.6+
- Google Chrome browser

### Execution Commands
```bash
# Run all tests
mvn clean test

# Run specific test class
mvn test -Dtest=LoginTest

# Run Cucumber tests
mvn test -Dcucumber.options=src/test/resources/theinternet.feature

# Generate and serve Allure report
mvn allure:serve
```

### VS Code Tasks
- **Run TestNG Tests**: Execute TestNG test suite
- **Run Cucumber Tests**: Execute BDD scenarios
- **Generate Allure Report**: Create static HTML report
- **Open Allure Report**: Start server and open in browser

## Conclusion

This project successfully demonstrates a complete test automation solution with modern tools and practices. Despite encountering several technical challenges, each obstacle was systematically resolved, resulting in a robust, maintainable, and professional-grade automation framework that can serve as a template for future testing projects.
