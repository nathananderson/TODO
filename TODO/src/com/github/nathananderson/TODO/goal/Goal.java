package com.github.nathananderson.TODO.goal;

import java.util.Date;

public class Goal {
	public String name;
	public Date startDate;
	public Date endDate;
	//TODO: public collection children
	
	//TODO: constructors
	
	/* Presently, name, start, and end don't really require any special care when accessing
	 */
	
	public void setName(String newName){
		name = newName;
	}
	
	public String getName(){
		return name;
	}
	
	public void setStart(Date newStart){
		startDate = newStart;
	}
	
	public Date getStart(){
		return startDate;
	}
	
	public void setEnd(Date newEnd){
		endDate = newEnd;
	}
	
	public Date getEnd(){
		return endDate;
	}
	
	
	/* A goal's estimated time is the sum of its children's estimated time.
	 * Goals themselves have no estimated time, as they represent abstract ideas. If a goal has no concrete tasks for children, then its estimated time is 0 hours.
	 */
	public double getEstimatedTime(){
		
		//TODO: calculate actual estimated time from children
		double time = 0;
		
		return time;
	}
	
	/* A goal's elapsed time is the sum of its children's elapsed time
	 * Goals themselves have no elapsed time, as they represent abstract ideas. If a goal has no concrete tasks for children, then its elapsed time is 0 hours.
	 */
	public double getElapsedTime(){
		
		//TODO: calculate actual elapsed time from children
		double time = 0;
		
		return time;
	}
}
