# Farmers Market Inventory System

## About 

This is a small OOP-focused Java project simulating a farmers market with multiple stands and produce management. It demonstrates class relationships, unit testing with JUnit 5, and basic inventory logic.


## Requirements

### Design and code a class system that represents produce available at a farmer’s market. There should be at least 5 varieties of fruit or vegetables that are sold overall.

- A farmer’s market has different stands
    - Each stand has a farmer
    - Each stand has a supply of fruits and vegetables.
- The classes should allow a user to build a farmer’s market and create a certain number of stands.
    - Then a user can assign a farmer and fruit/vegetables to a stand
- It also allows you to access each farmer and their list of produce.

### Bonus

- The market has search capabilities to find a specific piece of produce and return a list of Farmers providing along with their location in the market.
- Buying produce reduces counts, which are then reflected accurately in the search.

## Environment Setup

I set up the coding environment in VS Code, for the JUnit tests I used the JUnit 5 library. I downloaded [junit-platform-console-standalone-1.13.4.jar](https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.13.4/) and manually placed it in the `lib` folder. The `build_and_run.sh` script compiles the Java files and runs the main class.

## Progress Log

- 7/29/2025 6:30 pm 
    - set up coding environment in VS Code

- 7/29/2025 7:00 pm 
    - basic scaffolding of the project
    - implemented Produce class

- 7/29/2025 7:20 pm 
    - implemented Tomato, Carrot, Orange, Lettuce classes (VS code is a disaster for java, if I put everything in src/ it will show normal editing, but if I put it in a subfolder, it will show red squiggles everywhere)

- 7/29/2025 7:45 pm 
    - implemented test unit for Produce class
    - concrete produce classes

- 7/30/2025 11:20 am 
    - implemented Farmer class
    - added Test unit for Farmer class

- 7/30/2025 12:00 pm 
    - implemented Stand class
    - added Test unit for Stand class

- 7/30/2025 12:30 pm 
    - refactored Stand toString method and its test unit
    - refactored Produce toString method and its test units

- 7/30/2025 2:30 pm 
    - implemented Market class
    - added Test unit for Market class

- 7/30/2025 3:00 pm 
    - refactored all produce classes and the abstract Produce class to a package `produce`, reran all tests

- 7/30/2025 3:30 pm 
    - implemented App class with main method
    - added displayMarket method to print market information

- 7/31/2025 9:45 am 
    - added user interaction with the app
    - view market info
    - create a stand with farmer but no produce functionality yet
    - and exit

- 7/31/2025 12:00 pm 
    - user can now add produce to a new stand

- 7/31/2025 6:30 pm 
    - refactored user input handling and validation into Util class, getStringInput, getIntInput, and getDoubleInput methods

- 7/31/2025 9:50 pm 
    - resolved issue with duplicate produce in the same stand during stand creation

- 7/31/2025 10:15 
    - implemented integration test for complete market creation

- 7/31/2025 10:30 pm 
    - scaffolded stand removal, visit a stand, and search for produce functionality

- 7/31 11:00 pm 
    - implemented stand removal by index, added test cases for stand removal 
    - beautified invalid user input feedback

- 8/1 TODO: 
    - implement visit a stand functionality
        - add produce to a stand
        - remove produce from a stand
    - implement search for produce functionality
    