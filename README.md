# Stock Management System

A Spring Boot application for managing products with user authentication and stock monitoring.

## Features

-  **User Authentication**
    - Secure login and registration
    - Password encryption
    - Session management

-  **Dashboard**
    - Total products count
    - Total stock value
    - Low stock warnings

-  **Product Management**
    - Add new products
    - Update product details
    - Track stock levels

-  **Stock Alerts**
    - Low stock warnings
    - Critical stock notifications
    - Visual status indicators

## Tech Stack

- **Backend**
    - Spring Boot 3.x
    - Spring Security
    - Spring Data JPA
    - MySQL Database

- **Frontend**
    - Thymeleaf
    - Bootstrap 5
    - JavaScript
    - HTML5/CSS3

## Prerequisites

  - Java 17 or higher
  - MySQL 8.0 or higher
  - Maven 3.6 or higher

## Installation

1. Clone the repository:
   git clone https://github.com/yourusername/stock-management.git


2. Configure MySQL:
   - Create a database named `stock_management`
   - Update `application.properties` with your database credentials

4. Run the application

5. Access the application:
   - Open `http://localhost:8080` in your browser

## Configuration

The application can be configured through `application.properties`:

# Database Configuration
<pre>
spring.datasource.url=jdbc:mysql://localhost:3306/stock_management
spring.datasource.username=your_username
spring.datasource.password=your_password
</pre>

## Project Structure

<pre>
    src/main/java/org/xproce/produitexample/
    ├── dao/
    │   ├── entities/
    │   └── repositories/
    ├── metier/
    ├── security/
    ├── web/
    └── ProduitexampleApplication.java
</pre>
