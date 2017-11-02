import java.util.Random;
/**
 * This program generates random Blurbs in this alien language were a Whoozit is followed by one
 * or more Whatzits. A Whoozit is the character 'x' followed by zero or more ' y's '. A Whatzit
 * is a 'q' followed by either 'z' or a 'd' followed by a Whoozit.
 *
 * @author Josh Ortiz modified by Daniela Moreno
 * @version October 20,2017
 */
public class BlurbLanguage
{
    Random words; 

    public static void main (String[]args){
      BlurbLanguage phrase = new BlurbLanguage();
       
       System.out.println("The blurb is: " + phrase.createBlurb());
       System.out.println("The blurb is: " + phrase.createBlurb());

    }
    
    /**
     * Constructor of the blurbWord
     */
    public BlurbLanguage(){

        words = new Random();
    }
        

    /**
     * This method gets the whoozit characters and appends them before
     * the y's. It then returns a string with these characters.
     */
    private String getWhoozit(){
        StringBuffer whoozit = new StringBuffer();
        whoozit.append("x");
        whoozit.append(getWhoozitY());

        return whoozit.toString();
    }

    /**
     * This method gets the "y's" that are to be included on the whoozit
     */
    private String getWhoozitY(){
        StringBuffer y = new StringBuffer();
        boolean start = words.nextBoolean();
        if(!start)
            y.append(getWhoozitY());
        else
            return
            y.toString();

        y.append("y");
        return y.toString();
    }

    /**
     * This method gets the whatzits characters and returns them as a String
     */
    private String getWhatzit(){
        StringBuffer whatzit = new StringBuffer();
        whatzit.append("q");
        boolean charZ = words.nextBoolean();
        if(charZ)
            whatzit.append("z");
        else    
            whatzit.append("d");

        whatzit.append(getWhoozit());

        return whatzit.toString();
    }

    /**
     * This method checks if there are more whatzits and appends them to the string
     */private String getSeveralWhatzits(){
        StringBuffer moreWhatzits = new StringBuffer();

        moreWhatzits.append(getWhatzit());
        boolean start = words.nextBoolean();
        if(!start)
            moreWhatzits.append(getSeveralWhatzits());
        else
            return moreWhatzits.toString();

        return moreWhatzits.toString();
    }

    /**
     * This method combines both getWhoozit and getSeveralWhatzits and returns the blurb
     * language version
     */
    public String createBlurb(){
        StringBuffer blurb = new StringBuffer();
        blurb.append(getWhoozit());
        blurb.append(getSeveralWhatzits());
        return blurb.toString();
    }

}
