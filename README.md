# Java Contact Manager

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![Data Structures](https://img.shields.io/badge/Data_Structures-Linked_List-brightgreen?style=for-the-badge)

A robust, in-memory Contact Management System built entirely with Java and Swing. Designed with a focus on custom data structures, it uses a custom-built Linked List for efficient data storage and manipulation without relying on standard Java Collections.

The system provides a clean graphical user interface (GUI) to manage contacts, featuring real-time input validation and multiple sorting algorithms.

## 🚀 Features

- **Add Contacts**: Store contact details including Name, Phone Number, Company, Salary, and Birthday.
- **Smart Validation**: 
  - Phone numbers must be 10 digits starting with '0'.
  - Salaries must be positive values.
  - Complex birthday validation including leap year calculations.
- **Search & Update**: Instantly find contacts by Name or Phone Number and update their information.
- **Delete Contacts**: Remove obsolete contacts from the system securely.
- **Advanced Sorting & Viewing**:
  - View all contacts in a tabular format.
  - Sort contacts alphabetically by **Name**.
  - Sort contacts numerically by **Salary**.
  - Sort contacts chronologically by **Birthday**.

## 🛠️ Tech Stack

- **Language**: Java (JDK 8+)
- **GUI Framework**: Java Swing & AWT
- **Data Structures**: Custom Linked List implementation (`ContactList.java`)
- **Architecture**: MVC-inspired pattern separating UI (Views) from Logic (`ContactController`) and Data (`Contact`).

## 📂 Folder Structure

```text
📦 JavaContactManager
 ┣ 📂 src               # Java source code files
 ┃ ┣ 📜 Start.java          # Main entry point
 ┃ ┣ 📜 MainWindow.java     # Home page UI
 ┃ ┣ 📜 Contact.java        # Contact model class
 ┃ ┣ 📜 ContactList.java    # Custom Linked List implementation
 ┃ ┣ 📜 ContactController.java # Business logic and sorting algorithms
 ┃ ┗ 📜 ...                 # Other UI components (Add/View/Update/Delete)
 ┣ 📂 resources         # Static assets (Images, Icons)
 ┣ 📂 bin               # Compiled .class files (ignored in git)
 ┗ 📜 README.md         # Project documentation
```

## ⚙️ How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/JavaContactManager.git
   cd JavaContactManager
   ```

2. **Compile the source code**:
   ```bash
   javac -d bin src/*.java
   ```

3. **Run the application**:
   ```bash
   java -cp bin Start
   ```

## 🧠 Under the Hood

Instead of using `java.util.ArrayList` or `java.util.LinkedList`, this project implements a **custom Linked List** from scratch. 

```java
class ContactList {
    private Node start;
    // Custom methods: add(), remove(), get(), size(), searchByNameOrPhoneNumber()
}
```
Sorting algorithms (Bubble Sort) are implemented manually to sort the custom linked list based on different object attributes, demonstrating a strong understanding of fundamental data structures and algorithms.

---
*Built with ❤️ for learning and mastering Java GUI and Data Structures.*
