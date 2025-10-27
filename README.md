# Java API Testing Homework — E2E User Onboarding Flow

A **complete end-to-end (E2E) API test suite** for a banking/fintech backend system using **Java**, **JUnit 5**, and **RestAssured**.

This project simulates a **real user journey**:
1. Register a new user
2. Set personal data (KYC)
3. Add funds via bank transfer
4. Verify updated balance
5. Confirm transaction in payments history

Uses **session-based authentication** (`JSESSIONID` cookie) and **POJO mapping** for clean, type-safe assertions.

**Tests are running against this backend**: [https://github.com/Newton-Capital/qa-homework](https://github.com/Newton-Capital/qa-homework)  
(A Spring Boot API with user registration, personal data, funds, balance, and payments features, using H2 in-memory DB and Swagger docs.)

---

## Tech Stack

- **Java 11+**
- **Maven**
- **JUnit 5**
- **RestAssured** (for HTTP + JSON)
- **Jackson** (JSON to POJO)

---

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Local backend API running at:  
  `http://localhost:8080`

---

## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/NikitaRomanovsky/java-api-homework.git
   cd java-api-homework
2. **Install dependencies**
    ```bash
    mvn clean install
4. **Start your backend API on localhost:8080**

## Running the Tests
  ```bash
  mvn test
