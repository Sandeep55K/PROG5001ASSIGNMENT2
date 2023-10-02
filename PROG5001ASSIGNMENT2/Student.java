
/**
 * Assignment2 - PROG5001
 *
 * @author Sandeep Kaur / 24066442
 * 
 */
public class Student
{
    // instance variables 
    private int studentId;
    private String lastName;
    private String firstName;

    private Assessment assessment;
    /**
     * Default Constructor for objects of class Student
     */
    public Student(){

    }

    /**Setter methods for instance variables*/
    public void setStudentId(int id)
    {
        this.studentId = id;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setAssessment(Assessment obj){
        this.assessment = obj;
    }

    /**Getter Methods for instance variables*/
    public int getStudentId()
    {
        return this.studentId;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public Assessment getAssessment(){
        return this.assessment;
    }

    /**
     * @Overriding toString method of String Class to Display Data within the Object along with total marks
     */
    public String toString(){
        return "Name: "+firstName+" "+lastName+" Student ID: "+this.studentId+" Assessment ::>>"+this.assessment+'\n';
    }
}
