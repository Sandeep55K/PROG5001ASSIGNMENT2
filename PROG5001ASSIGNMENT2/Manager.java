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
            //System.out.println(list);
            printStudentInfo(list);
            double threshold = getThreshold(sc);
            System.out.println("Threshold value entered by user is: "+threshold);
            printBelowThreshold(list,threshold);
            List<Student> sortedList = sortStudentList(list);
            System.out.println(sortedList);
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
                    //checking if any value is Empty 
                    for(String str:values){

                        if(str.isEmpty()){
                            emptyString = true;
                        }
                    }
                    //When there is incomplete information we are ignoring
                    if(values.length<6){

                    }
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
            main(null);
        }
        return list;
    }
    
    /**
     * Defining a method to print List of information with all data
     */
    public static void printStudentInfo(List<Student> list){
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
    public static double getThreshold(Scanner sc){
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
    public static void printBelowThreshold(List<Student> list, double threshold){
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
    public static List<Student> sortStudentList(List<Student> list){
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
}