
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
    }
}