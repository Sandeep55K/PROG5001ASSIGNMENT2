
/**
 * Assignment2 - PROG5001
 *
 * @author Sandeep Kaur / 24066442
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
    // instance variables list of students
    private List<Student> list;

    /**
     * Constructor for objects of class Menu
     */
    public Menu(List<Student> list)
    {
        // initialise instance variables
        this.list = list;
    }

    /**
     * A method for choosing Menu
     *
     * @param  Scanner object
     * @return    int value against every choice
     */
    public int chooseMenu(Scanner sc)
    {

        int choice;
        System.out.println("Select from MENU for a task to perform :");
        System.out.println();
        System.out.println("To Display List of Students Details with their Unit Name Marks in each Assessment, and Total ====> Enter 1");
        System.out.println("To Enter a threshold value and check which students have scored below of that ===================> Enter 2");
        System.out.println("To Display list of 5 Students with the Highest Marks  ===========================================> Enter 3");
        System.out.println("To Display list of 5 Students with the Lowest Marks  ============================================> Enter 4");
        System.out.println("To Exit Menu  ===================================================================================> Enter 0");

        try{
            choice = sc.nextInt();
            runMenu(choice,sc);
            return choice;
        }
        catch(Exception e){
            System.out.println("From Catch");
            System.out.println("!! Not a valid choice of Menu !! Please Select No. from the given options");
            System.out.println();//Printing blank line
            e.printStackTrace();
            System.out.println();//Printing blank line
            return 100;
        }
        //return choice;
    }

    public void runMenu(int menu, Scanner sc){
        switch (menu){
            case 0:
                System.out.println("MENU Exiting.....");
                break;
            case 1:
                printStudentInfo(list);
                System.out.println("==========================================================================================");
                System.out.println();//Printing blank line
                System.out.println();//Printing blank line
                chooseMenu(sc);
                break;
            case 2:
                double threshold = getThreshold(sc);
                printBelowThreshold(list, threshold);
                System.out.println("==========================================================================================");
                System.out.println();//Printing blank line
                System.out.println();//Printing blank line
                chooseMenu(sc);
                break;
            case 3:
                displayFiveTopper(list);
                System.out.println("==========================================================================================");
                System.out.println();//Printing blank line
                System.out.println();//Printing blank line
                chooseMenu(sc);
                break;
            case 4:
                displayFiveLowest(list);
                System.out.println("==========================================================================================");
                System.out.println();//Printing blank line
                System.out.println();//Printing blank line
                chooseMenu(sc);
                break;
            default:
                System.out.println("No such Menu exists");
                break;
        }
    }

    /**
     * Defining a method to print List of information with all data
     */
    public void printStudentInfo(List<Student> list){
        System.out.println("Name of the Unit "+'\t'+'\t'+"First Name"+'\t'+'\t'+"Last Name"+'\t'+'\t'+"Student ID"+'\t'+"A1"+'\t'+"A2"+'\t'+"A3"+'\t'+"Total");
        System.out.println();
        for(int i = 0; i<list.size();i++){
            System.out.println(Assessment.unitName+'\t'+list.get(i).getFirstName()+'\t'+'\t'+'\t'+list.get(i).getLastName()+'\t'+'\t'+'\t'+'\t'+
                list.get(i).getStudentId()+'\t'+list.get(i).getAssessment().getMarksA1()+'\t'+list.get(i).getAssessment().getMarksA2()+'\t'
                +list.get(i).getAssessment().getMarksA3()+'\t'+list.get(i).getAssessment().getTotalMarks());
        }
    }

    /**
     * Defining method to accept threshold from user
     */
    public double getThreshold(Scanner sc){
        double threshold;
        System.out.println("Enter a double Threshold valid value for evaluation : between(0-300.0)");
        threshold = sc.nextDouble();
        if(threshold<0 & threshold>300){
            System.out.println("!! Not a valid choice of Menu !! Please Select No. from the given options");
            getThreshold(sc);  
        }
        return threshold;
    }

    /**
     * Defining method to student with marks below threshold
     */
    public void printBelowThreshold(List<Student> list, double threshold){
        List<Student> belowThreshold = new ArrayList();

        for(int i =0; i<list.size(); i++){

            if (list.get(i).getAssessment().getTotalMarks() < threshold){
                belowThreshold.add(list.get(i));
            }
        }
        System.out.println("Students with Total Marks below Threshold are :");
        for(int i = 0; i<belowThreshold.size();i++){
            System.out.println(belowThreshold.get(i).getFirstName()+" "+belowThreshold.get(i).getLastName());
        }
    }

    /**
     * Defining amethod to create a sorted List
     */
    public List<Student> sortStudentList(List<Student> list){
        List<Student> sortedList = list;
        Student temp;
        for(int i = 0; i < list.size(); i++){

            for(int j=i+1; j < list.size(); j++){
                if(list.get(i).getAssessment().getTotalMarks() < list.get(j).getAssessment().getTotalMarks()){
                    temp = list.get(i);
                    sortedList.set(i,list.get(j));
                    sortedList.set(j,temp);
                }

            }

        }
        return sortedList;
    }

    /**
     * Defining amethod to Display Top 5 Students
     */
    public void displayFiveTopper(List<Student> list){
        List<Student> sortedList = sortStudentList(list);
        System.out.println("Five Students Highest total Marks are: "+'\n');
        for(int i = 0; i<5; i++){
            System.out.println(sortedList.get(i).getFirstName()+" "+list.get(i).getLastName()+"  || Marks: "+sortedList.get(i).getAssessment().getTotalMarks());
        }

    }

    /**
     * Defining amethod to Display 5 students with Lowest marks
     */
    public void displayFiveLowest(List<Student> list){
        List<Student> sortedList = sortStudentList(list);
        System.out.println("Five Students with lowest total Marks are: "+'\n');
        for(int i = sortedList.size()-5; i<sortedList.size(); i++){
            System.out.println(i+","+sortedList.get(i).getFirstName()+" "+list.get(i).getLastName()+"  || Marks: "+sortedList.get(i).getAssessment().getTotalMarks());
        }

    }
}
