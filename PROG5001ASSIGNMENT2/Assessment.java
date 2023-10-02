
/**
 * Assignment2 - PROG5001
 *
 * @author Sandeep Kaur / 24066442
 * 
 */
public class Assessment
{
    static String unitName;

    private double marksA1;
    private double marksA2;
    private double marksA3;

    /**
     * Parametric Constructor class Assessment
     */
    public Assessment(double marksA1,double marksA2,double marksA3)
    {
        this.marksA1 = marksA1;
        this.marksA2 = marksA2;
        this.marksA3 = marksA3;
    }

    /**
     * Creating Setter methods for the attributes
     */
    public void setMarksA1(double marksA1)
    {
        this.marksA1 = marksA1;
    }

    public void setMarksA2(double marksA2)
    {
        this.marksA2 = marksA2;
    }

    public void setMarksA3(double marksA3)
    {
        this.marksA3 = marksA3;
    }

    /**
     * Creating Getter methods for the attributes
     */
    public double getMarksA1()
    {
        return this.marksA1;
    }

    public double getMarksA2()
    {
        return this.marksA2;
    }

    public double getMarksA3()
    {
        return this.marksA3;
    }

    public double getTotalMarks()
    {
        return marksA1 + marksA2 + marksA3;
    }

    /**
     * @Overriding toString method
     */
    public String toString(){
        return  " Unit:: "+Assessment.unitName+" Marks_A1: "+this.marksA1+" Marks_A2: "+this.marksA2+" Marks_A3: "+this.marksA3+" Total = "+getTotalMarks();
    }
}
