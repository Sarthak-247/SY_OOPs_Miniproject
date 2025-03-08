Pharmacy Management System
Overview
The Pharmacy Management System is a Java-based console application designed to manage pharmacy inventory. It provides functionalities to add new medicines, update existing stock, sell medicines, display current stock, and persist data to a file (stock.txt).

Features
Display Stock: View a list of all available medicines with their name, price, and quantity.
Add Medicine: Add new medicines to the inventory.
Update Medicine Stock: Update the quantity of an existing medicine.
Sell Medicine: Deduct sold quantities from the stock.
Data Persistence: Load and save inventory data to/from a file, ensuring data is retained between program executions.
Requirements
Java Development Kit (JDK) 8 or above.
A terminal or command prompt to run the application.
How to Run
Compile the Code:
Open your terminal, navigate to the project directory, and run:
bash
Copy
Edit
javac project.java
Run the Application:
Execute the compiled program with:
java project
Follow the On-Screen Menu:
The program will present a menu with options to display stock, add new medicine, update stock, sell medicine, save stock, or exit the application.
Code Structure
Medicine Class:
Represents a medicine with attributes such as name, price, and quantity. It includes a method to format medicine details into a CSV string for file storage.

Pharmacy Class:
Manages a list of Medicine objects and handles the core operations:

loadStockFromFile(): Reads inventory data from stock.txt.
displayStock(): Displays the current stock.
addStock(): Adds a new medicine to the inventory.
updateStock(): Updates the quantity of an existing medicine.
sellStock(): Processes the sale of a medicine by reducing its quantity.
savetofile(): Saves the current inventory to stock.txt.
project Class (Main):
Contains the main method that drives the application. It provides a menu-driven interface for the user to interact with the inventory management system.

File Structure

├── project.java   # Main Java source file containing the application code.
├── stock.txt      # File used for saving and loading stock data (created automatically if not present).
└── README.md      # This file.


License
This project is open source and free to use. Feel free to modify and distribute it as needed.

Author
Sarthak Deochake

Acknowledgments
This project demonstrates basic object-oriented programming (OOP) concepts in Java while providing a practical example of inventory management.

Enjoy managing your pharmacy stock!
