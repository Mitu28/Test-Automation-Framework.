Test Automation Framework
This Java-based Test Automation Framework is designed for web application testing.

It supports data-driven testing, cloud execution, and headless mode for efficient test execution.

The framework integrates LambdaTest for cloud testing, Maven Surefire Plugin for CLI-based execution, Extent Reports for reporting, and Log4j for logging.

Author
Mitu28
EmailAddress:mitukumari2024@gmail.com

🔗 Links
portfolio

linkedin

🚀 About Me
Hi,My Name is Mitu Kumari.I have 7 years of Experience in Automation and Manual Testing using technologies like Selenium Webdriver,RestAssured,Postman

My major expertise is in Java Programming language .

Test Automation Framework
This Java-based Test Automation Framework is designed for web application testing.

It supports data-driven testing, cloud execution, and headless mode for efficient test execution.

The framework integrates LambdaTest for cloud testing, Maven Surefire Plugin for CLI-based execution, Extent Reports for reporting, and Log4j for logging.

Acknowledgements
Awesome Readme Templates
Awesome README
How to write a Good readme
Prerequisites
Before running the tests, ensure you have the following installed:

Java 11 (Ensure JAVA_HOME is set correctly)

Maven (For dependency management and test execution)

Download Link: https://maven.apache.org/download.cgi

Git (To clone the repository)

Chrome/Firefox browser (Required for local execution)

Features
Java 11-based testing framework.

Selenium WebDriver for UI automation.

TestNG for test execution and assertions.

Data-driven testing using OpenCSV, Gson, and Apache POI (supports CSV, JSON, and Excel).

Fake data generation using the Faker library.

Cloud execution via LambdaTest (for cross-browser testing).

Headless mode for faster test execution.

Maven Surefire Plugin for CLI-based execution with custom parameters.

Logging using Log4j (logs stored in the log folder).

Reports generated using Extent Report(reports.html)

Technology Used
Java 11
Selenium
TestNG
Maven
OpenCSV
Gson
Apache POI
Faker
LambdaTest
Maven Surefire Plugin
Extent Reports
Log4j
Installation
Clone the repository using Git:

 git clone https://github.com/Mitu28/Test-Automation-Framework..git
 cd Test-Automation-Framework
 Running Tests on LambdaTest Cloud

mvn  test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
Running Tests on Chrome browser on Local Machine in Headless Mode

mvn  test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X
Reporting & Logs
After test execution:

Extent Report Path: ./report.html

Open it in a browser to view detailed test execution results.

Log4j Logs
Path: log/

Stores execution logs to help debug failures.

Integrated the project with Github actions
This automation framework is integrated with github actions The test will be executed at 11:30 pm IST every single day.

The reprts will be archived in gh-pages. You can view the html reports at https://github.com/Mitu28/Test-Automation-Framework/report.html
