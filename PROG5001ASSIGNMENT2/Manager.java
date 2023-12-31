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
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Please Enter File Name which contains the data");
            //Inputing file name from the user
            fileName = sc.next();

            //calling getData method to read and fetch data from the file
            List<Student> list = getData(fileName);
            
            Menu menu = new Menu(list);
            int choice = menu.chooseMenu(sc);
            if (choice==100)
            choice = menu.chooseMenu(sc);
            /**System.out.println(list);
            printStudentInfo(list);
            double threshold = getThreshold(sc);
            System.out.println("Threshold value entered by user is: "+threshold);
            printBelowThreshold(list,threshold);
            List<Student> sortedList = sortStudentList(list);
            System.out.println("***************************");
            displayFiveTopper(sortedList);
            System.out.println("***************************");
            displayFiveLowest(sortedList);*/
        }
        catch(Exception e){
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }

    //Defining a static method to read and fetch data from the file
    public static List getData(String fileName){
        String data;
        List<Student> list = new ArrayList();
        /*Instantiating File object to read data from file*/
        try{
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){

                String[] values = null;
                data = reader.nextLine();

                boolean emptyString = false;
                //Finding Unit Name from the file and Storing it
                if(data.contains("Unit")){

                    values = data.split(": ");
                    Assessment.unitName = values[1];

                }
                //Checking for Header lines and hence ignoring
                if(data.contains("Last Name")){

                }
                else {

                    values = data.split(",");
                    //checking if any value is Empty, if found empty ignoring further
                    for(String str:values){

                        if(str.isEmpty()){
                            emptyString = true;
                        }
                    }
                    //When there is incomplete information we are ignoring
                    if(values.length<6){

                    }
                    //checking if we get all the 6 values from the string and none of them is empty thats our desired data
                    //putting desired data into Student Object
                    else if(values.length==6 && !emptyString){

                        Student stud = new Student();
                        stud.setLastName(values[0]);
                        stud.setFirstName(values[1]);
                        stud.setStudentId(Integer.parseInt(values[2]));

                        stud.setAssessment(new Assessment(Double.parseDouble(values[3]),Double.parseDouble(values[4]),Double.parseDouble(values[5])));                      

                        list.add(stud);

                    }
                }
            }
            reader.close();      

        }
        catch(FileNotFoundException e){
            System.out.println("Error: File Not Found");
            e.printStackTrace();
            //calling main again when some unwanted exception occurs to continue with the program
            main(null);
        }
        return list;
    }
    
    
}