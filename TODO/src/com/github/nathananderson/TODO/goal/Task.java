package com.github.nathananderson.TODO.goal;

public class Task extends Goal {
	public double estimate;
	//TODO: private collection clockedTime
	
	//TODO: constructors
	
	//start a new on-task time interval
	public void start(){
		//TODO: add a new Interval to the clockedTime collection and start it
	}
	
	//stop the current on-task time interval
	public void stop(){
		//TODO: find the current running Interval (if one exists) and stop it
	}
	
	/*
	 * Overrides Goal's getEstimatedTime() to include the estimate for this task itself
	 */
	public double getEstimatedTime(){
		return super.getEstimatedTime() + estimate;
	}
	
	/*
	 *  Overrides Goal's getElapsedTime() to include the elapsed time from this task itself
	 */
	public double getElapsedTime(){
		//TODO: calculate elapsed time from collection of Intervals
		double elapsed = 0;
		
		return super.getElapsedTime() + elapsed;
	}
}
