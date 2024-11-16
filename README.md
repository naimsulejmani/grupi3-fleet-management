# Fleet Management System

## Overview
This project is a Fleet Management System built using Java Spring Boot. It allows users to manage a fleet of vehicles, including tracking vehicle information, maintenance schedules, and driver assignments.

## Features
- Vehicle management
- Driver management
- Maintenance scheduling
- Reporting and analytics

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Thymeleaf
- HTML/CSS/JavaScript
- PostgreSQL

## Prerequisites
- Java 11 or higher
- Maven
- PostgreSQL

## Setup Instructions

1. **Clone the repository:**
    ```sh
    git clone <repository-url>
    cd grupi3-fleet-management
    ```

2. **Configure the database:**
    - Create a PostgreSQL database.
    - Update the `application.properties` file in `src/main/resources` with your database configuration.

3. **Build the project:**
    ```sh
    mvn clean install
    ```

4. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```

5. **Access the application:**
    - Open your browser and go to `http://localhost:8080`.

## License
This project is licensed under the MIT License.