# Banking System Using Java

This is a simple Banking System project made using Core Java and OOP concepts.

In this project, users can:

- Create accounts
- Deposit money
- Withdraw money
- Transfer funds
- View balance
- View transaction history
- Apply interest in savings account

This project is made for learning Object-Oriented Programming concepts in Java.

---

#  Project Structure

```text
BackAccount/
├── README.md

├── out/
│   ├── pack1/
│   │   ├── BankAccount.class
│   │   ├── SavingsAccount.class
│   │   ├── CheckingAccount.class
│   │   └── Transaction.class
│   │
│   └── pack2/
│       ├── BankingSystem.class
│       └── Main.class

└── src/
    ├── pack1/
    │   ├── BankAccount.java
    │   ├── SavingsAccount.java
    │   ├── CheckingAccount.java
    │   └── Transaction.java
    │
    └── pack2/
        ├── BankingSystem.java
        └── Main.java
```

---

#  Package Details

## pack1

This package contains all account-related classes.

### BankAccount.java

This is the parent/base class.

It contains:

```java
accountNumber
holderName
balance
```

Methods:

```java
deposit()
withdraw()
displayAccountInfo()
```

Concepts used:

- Abstraction
- Encapsulation

---

### SavingsAccount.java

Child class of BankAccount.

Extra feature:

```java
interestRate
```

Functions:

- Deposit money
- Withdraw money
- Apply interest

Concepts used:

- Inheritance
- Method Overriding

---

### CheckingAccount.java

Another child class of BankAccount.

Extra feature:

```java
overdraftLimit
```

Allows withdrawal with overdraft limit.

---

### Transaction.java

Stores transaction details.

Example:

```text
Deposit : ₹1000
Withdraw : ₹500
```

---

# 📦 pack2

Contains main system files.

---

### BankingSystem.java

Main logic of project.

Handles:

- Create account
- Deposit
- Withdraw
- Transfer money
- View transactions
- Display accounts

---

### Main.java

Starts the project.

```java
public static void main(String[] args)
```

---

#  OOP Concepts Used

| Concept | Used In |
|---|---|
| Abstraction | BankAccount |
| Encapsulation | private variables |
| Inheritance | SavingsAccount, CheckingAccount |
| Polymorphism | BankAccount reference |
| Method Overriding | deposit(), withdraw() |

---

#  Important Arrays

## Account Array

```java
BankAccount[] accounts
```

Stores all accounts.

---

## Transaction Array

```java
Transaction[][] transactions
```

Stores transaction history.

---

# ▶ How To Compile

```bash
javac -d out src/pack1/*.java src/pack2/*.java
```

---

# ▶ How To Run

```bash
java -cp out Main
```

---

#  Features

 Create Account  
 Deposit Money  
 Withdraw Money  
 Transfer Funds  
 View Balance  
 View Transactions  
 Apply Interest  
 Display All Accounts  

---

#  Example

## Create Account

```text
Enter Name : Menika
Enter Account Number : 12345
Enter Deposit : ₹5000
```

---

## Deposit Money

```text
Enter Amount : ₹1000
```

Output:

```text
Deposited ₹1000 successfully!
```

---

# 📖 What I Learned

Through this project I learned:

- Core Java
- OOP Concepts
- Packages
- Arrays of Objects
- Inheritance
- Polymorphism
- Method Overriding
- Real-world project structure

---

#  Future Improvements

- File Handling
- Database Connection
- Login System
- GUI using Java Swing----
- ATM Features

---

#  Made By

Menika Kumari