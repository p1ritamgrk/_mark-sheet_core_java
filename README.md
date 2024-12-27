# Mark Sheet Management System

## Overview
The **Mark Sheet Management System** is a simple console-based application developed using Core Java. It enables users to manage student mark sheets by performing CRUD operations such as adding, viewing, and deleting mark sheets. The system calculates results, determines pass/fail status, and assigns a division based on student performance.

## Features
- **Add Mark Sheet**: Input student details and marks for subjects.
- **View Mark Sheet**: View detailed mark sheets for specific students using their roll numbers.
- **Delete Mark Sheet**: Remove a student's mark sheet from the system.
- **Result Calculation**:
  - Calculate the percentage and determine pass/fail status.
  - Assign divisions (Pass, First Division, Distinction).

## Requirements
- **Java Development Kit (JDK)** version 8 or above

## How to Run
1. Clone this repository:
   ```bash
   git clone git@github.com:p1ritamgrk/_mark-sheet_core_java.git
   ```
2. Compile the Java files:
   ```bash
   javac MarkSheet.java MarkSheetManager.java
   ```
3. Run the application:
   ```bash
   java MarkSheetManager
   ```

## Classes and Methods

### Class: `MarkSheet`
This class represents the student’s mark sheet.

#### Attributes
- `String name`: Student's name.
- `int rollNumber`: Unique roll number of the student.
- `int scienceMark`: Marks obtained in Science.
- `int mathMark`: Marks obtained in Math.
- `int socialMark`: Marks obtained in Social Studies.
- `int nepaliMark`: Marks obtained in Nepali.
- `int englishMark`: Marks obtained in English.

#### Methods
- `public boolean isAllSubjectPass()`: Checks if the student passed all subjects.
- `public double getPercentage()`: Calculates the percentage of marks obtained.
- Getter and Setter methods for all attributes.

### Class: `MarkSheetManager`
This class handles the operations related to mark sheets.

#### Methods
- `public void addMarkSheet(MarkSheet markSheet)`: Adds a new mark sheet to the list.
- `public void viewMarkSheet(int rollNumber)`: Displays the mark sheet of a student with the given roll number.
- `public void deleteMarkSheet(int rollNumber)`: Deletes the mark sheet of a student with the given roll number.
- `private static MarkSheet grabStudentDetails(Scanner scanner)`: Collects student details and marks from user input.
- `private static int grabIntegerRelatedInfo(Scanner input, String type)`: Validates and captures integer inputs (e.g., marks, roll number).

## Example Mark Sheet Output
```
			Academia International College
				Gwarko, Lalitpur
					9800000000

Class : X
Name : John Doe
Roll No : 101
---------------------------------------------------|
Subject		 | FM		 | PM		 | OM|
---------------------------------------------------|
Science		 | 100		 | 32		 | 85
---------------------------------------------------|
Maths		 | 100		 | 32		 | 90
---------------------------------------------------|
Social		 | 100		 | 32		 | 80
---------------------------------------------------|
Nepali		 | 100		 | 32		 | 75
---------------------------------------------------|
English		 | 100		 | 32		 | 88
---------------------------------------------------|
Result : PASS
Division : DISTINCTION
Percentage : 83.6
```

## Code Structure
```
MarkSheet.java          # Defines the MarkSheet class
MarkSheetManager.java   # Manages mark sheets and handles user interactions
```

## Author
- **Pritam Shrestha**
  - Version: 1.0
  - Date: 2024-12-27

## License
This project is open-source and free to use.

