# ByteMeDeli 🥪
ByteMeDeli is a Java-based CLI application that simulates a point-of-sale (POS) system for a sandwich shop. Users can build their own sandwiches, choose signature combos, add drinks or chips, and check out with a detailed receipt.
---
## 📦 Features
+ Create custom sandwiches (size, bread, toast, toppings)
+ Choose signature sandwiches (e.g., BLT, Philly Cheese Steak)
+ Add premium and regular toppings (with extra option and pricing)
+ Select drinks by size
+ Choose chips (salted or unsalted)
+ View order summary and auto-generated receipt
+ Input validations and back-to-menu flow
+ Supports receipt file saving in `/resources/receipts`
+ Rich CLI experience with icons, prices, and color styling
---
## 🛠 Technologies Used
+ Java 17
+ OOP (Inheritance, Abstraction, Polymorphism)
+ Streams API
+ File I/O
+ Scanner input handling
+ Git & GitHub for version control
---
## 📸 Screenshots
### 🏠 Home Screen
![Home Screen](src/main/resources/screenshots/Home_screen.png)
### 🥖 Sandwich Builder
![Sandwich Menu](src/main/resources/screenshots/menu.png)
### 🧀 Premium Toppings
![Premium Toppings](src/main/resources/screenshots/premium_topping.png)
### 🍟 Chips & 🥤 Drinks
![Select Chips](src/main/resources/screenshots/select_chips.png)  
![Select Drink](src/main/resources/screenshots/select_drink.png)
### ⭐ Signature Sandwiches
![Signature Sandwich](src/main/resources/screenshots/signature_sandwich.png)
### 📋 Receipt
![Receipt]src/main/resources/screenshots/receipt.png)
---
## 🧠 Design Notes
+ Uses a flexible data model (`Topping`, `Sandwich`, `Order`) for scalability.
+ `ToppingData` manages regular vs premium toppings, sizes, and extra pricing.
+ Follows clean code practices and single responsibility principle.
---
## 📁 Folder Structure
src
├── main
│   ├── java
│   │   └── com.pluralsight
│   │       ├── models
│   │       ├── data
│   │       └── ui
│   └── resources
│       ├── receipts
│       └── screenshots

## 🧪 Testing
Unit testing has been added to validate core functionality. Tests cover:
+ ✅ Sandwich price calculation (including regular, premium, and extra toppings)
+ ✅ Order total calculation using all item types (sandwich, drink, chips)
+ 🚧 Additional tests like empty order, summary output, and edge cases can be added
⸻
✅ How to Run
1. Clone the repo
2. Open in IntelliJ (or any IDE)
3. Run ByteMeDeliApp.java
4. Follow the CLI prompts to place your order
⸻
🧾 License
Created by Eyob Mengistu – 2025
