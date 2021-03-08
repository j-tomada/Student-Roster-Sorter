/**
 * Concrete class which serves as the application and its features
 * Allows for binary search and insertion sort on an ArrayList
 * Contains main method
 * @author Joseph Tomada
 * @data 05/05/2020
 * CS 108 Section 3
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class UserApp {

    public ArrayList<StudentAccount> accountList;

    public UserApp () {
        accountList = new ArrayList<>();
    }

    /**
     * User Interface that is began when this method is called
     * Allows the user to choose many several functions using a scanner
     * See method below to see the function each case performs
     */
    public void initializeApp (Scanner scnr) {
        int intInput;
        String stringInput;
        String junkString;

        do {
            printMenu();
            intInput = scnr.nextInt();
            junkString = scnr.nextLine(); //Fixes Logic Error
            System.out.println();

            switch (intInput) {
                case 1:

                    System.out.print("Enter Student Name (Format: FirstName LastName): ");
                    stringInput = scnr.nextLine();

                    System.out.println("Does this student attend a university or a community college?");
                    System.out.println("\t(1.) University   (2.) Community");
                    System.out.print("Enter the following: ");
                    intInput = scnr.nextInt();

                    if (intInput == 1) {
                        accountList.add(new University(stringInput));
                    }
                    else if (intInput == 2) {
                        accountList.add(new Community(stringInput));
                    }
                    else {
                        System.out.println("Invalid input. Setting student as community");
                        accountList.add(new Community(stringInput));
                    }

                    System.out.println("\n" +stringInput +" has been added to the roster!!!!"); //Student Name
                    System.out.println("\nReturning to main menu");
                    intInput = -1;
                    break;

                case 2:

                    System.out.println("Enter Student Name (Format: FirstName LastName): ");
                    stringInput = scnr.nextLine();

                    StudentAccount foundStudent = binarySearch(accountList, stringInput);

                    if(foundStudent == null) { //Does not exist
                        System.out.println("Student not found");
                    }
                    else {
                        caseTwo(foundStudent, scnr);
                    }

                    System.out.println("\nReturning to main menu");
                    break;

                case 3:

                    System.out.println("Enter the name that you wish to remove (Format: FirstName LastName): ");
                    stringInput = scnr.nextLine();

                    StudentAccount caseThreeFound = binarySearch(accountList, stringInput);

                    if(caseThreeFound == null) {
                        System.out.println("Student not found");
                    }
                    else {
                        System.out.println("Do you wish to remove the student, " +caseThreeFound.getName() +"?");
                        System.out.println("\t(1.) Yes  (2.) No");

                        intInput = scnr.nextInt();

                        if(intInput == 1) {
                            accountList.remove(caseThreeFound);
                            System.out.println(caseThreeFound.getName() +" was removed");
                        }
                        else if (intInput == 2) {
                            System.out.println(caseThreeFound.getName() +" was not removed");
                        }
                        else {
                            System.out.println("Invalid input. " +caseThreeFound.getName() +" was not removed");
                        }
                    }

                    System.out.println("Returning to main menu");
                    intInput = -1;
                    break;

                case 4:

                    gpaSort(accountList);

                    caseFour(scnr);

                    intInput = -1;
                    break;

                case 5:

                    caseFive(scnr);
                    break;

                case 6:

                    System.out.println("Closing. Thank you!");
                    break;

                default:
                    System.out.println("\tInvalid input");
                    break;
            }
        } while (intInput != 6);
    }

    /**
     * Main menu screen that appears when app is first initialized
     */
    private void printMenu () {
        System.out.println();
        System.out.println("GPA Leaderboard Application");
        System.out.println("\t(1.) Add a student account");
        System.out.println("\t(2.) Edit an existing student");
        System.out.println("\t(3.) Remove an account");
        System.out.println("\t(4.) Display leaderboard");
        System.out.println("\t(5.) Load in existing data");
        System.out.println("\t(6.) Close Application");
        System.out.print("Please enter the following: ");

    }

    /**
     * Method performs a Binary search on a LinkedList
     *
     * @param list
     * @param key (firstName LastName)
     * @return StudentAccount under the name of the key
     * @return null if none is found
     */
    private StudentAccount binarySearch (ArrayList<StudentAccount> list, String key) {
        nameSort(list); //Names must be sorted in order before binary search is conducted

        int low = 0;
        int high = list.size() - 1;
        int mid = (low + high) / 2;

        while(high >= low) {
            if (list.get(mid).getName().compareTo(key) == 0) {
                return list.get(mid);
            }
            else if (list.get(mid).getName().compareTo(key) > 0) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }

            mid = (low + high) / 2;
        }
        return null;
    }

    /**
     * Method mainly used by binary Search
     * performs an insertion sort and sorts
     * names of the list in alphabetical order
     * @param list
     */
    private void nameSort (ArrayList<StudentAccount> list) {

        for (int i = 0; i < list.size() - 1; ++i) {
            int smallNum = i;

            for (int j = i + 1; j < list.size(); ++j) {

                if(list.get(j).getName().compareTo(list.get(i).getName()) < 0) {
                    smallNum = j;
                }
            }

            StudentAccount temp = list.get(i);
            list.set(i, list.get(smallNum));
            list.set(smallNum, temp);
        }

    }

    /**
     * Method mainly used by the leaderboard feature
     * Performs a reverse insertion sort and sorts
     * GPA from highest to lowest
     * If some students have the same GPA, they will sorted in alphabetical order
     * @param list
     */
    private void gpaSort (ArrayList<StudentAccount> list) {
        for (int i = 1; i < list.size(); ++i) {
            for(int j = i; j > 0; --j) {
                if (list.get(j).getGPA() > list.get(j - 1).getGPA()) {
                    StudentAccount temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set((j - 1), temp);
                }
                else if (list.get(j).getGPA() == list.get(j - 1).getGPA() && list.get(j).getName().compareTo(list.get(j - 1).getName()) < 0) {
                    StudentAccount temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set((j - 1), temp);
                }
                else {
                    break;
                }
            }
        }

    }



    /**
     * Method helper for case 2 in the initializeApp() method
     * @param account
     * @param scnr
     */
    private void caseTwo (StudentAccount account, Scanner scnr) {
        String junkString;
        String stringInput;
        int intInput = -1;

        while (intInput != 4) {
            System.out.println("Account: " + account.getName());
            System.out.print("(1.) Add class/units");
            System.out.print("   (2.) View Student Information");
            System.out.print("   (3.) Edit Name");
            System.out.println("   (4.) Exit");

            intInput = scnr.nextInt();

            switch (intInput) {
                case 1:
                    junkString = scnr.nextLine();

                    int gradeChoice;
                    int unitsWorth;

                    System.out.println("Enter the amount of units this class is worth: ");
                    unitsWorth = scnr.nextInt();

                    System.out.println("\t(1.) A  (2.) A-  (3.) B+  (4.) B  (5.) B-  (6.) C+");
                    System.out.println("\t(7.) C  (8.) C-  (9.) D+  (10.) D  (11.) D-  (12.) F");

                    System.out.println("Enter the grade that this student acquired: ");
                    gradeChoice = scnr.nextInt();

                    account.addUnits(unitsWorth);
                    account.addGradePoints(unitsWorth, gradeChoice);
                    account.calculateGPA();

                    System.out.println("\tAccount has been updated. You can view student information to confirm!!!!");

                    intInput = -1;
                    stringInput = "";
                    break;
                case 2:
                    junkString = scnr.nextLine();
                    System.out.println(account.toString());

                    intInput = -1;
                    stringInput = "";
                    break;
                case 3:
                    junkString = scnr.nextLine();
                    System.out.println("Enter the new name (Format: FirstName LastName): ");
                    stringInput = scnr.nextLine();

                    account.setName(stringInput);
                    System.out.println("Name was set to " +stringInput);

                    intInput = -1;
                    stringInput = "";
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }

    /**
     * Method helper for case 4 in the initializeApp method
     * @param scnr
     */
    private void caseFour(Scanner scnr) {
        String junkString;
        int userInput = -1;

        gpaSort(accountList);

        while(!(userInput > 0) && (userInput < 4)) {
            System.out.println("Select how you want to sort leaderboard");
            System.out.println("\t(1.) Community Students  (2.) University Students  (3.) All Students");
            System.out.println("Enter input: ");

            userInput = scnr.nextInt();
            junkString = scnr.nextLine();

            switch(userInput) {
                case 1:

                    for(StudentAccount Student : accountList) {
                        if(Student.getObject().equals("Community")) {
                            System.out.println(Student.toString());
                        }
                    }

                    break;
                case 2:

                    for(StudentAccount Student : accountList) {
                        if(Student.getObject().equals("University")) {
                            System.out.println(Student.toString());
                        }
                    }

                    break;
                case 3:

                    for(StudentAccount Student : accountList) {
                        System.out.println(Student.toString());
                    }

                    break;
                default:

                    System.out.println("Invalid Input");
                    break;
            }

        }
    }

    public void caseFive (Scanner scnr) {
        System.out.println("Enter in the file Name (include .txt): ");
        String stringInput = scnr.nextLine();

        try {
            File dataFile = new File(stringInput); //May Throw FileNotFound
            Scanner fileReader = new Scanner(dataFile);

            /**
             * IMPORTANT
             *  File must be in this specific format in order to work
             *  "collegeType,studentName,GPA,unitsTaken,gradePoints"
             */
            if(dataFile.isFile()) {
                while(fileReader.hasNextLine()) {
                    StudentAccount account;
                    String line = fileReader.nextLine();
                    String[] array = line.split(","); //Each piece of the line is put into an index of the array

                    /**
                     * Potential fix
                     * Width of the code is very long
                     * However, it overall reduces amount of lines used
                     */
                    if(array[0].equals("University")) {
                        account = new University(array[1], Double.parseDouble(array[2]), Integer.parseInt(array[3]), Double.parseDouble(array[4]));
                    }
                    else {
                        account = new Community(array[1], Double.parseDouble(array[2]), Integer.parseInt(array[3]), Double.parseDouble(array[4]));
                    }
                    accountList.add(account);
                }
            }

        }
        catch(FileNotFoundException excpt) {
            System.out.println("File was not found. Returning to main menu");
        }

    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        UserApp user = new UserApp();
        user.initializeApp(scnr);
    }
}


