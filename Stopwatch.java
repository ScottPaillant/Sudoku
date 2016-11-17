package edu.nyit.csci185.m05.Sudoku;
/**
 * 
 * @author Scott Paillant
 */
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Stopwatch
{ 
    private Date startTime;

    public void startTiming()
    {
        startTime = new Date();
    }

    public String stopTiming()
    {
        Date stopTime = new Date();
        long diff = (stopTime.getTime() - startTime.getTime())/1000L;
      
		 long hours =  (TimeUnit.SECONDS.toHours(diff) - (diff *24));
		 long minute = TimeUnit.SECONDS.toMinutes(diff) - (TimeUnit.SECONDS.toHours(diff)* 60);
		 long second = TimeUnit.SECONDS.toSeconds(diff) - (TimeUnit.SECONDS.toMinutes(diff) *60);
	
		 return ( " Minute " + minute + " Seconds " + second) ;
	
    }

}
