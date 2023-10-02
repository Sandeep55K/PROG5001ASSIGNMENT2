/**
 * Assignment2 - PROG5001
 *
 * @author Sandeep Kaur / 24066442
 * 
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class Manager
{
    //local variable to accept the name of the file
    public static String fileName;
    //local variable to store Unit name 
    //public static String unitName;
    /**
    Defining main method 
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter File Name which contains the data");
        //Inputing file name from the user
        fileName = sc.next();
        System.out.println("Filename is: "+fileName);
    }
}
