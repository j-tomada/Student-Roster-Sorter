# Student Roster Sorter

Author: Joseph Tomada

Approximate time to complete: 2 weeks

This was a school assigned project designed for students to create whatever they wish provided they follow certain conditions. This program serves as a basic way for teachers to organize a list of students and see which among them are performing better than others. This is accomplished via a **sorting algorithm** which sorts the student's GPA from highest to lowest. If a teacher, or whomever the use is, wishes to insert previous data, they can enter in a file with the following format:

**SchoolType,firstName LastName,GPA,unitsTaken,gradePoints**

**Note: This program is a finalized version and will no longer be worked on.**

# Features

 - You are able to add a student's account to a list and continuously many more. Can classify students depending on what type of school they attend (University or Community).
 -Can find existing student's in the list and be able to edit them in ways such as their name as well as adding a class to their portfolio.
 - If a student is no longer available, you are eligible to remove them from the list
 - Displays a leaderboard of the students which sort from highest to lowest GPA. Can filter and display those attending University or the from community
 - As stated Above, you are able to read in existing data from a text file provided it is in the right format.

## Files
There are currently five files which allow this program to function as is

**UserApp**
This file serves as the main interface of the entire program. It is how much of the program's function are accessed. It contains two sorting method. The first of which mainly servers as a method helper for the **binarySearch** method. It sorts the names of the **StudentAccounts** alphabetically. The second sorting method is **gpaSort** and sorts the students by highest to lowest GPA . If two or more students happen to have the same GPA, it will instead sort those students alphabetically. Both of these methods were implemented via a selection sort. To begin using this file, instanciate a **UserApp** class and call the **initializeApp()** method with a Scanner parameter.

**StudentAccount**
This files is the **interface** of the program. It allows access to the following function which were implemented from the Student class:
 - addGradePoints(int classUnits, int gradeChoice)
 - String name
 - int classUnits
 - calculateGPA()
 - getGPA()
 - getName()
 - getObject()
 - toString()

The methods above are mainly utilized by the LinkedList which carry StudentAccount as the object
 
 **Student**
 This is an abstract class which implements the StudentAccount interface. It provides certain method for calculating a student's GPA through algorithm based on a student's units taken. The abstract methods are implemented into the Community and University classes.
 
 **University**
 This is a concrete class which calculates a student's grade points based on the university scale. It inherits the Student class and it differs in that each individual grade has their own scale. For instance and A- has a grade point scale of 3.7.

**Community**
This is a concrete class which calculates a student's grade points based on the university scale. It inherits the Student class and it differs in that all letters have the same scale, regardless if is plus or minus. For instance, a B+ has the same scale as a B- which is 3.0.
