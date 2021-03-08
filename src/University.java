/**
 * Concrete Method which extends the Student class
 * Provides ways of calculating grade Points with
 * a different scale
 * @author Joseph Tomada
 * @data 05/05/2020
 * CS 108 Section 3
 */
public class University extends Student{

    public University (String name) {
        super(name);
    }

    public University (String name, double gpa, int unitsTaken, double gradePoints) {
        super(name, gpa, unitsTaken, gradePoints);
    }

    /**
     * GradePoint Scale for University Students
     * @param gradeChoice
     * @return gradePoint worth for a grade
     */
    @Override
    public double determineGradePoints(int gradeChoice) {
        switch (gradeChoice) {
            case 1:
                return 4.0;
            case 2:
                return 3.7;
            case 3:
                return 3.3;
            case 4:
                return 3.0;
            case 5:
                return 2.7;
            case 6:
                return 2.3;
            case 7:
                return 2.0;
            case 8:
                return 1.7;
            case 9:
                return 1.3;
            case 10:
                return 1.0;
            case 11:
                return 0.7;
            case 12:
                return 0;
            default:
                return -1;
        }
    }

    /**
     * Method that identifies a class as either University or Community
     * @return String
     */
    @Override
    public String getObject () {
        return "University";
    }

}
