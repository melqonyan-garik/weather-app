# Spring Boot Weather Application

Greetings! Welcome to the Spring Boot Weather Application – your reliable tool for fetching weather data based on zip codes or city names from a third-party API.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Getting Started](#getting-started)
3. [Configuration](#configuration)
4. [Build and Run](#build-and-run)
5. [Endpoints](#endpoints)
6. [Testing](#testing)
7. [Code Coverage](#code-coverage)
8. [Code Quality](#code-quality)
9. [Deployment](#deployment)
10. [Conversation Logs](#conversation-logs)
11. [Project Feedback](#project-feedback)
12. [Contributing](#contributing)
13. [License](#license)

## Prerequisites

Ensure you have the following essentials:

- Java Development Kit (JDK) installed (version X.X or higher)
- Maven build tool installed
- API key from the third-party weather API provider

## Getting Started

### Configuration

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/spring-boot-weather-app.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd spring-boot-weather-app
    ```


### Build and Run

Using Maven:

```bash
mvn clean install
mvn spring-boot:run
```
## Endpoints

### GET /weather

Retrieves weather data based on either zip code or city name.

**Query parameters:**

- `zipCode` (optional): The zip code for weather data.
- `city` (optional): The name of the city for weather data.

**Example:**

```bash
curl -X GET "http://localhost:8080/weather?zipCode=12345"
```
## Testing

Run the unit tests with the following command:

**Using Maven:**

```bash
mvn test
```
## Code Coverage

Generate code coverage reports with the following command:

**Using Maven:**

```bash
mvn clean test jacoco:report
```

## **Code Quality**

Analyze code quality using SonarQube. Ensure you have a SonarQube server set up.

**Using Maven:**

```bash
mvn clean verify sonar:sonar
```
## Conversation Logs

ChatGPT conversation logs are available in the file [chat.log](src/main/resources/chat.log).
Conversation link: https://chat.openai.com/share/14ad5257-e7da-4148-b465-b63d4c138c10

# Project Feedback

- **Was it easy to complete the task using AI?**
    - Absolutely, leveraging AI made the task significantly more straightforward.

- **How long did the task take you to complete?**
    - The task was completed in approximately 1 hour.

- **Was the code ready to run after generation? What did you have to change to make it usable?**
    - The generated code was ready to run; I made minor adjustments to the readme for clarity.

- **Which challenges did you face during completion of the task?**
    - The primary challenge revolved around formulating questions in a manner that AI could understand, leading to satisfactory responses.
## Deployment

Deploy the application to a server or a cloud platform. Ensure that the necessary environment variables and configurations are set.

## Contributing

Contributions are more than welcome! Fork the repository, create a branch, make your changes, and submit a pull request.