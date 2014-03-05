package com.nathananderson.TODO.goal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Task extends Goal to include actual time estimates and recorded time-on-task 
 * intervals.
 * 
 * @author Nathan Anderson
 */
public class Task extends Goal {
	private double estimate;
	private ArrayList<Interval> clockedTime;
	
	/**
	 * Default constructor, does nothing but call super() and then initialize 
	 * the private variables to default values of zero and empty.
	 */
	public Task(){
		super();
		this.setEstimate(0);
		clockedTime = new ArrayList<Interval>();
	}
	
	/**
	 * Sets the estimated time to complete the task to the given value, and 
	 * initializes an empty Interval list.
	 * 
	 * @param name			The task's name.
	 * @param estimatedTime	The decimal time estimate (in hours) to complete the task.
	 */
	public Task(String name, double estimatedTime){
		super(name);
		this.setEstimate(estimatedTime);
		clockedTime = new ArrayList<Interval>();
	}
	
	/**
	 * Sets all fields to the desired values.
	 * 
	 * @param estimatedTime	The decimal time estimate (in hours) to complete the task.
	 * @param times			An existing ArrayList of Intervals of work on this task.
	 */
	public Task(String name, Date startDate, Date endDate, Progress completion, ArrayList<Goal> childTasks, double estimatedTime, ArrayList<Interval> times){
		super(name, startDate, endDate, completion, childTasks);
		this.setEstimate(estimatedTime);
		clockedTime = times;
	}
	
	/**
	 * Starts a new active time-on-task Interval
	 */
	public void start(){
		clockedTime.add(new Interval());
	}
	
	/**
	 * Stops the first active time-on-task interval found.
	 */
	public void stop(){
		for(Iterator<Interval> times = clockedTime.iterator(); times.hasNext();){
			//Iterate through, checking for 'active' Intervals
			Interval time = times.next();
			if(time.isActive()){
				time.end();
				//since there shouldn't be more than one active interval, break out after closing this interval
				break;
			}
		}
	}
	
	/**
	 * Returns the time estimate for this task. The estimate is assumed to be 
	 * in decimal hours.
	 * 
	 * @return	The time estimate for this task itself, not including child tasks.
	 */
	public double ownEstimatedTime(){
		return estimate;
	}
	
	/**
	 * Sets the time estimate for this task. The estimate is assumed to be in
	 * decimal hours.
	 * 
	 * @param newEstimate	The desired new time estimate.
	 */
	public void setEstimate(double newEstimate){
		estimate = newEstimate;
	}
	
	/**
	 * Overrides Goal's estimatedTime() to include the estimate for this task itself
	 * 
	 * @return
	 */
	public double estimatedTime(){
		return super.estimatedTime() + this.ownEstimatedTime();
	}
	
	/**
	 * Calculates the total elapsed time of this task's own time intervals
	 * 
	 * @return	The total elapsed time of this task's Intervals.
	 */
	public double ownElapsedTime(){
		double elapsed = 0;
		for(Iterator<Interval> times = clockedTime.iterator(); times.hasNext();){
			//iterate through the intervals, accumulating the total elapsed time
			Interval time = times.next();
			elapsed = elapsed + time.timeElapsed();
		}
		
		return elapsed;
	}
	
	/**
	 * Overrides Goal's elapsedTime() to include the elapsed time from this task itself
	 * 
	 * @return	The total elapsed time of this task and its child tasks.
	 */
	public double elapsedTime(){
		return super.elapsedTime() + this.ownElapsedTime();
	}
}
