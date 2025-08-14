**Employee Database App – Java JDBC**

Build a Java application that connects to a MySQL/PostgreSQL database and performs full CRUD operations (Create, Read, Update, Delete) on an employee table using JDBC.

---

Tools & Technologies

- Java
- IntelliJ Community Edition
- MySQL Workbench
- JDBC Driver

---

Project Structure

Employee Database App

- DBConnection.java       - Handles DB connection and contains CRUD logic
- emp.java                - main method 
- README.md               - Project documentation

---

Setup Instructions

Database Setup
**mysql workbench**

- CREATE DATABASE Employee;
- CREATE TABLE employee_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    dept VARCHAR(50),
    salary DOUBLE
);

- Add JDBC Driver
- Download MySQL Connector/J from MySQL Downloads (The Jar file I have used - mysql-connector-j-9.4.0)
- Add the JAR to your project classpath.
- Run the App
- Compile and run emp.java
- Use the menu to add, view, update, or delete employee records.

---

Key Concepts Covered

- JDBC Connection
- PreparedStatement vs Statement
- SQL Exception Handling
- Preventing SQL Injection
- DriverManager, ResultSet, Auto-commit

---

Sample Output

DB Connected successfully!

--- Employee Database App ---
1. Add Employee
2. View All Employees
3. Update Employee
4. Delete Employee
5. Exit

Enter choice: 

---

Screenshots

<img width="1913" height="1019" alt="Screenshot 2025-08-14 202925" src="https://github.com/user-attachments/assets/16838aea-9266-42ba-b57d-63f0ac5a43bd" />

<img width="1638" height="1015" alt="Screenshot 2025-08-14 202951" src="https://github.com/user-attachments/assets/f6400b0f-f78d-4964-b2c1-c72fddfae081" />

<img width="1189" height="992" alt="Screenshot 2025-08-14 203020" src="https://github.com/user-attachments/assets/780daa6d-7a71-4b74-b115-21bd1df73957" />

---

 Author
- Aashi Vishwakarma

  Java Developer | Database Enthusiast
- Email: aashivishwakarma1121@gmail.com

