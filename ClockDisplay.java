
/**
 * This ClockDisplay class implements a digital clock display for a
 * American-style 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00 AM (midnight) to 11:59 PM (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 * 
 * This is the 12-hour-internal branch
 * modified by John Patrick Fahy
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;
    private String amPm;// simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        amPm = "AM";
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String AMorPM)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        amPm = AMorPM;
       setTime(hour, minute, amPm);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        if(hours.getValue() == 0 && minutes.getValue() == 0 && amPm =="AM")
        {
            amPm = "PM";
        }
        else if(hours.getValue() == 0 && minutes.getValue() == 0 && amPm =="PM")
        {
            amPm = "AM";
        } 
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String AMorPM)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        amPm = AMorPM;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        int hour = hours.getValue();
        if(hour == 0){
            hour = 12;
        displayString = 12 + ":" + 
                        minutes.getDisplayValue() +" " +amPm;
        }
        else{
            displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() +" " +amPm;
    }
}
}
