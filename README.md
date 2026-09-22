# PlaywrightFramework

A Java-based UI test automation framework built with **Playwright** and **TestNG**, developed as part of a hands-on learning path covering UI automation, API testing, CI/CD, and AI-assisted testing.

> 🚧 **Work in progress** — this framework is being built incrementally while following a structured Playwright Java course. See the [Roadmap](#roadmap) section for what's implemented and what's coming next.

## Tech Stack

- **Language:** Java
- **UI Automation:** [Playwright for Java](https://playwright.dev/java/)
- **Test Runner:** TestNG
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA

## Current Features

- Basic browser lifecycle management using `@BeforeMethod` / `@AfterMethod`
- Login flow automation (navigate, fill form, submit)
- Assertions using both TestNG (`Assert`) and Playwright's web-first assertions (`assertThat`)
- Locator strategies: `getByPlaceholder`, `getByLabel`, `getByRole`

## Getting Started

### Prerequisites

- Java JDK 11+
- Maven
- IntelliJ IDEA (recommended)

### Installation

```bash
git clone https://github.com/<your-username>/PlaywrightFramework.git
cd PlaywrightFramework
mvn clean install
```

### Running Tests

```bash
mvn test
```

## Project Structure

PlaywrightFramework/
├── src/
│ └── test/
│ └── java/
│ └── BasicTest.java # Basic login automation test
├── pom.xml
├── .gitignore
└── README.md


## Roadmap

This framework is being built progressively. Planned additions include:

- [x] Basic Playwright + TestNG setup
- [x] Browser lifecycle via `@BeforeMethod` / `@AfterMethod`
- [ ] Assertions & advanced locator filters
- [ ] Custom wait strategies & complete E2E flows
- [ ] Browser contexts, child windows & Trace Viewer
- [ ] API automation testing (HTTP CRUD methods)
- [ ] Network interception & request mocking
- [ ] OOP principles for isolated, maintainable tests
- [ ] Page Object Model (POM) design pattern
- [ ] Data-driven testing with external data sources
- [ ] Parallel & grouped test execution with TestNG
- [ ] Maven-driven execution (profiles, command-line params)
- [ ] AI Agent integration (MCP)
- [ ] Allure reporting
- [ ] CI/CD pipeline integration

## Author

**Evans-QA**

## License

This project is for educational purposes as part of a self-paced learning course.
