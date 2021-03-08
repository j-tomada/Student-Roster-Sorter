/**
 * Concrete Class used to calculate grade points for
 * a student attending a community college
 * @author Joseph Tomada
 * @date 05/05/2020
 * CS 108 Section 3
 */
public class Community extends Student {

    public Community (String name) {
        super(name);
    }

    public Community (String name, double gpa, int unitsTaken, double gradePoints) {
        super(name, gpa, unitsTaken, gradePoints);
    }

    /**
     * Determines what grade gives how many grade Points
     * @return doubleVariable that is how many grade points a grade is worth
     */
    @Override
    public double determineGradePoints(int gradeChoice) {
        switch (gradeChoice) {
            case 1:
            case 2:
                return 4.0;
            case 3:
            case 4:
            case 5:
                return 3.0;
            case 6:
            case 7:
            case 8:
                return 2.0;
            case 9:
            case 10:
            case 11:
                return 1.0;
            case 12:
                return 0;
            default:
                return -1;
        }
    }

    /**
     * Method that classifies the class as either Community or University
     * @return String
     */
    @Override
    public String getObject () {
        return "Community";
    }

}

