# 💰 Finance Tracker

A command-line personal finance tracking application built in Java. Log your income and expenses, view summaries, filter by category, and sort transactions — all from the terminal.

---

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Key Concepts Practiced](#key-concepts-practiced)

---

## About the Project

Finance Tracker is a CLI-based Java application built as a learning project to practice core Java concepts including Object-Oriented Programming, data structures, exception handling, and file I/O. It allows users to manage personal transactions interactively through a text-based menu.

---

## Features

- ✅ Add income and expense transactions
- ✅ View all transactions
- ✅ View a financial summary (income, expenses, balance)
- ✅ Filter transactions by category
- ✅ Sort transactions by amount
- ✅ Input validation with custom exceptions
- ✅ Persistent storage — data saved to file between sessions

---

## Project Structure

```
FinanceTracker/
├── src/
│   └── main/
│       └── java/
│           └── com/financetracker/
│               ├── Main.java                        # Entry point & CLI menu
│               ├── models/
│               │   └── Transaction.java             # Transaction model + Category enum
│               ├── services/
│               │   └── TransactionService.java      # Business logic & data management
│               ├── utils/
│               │   └── FileManager.java             # File I/O (save & load)
│               └── exceptions/
│                   └── InvalidAmountException.java  # Custom exception
├── data.csv                                         # Auto-generated data file
├── pom.xml                                          # Maven build config
└── README.md
```

---

## Prerequisites

- Java 11 or higher
- Maven 3.x
- IntelliJ IDEA (recommended) or any Java IDE

---

## Getting Started

### 1. Clone or download the project

```bash
git clone https://github.com/yourusername/FinanceTracker.git
cd FinanceTracker
```

### 2. Build with Maven

```bash
mvn compile
```

### 3. Run the application

```bash
mvn exec:java -Dexec.mainClass="com.financetracker.Main"
```

Or simply press the **Run** button in IntelliJ.

---

## Usage

When you launch the app, you'll see the main menu:

```
===== Finance Tracker =====
1. Add Income
2. Add Expense
3. View All Transactions
4. View Summary
5. View by Category
6. View Sorted by Amount
7. Exit
Choose an option:
```

### Adding a Transaction

```
Please enter category [FOOD, RENT, SALARY, OTHER]:
> SALARY
Please enter amount:
> 3000
Enter date (YYYY-MM-DD):
> 2026-03-01
Enter description:
> Monthly pay
✓ Transaction added: [2026-03-01] income - SALARY: $3000.00 (Monthly pay)
```

### Viewing Summary

```
--- Summary ---
Total Income:   $3000.00
Total Expenses: $450.00
Balance:        $2550.00
```

### Valid Categories

| Category | Use for |
|----------|---------|
| `SALARY` | Employment income |
| `FOOD` | Groceries, dining |
| `RENT` | Housing costs |
| `OTHER` | Everything else |

---

## Key Concepts Practiced

| Concept | Where It's Used |
|---|---|
| OOP & Encapsulation | `Transaction` class with private fields and getters |
| Interfaces | `Comparable<Transaction>` for natural sort ordering |
| Enum | `Category` enum for valid transaction categories |
| Collections | `ArrayList<Transaction>` managed in `TransactionService` |
| Custom Exceptions | `InvalidAmountException` for input validation |
| Separation of Concerns | `Main` handles UI, `TransactionService` handles logic |
| File I/O | `FileManager` reads/writes `data.csv` for persistence |
| Exception Handling | `try-catch` blocks throughout for safe user input |

---

## What I Learned

This project was built to consolidate Java fundamentals after completing an introductory course. Key takeaways:

- **Programming to interfaces** — using `List<T>` instead of `ArrayList<T>`, implementing `Comparable<T>`
- **Layered architecture** — separating UI, business logic, and data concerns into distinct classes
- **Defensive programming** — validating all user input and handling errors gracefully without crashing
