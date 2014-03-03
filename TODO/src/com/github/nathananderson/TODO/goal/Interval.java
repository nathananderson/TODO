package com.github.nathananderson.TODO.goal;

import java.util.Date;

/**
 * An Interval records a period of time between a start datetime and an end 
 * datetime.
 * An Interval will always have a set start datetime, but an 'active' interval 
 * will not have a set end datetime.
 * 
 * @author Nathan Anderson
 */
public class Interval {
	public Date startTime;
	public Date endTime;

	/**
	 * Default (brand new interval) constructor, sets startTime to the current time at instantiation 
	 * and leaves endTime unset.
	 */
	public Interval(){
		this.setStart(new Date());
	}
	
	/**
	 * Constructor for new but already started intervals, sets the start time 
	 * to the given datetime and leaves the end datetime unset.
	 * 
	 * @param start	The desired start datetime for the interval.
	 */
	public Interval(Date start){
		this.setStart(start);
	}
	
	/**
	 * Constructor for completed intervals, with known start and end datetimes.
	 * 
	 * @param start	The desired start datetime for the interval.
	 * @param end	The desired end datetime for the interval.
	 */
	public Interval(Date start, Date end){
		this.setStart(start);
		this.setEnd(end);
	}
	
	/**
	 * Sets the end of the interval to the current time.
	 * 
	 */
	public void end(){
		endTime = new Date();
	}
	
	/**
	 * Returns a boolean indicating whether or not the interval is currently 
	 * 'active', that is, if its end has not yet been set.
	 * 
	 * @return 	Returns <code>true</code> if this Interval's end time is not set, <code>false</code> otherwise.
	 */
	public boolean isActive(){
		return (null == endTime);
	}
	
	/**
	 * Set the start of the interval to the given time.
	 * 
	 * @param newStart	The desired start datetime.
	 */
	public void setStart(Date newStart){
		startTime = newStart;
	}
	
	/**
	 * Set the end of the interval to the given time
	 * 
	 * @param newEnd	The desired end datetime.
	 */
	public void setEnd(Date newEnd){
		endTime = newEnd;
	}
	
	/**
	 * Calculates the time that elapsed between start and end, or between 
	 * start and now, if end is not set.
	 * 
	 * @return	The decimal time in hours between start and end.
	 */
	public double timeElapsed(){
		
		//if endTime is not set, use the current time as the end
		Date end = endTime;
		if(null == endTime){
			end = new Date();
		}
		
		//get the difference in milliseconds between start and end
		long elapsed = end.getTime() - startTime.getTime();
		
		//convert milliseconds to decimal hours and return
		return ((double)elapsed / 3600000);
	}
}
