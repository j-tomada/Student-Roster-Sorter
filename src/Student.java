/**
 * Class provides methods for calculating a student's GPA
 * Abstract class
 * @author Joseph Tomada
 * @date 05/04/2020
 * CS 108 Section 3
 */

import java.text.DecimalFormat;
public abstract class Student implements StudentAccount {
    private String studentName;
    private double studentGPA;
    private int unitsTaken;
    public double gradePoints;

    /**
     * Param. Constructor
     * Used when an account is first added
     */
    public Student (String studentName) {
        this.studentName = studentName;
        studentGPA = 0;
        unitsTaken = 0;
        gradePoints = 0;
    }

    /**
     * Param. Constructor
     * Used when wanting to upload existing data from a text file
     */
    public Student (String studentName, double studentGPA, int unitsTaken, double gradePoints) {
        this.studentName = studentName;
        this.studentGPA = studentGPA;
        this.unitsTaken = unitsTaken;
        this.gradePoints = gradePoints;
    }

    /**
     * Setters
     */
    public void setName (String studentName) {this.studentName = studentName;}

    /**
     * Getters
     */
    public String getName () {return this.studentName;}
    public double getGPA () {return this.studentGPA;}
    public int getUnitsTaken () {return  this.unitsTaken;}
    public double getGradePoints () {return  this.gradePoints;}

    /**
     * Increases a student's total units taken
     */
    public void addUnits (int classUnits) {unitsTaken = unitsTaken + classUnits;}

    /**
     * Increases a student's total grade points achieved
     */
    public void addGradePoints(int classUnits, int gradeChoice) {
        double classGradePoints = determineGradePoints(gradeChoice) * (double) classUnits;
        gradePoints = classGradePoints + gradePoints;
    }

    /**
     * Method calculates GPA by dividing gradepoints by unitsTakes
     */
    public void calculateGPA () {
        studentGPA = gradePoints / unitsTaken;

        DecimalFormat decFormat = new DecimalFormat("####0.00");
        studentGPA = Double.parseDouble(decFormat.format(studentGPA));
    }

    /**
     * toString that is utilized by UserApp class
     * @return String
     */
    public String toString () {

        String string1 = String.format("%-40s|", "|" +getName() +" (" +getObject() +" Student)");
        String string2 = String.format("%-10s|", "GPA: " +getGPA());
        String string3 = String.format("%-18s|", "Units Taken: " +getUnitsTaken());

        return string1 + string2 +string3;
    }

    /**
     * Abstract Classes to be implemented by classes: Community and University
     */
    public abstract double determineGradePoints(int gradeChoice);
    public abstract String getObject ();
}
