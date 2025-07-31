# 🧑‍🎓 SPBootH2  
**Student Management System with H2 Database Integration using Spring Boot**

A lightweight Spring Boot application that demonstrates how to manage student and subject records using an embedded, in-memory H2 database. Ideal for rapid prototyping or scenarios where external DB dependencies are undesirable.

---

## 🔍 Overview
- Integrates **H2 Database** in-memory mode for seamless runtime operations.
- **No need for external DB software**—the database runs internally, reducing system footprint and simplifying deployment (especially useful when building `.jar` files).
- Focuses on efficient schema management and data retrieval using **Spring JDBC Template**.
- Mimics a real-world academic record system by separating concerns via normalized relational tables.

---

## 🗃️ Features
- **Student Table**: Stores `roll number`, `full name`, and `city`.
- **Subject Tables**: Includes `mathematics`, `physics`, and `chemistry`—each linked to the student table using a **foreign key (roll number)**.
- **Auto Schema Setup**: Tables are auto-generated using `schema.sql` and populated using `data.sql`.
- **Data Persistence**:  
  - Runtime data is saved back to `data.sql` using **Java FileWriter**, enabling simulated persistence across application restarts.
  - Real-time changes are also logged to a separate `changes.txt` file for auditability.
- **Modular Design**: Subject tables are independent and can be extended or modified with minimal changes.

---

## 🧪 Tech Stack
- Java 17+
- Spring Boot 3
- H2 Database (In-Memory)
- Spring JDBC Template
- Maven

---

## 🧠 Future Enhancements
- Implement full **CRUD operations** for subject marks.
- Expose functionality via **REST APIs** with DTO mapping and exception handling.
- Enable persistent storage using **file-based H2 mode** for true long-term data retention.
