# SPBootH2

## 🧑‍🎓 Student Database with H2 Integration using Spring Boot

This project demonstrates a lightweight Student Management System using **Spring Boot** and **H2 Database**.

### 🔍 Overview
- Uses **in-memory H2 Database** to store student and subject data.
- Eliminates the need for external DB software.
- Perfect for lightweight, embedded use-cases where setup time and memory consumption must be minimal.

### 🗃️ Features
- Students table stores roll number, full name, and city.
- Three separate subject tables: **Mathematics**, **Physics**, and **Chemistry**.
- Each subject table references the student table via **foreign key (roll number)**.
- Data persists internally during application runtime.
- Tables are auto-created using `schema.sql` and pre-filled with `data.sql`.

### 🧪 Tech Stack
- **Java 17+**
- **Spring Boot 3**
- **H2 Database (in-memory)**
- **Spring JDBC Template**
- **Maven**

---

### 🧠 Future Improvements
- Add CRUD operations for subject marks.
- Integrate REST APIs with DTOs and error handling.
- Persist data beyond runtime using file-based H2 mode.
