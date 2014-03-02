package com.github.nathananderson.TODO.goal;

import java.util.Date;

public class Interval {
	public Date startTime;
	public Date endTime;
	
	//TODO: constructors
	
	//set the end of the interval to the current time
	public void end(){
		endTime = new Date();
	}
	
	//set the start of the interval to the given time
	public void setStart(Date newStart){
		startTime = newStart;
	}
	
	//set the end of the interval to the given time
	public void setEnd(Date newEnd){
		endTime = newEnd;
	}
}
