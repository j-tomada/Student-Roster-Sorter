/**
 * Interface which is implemented by the abstract class, Student
 * Interface will be utilized by a Linkedlist in the UserApp Class
 * @author Joseph Tomada
 * @date 05/04/2020
 * @CS 108 Section 3
 */
public interface StudentAccount {
    public void addGradePoints(int classUnits, int gradeChoice);
    public void setName (String name);
    public void addUnits (int classUnits);
    public void calculateGPA ();
    public double getGPA();
    public String getName ();
    public String getObject ();
    public String toString ();
}
