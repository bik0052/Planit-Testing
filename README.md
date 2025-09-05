# Planit Automation Assessment

This project is a Selenium + Maven + TestNG framework built for the **Planit Technical Assessment – Automation**.

## Features
- Selenium WebDriver (Chrome, Firefox, Edge)
- TestNG framework
- ExtentReports (HTML report: `target/TestReport.html`)
- Configurable via `src/main/resources/config.properties`
- CI/CD ready (GitHub Actions, Jenkinsfile)

## Running Locally
```bash
mvn clean test
```
Report will be generated at `target/TestReport.html`.

## GitHub Actions
- Workflow is already included in `.github/workflows/ci.yml`
- Runs tests headless in Chrome
- Uploads HTML report as artifact

## Jenkins
- `Jenkinsfile` provided
- Runs `mvn clean test` and archives report

## Disclaimer
This solution uses **open-source Selenium, TestNG, ExtentReports**. No COTS tools used.
