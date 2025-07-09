# Student Management System

The **Student Management System** is a console-based application built using **Core Java**, **JDBC**, and **PostgreSQL**. It allows users to perform CRUD (Create, Read, Update, Delete) operations on student records stored in a PostgreSQL database. The application is fully menu-driven, features multithreading for logging actions, and ensures strict input validation for data integrity.

---

## Features

- Add, View/Read , Update and Delete student records
- Multithreaded logging with timestamps saved to `.log` file
- Validates fields like email, phone, marks, and name
- Menu-driven interface for smooth user experience
- Clean project structure using OOP and DAO principles
- Uses Maven for build and dependency management

---

## Technologies Used

- **Java 17**
- **PostgreSQL 15+**
- **JDBC 4.2**
- **Apache Maven 3.8.6+**
- **Multithreading & File I/O**

---

## Dependency

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.7</version>
</dependency>
```

---

## Prerequisites

Ensure the following are installed:

- **Java JDK 17+**
- **Apache Maven 3.8.6+**
- **PostgreSQL 15+**

---

## Database Setup

1. Create a Database

- **CREATE DATABASE studentdb;**

2. Create a Table

- **CREATE TABLE students (id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL, course VARCHAR(100) NOT NULL, marks INT NOT NULL, email VARCHAR(100), phone VARCHAR(20));**

---

## Project Structure

- com/shubham/student/
  ├── Student.java # Model/POJO class
  ├── StudentDAO.java # JDBC-based DAO class
  ├── DBLogger.java # Threaded logger to .log file
  └── MenuApp.java # Console-based UI and main logic

---

## How to Run

1. **Clone the repository or download the code.**
2. **Open the project in VS Code, IntelliJ, or Eclipse.**
3. \*\*In StudentDAO.java, configure your DB credentials:
   1. private static final String URL = "jdbc:postgresql://localhost:5432/studentdb";
   2. private static final String USER = "postgres";
   3. private static final String PASSWORD = "yourpassword";\*\*
4. **Build the project:
   mvn clean install**
5. **Run MenuApp.java.**

---

## Log Output

- \*\*Logs are saved in student-actions.log with timestamps like:

[2025-07-09 14:21:43] Added student: Ramesh Kumar
[2025-07-09 14:22:01] Deleted student ID: 3
Logging is done on a separate thread so it doesn't interrupt user interaction.\*\*

---

## Input Validations

- **Name: Cannot be empty**
- **Course: Cannot be empty**
- **Marks: Must be between 0 and 100**
- **Email: Must match email pattern**
- **Phone: Must be 10-digit number**
- **ID: Must be a positive integer**

---

## Contact

- **Developer: Shubham Santosh Masali**
- **Email: shubhammasali76@gmail.com**
- **GitHub: Shubham-Masali76**

---

## Code Image for Reference

- ![image alt] (https://github.com/Shubham-Masali76/Student-Management-System/blob/07f08ccd2e7a1c7367ef03af8c69da65b96a677e/Screenshot%20(1).png)

- **Feel free to fork this project and make it your own. Contributions, suggestions, and ideas are always welcome!**

** Happy Coding **
