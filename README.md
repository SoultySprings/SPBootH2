# 🎓 MarkMate
<pre lang="text"><code> 
    __  ___           __   __  ___      __     
   /  |/  /___ ______/ /__/  |/  /___ _/ /____ 
  / /|_/ / __ `/ ___/ //_/ /|_/ / __ `/ __/ _ \
 / /  / / /_/ / /  / ,< / /  / / /_/ / /_/  __/
/_/  /_/\__,_/_/  /_/|_/_/  /_/\__,_/\__/\___/ 
</code></pre>

A lightweight **Spring Boot** application that enables dynamic management of students and their academic records using an embedded, in-memory **H2 database**. Tailored for rapid development with minimal system dependencies, this version introduces subject flexibility and persistent schema tracking.

---

## 💡 Introduction


---

## 🔍 Overview

- Uses an **embedded H2 database** for runtime operations with no external DB software required.
- Ideal for `.jar` deployments and lightweight environments where memory and dependencies must be minimized.
- Designed to **simulate a real-world academic system**, supporting dynamic schema creation.
- User-driven architecture: both student data and subject tables are defined at runtime.

---

## 🗃️ Features

- **Student Table**  
  - Stores basic student information: `roll number`, `full name`, and `city`.
  - Auto-generated at runtime using `schema.sql`.

- **Dynamic Subject Tables**  
  - Users can create any number of **custom subject tables** during execution.
  - Each subject table contains `subjectID` (foreign key to `student.rollno`) and `marks`.
  - The structure of each new subject table is written to a **dedicated `subjectlist.sql`** file, ensuring persistence of schema definitions.

- **Data Persistence**  
  - Student and marks data are saved back to `data.sql` using **Java FileWriter**.
  - Created subject schemas are written to `subjectlist.sql` to ensure they are loaded on subsequent runs.
  - All database changes are also logged to `changes.txt` for traceability.

- **Lightweight Console UI**  
  - Intuitive menu-driven switch-case interface for all operations.
  - Timestamps displayed for tracking session context.

---

## 🧪 Tech Stack

- Java 17+
- Spring Boot 3
- H2 Database (In-Memory)
- Spring JDBC Template
- Maven

---

## 🧠 Future Enhancements

- ✅ Implement full **CRUD operations** for all dynamically added subjects.
- ✅ Support **custom subject deletion** with table removal.
- 🔄 Enable persistent storage using **file-based H2 mode** (instead of purely in-memory).
- 🌐 Expose all functionality via **REST APIs** with DTO mapping, validation, and exception handling.
- 📊 Add report generation and statistics for student performance.

---

## 🗂️ Version History

- **v1.0** – Basic student table with fixed subject tables (`math`, `physics`, `chemistry`)
- **v2.0** – Integration with H2 DB, schema.sql/data.sql structure
- **v3.0** – Java FileWriter-based persistence
- **v4.0** – 🔥 Major overhaul:  
  - Subject tables are now **user-defined**, dynamically created at runtime  
  - Changes saved to `changes.txt`
  - New tables added to `subjectlist.sql` to keep track and contradict extra creta  
  - No hardcoded subject logic — truly flexible structure  
  - Added ASCII banner branding and log support

---

## 🧾 Sample Files Generated

- `schema.sql` — creates core student table.
- `data.sql` — stores runtime-added students and marks.
- `subjectlist.sql` — stores schema for each user-added subject table.
- `changes.txt` — logs of data and schema updates.

---

## 🔒 License

This project is released under the [MIT License](https://opensource.org/licenses/MIT).

---

## 👤 Author

**SoultySprings**

---
