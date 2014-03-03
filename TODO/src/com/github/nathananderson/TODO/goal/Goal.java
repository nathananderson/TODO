package com.github.nathananderson.TODO.goal;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Goal is the base class for recording productivity tasks. A Goal serves as a 
 * somewhat abstract concept, and will not record time spent working on itself,
 * but only records target start and end dates and in-progress/complete status.
 * Time estimates and time tracking are done by child Tasks.
 * 
 * @author Nathan Anderson
 */
public class Goal {
	public String name;
	public Date startDate;
	public Date endDate;
	public ArrayList<Goal> children;
	private Progress completion;
	
	public Goal(){
		this.setName("");
		this.setProgressState(Progress.NOT_STARTED);
		children = new ArrayList<Goal>();
	}
	
	public Goal(String newName) {
		this.setName(newName);
		this.setProgressState(Progress.NOT_STARTED);
		children = new ArrayList<Goal>();
	}

	public Goal(String newName, Date newStart, Date newEnd,
			Progress newState, ArrayList<Goal> childTasks) {
		this.setName(newName);
		this.setStart(newStart);
		this.setEnd(newEnd);
		this.setProgressState(newState);
		children = childTasks;
	}

	// Presently, name, start, and end don't really require any special care when accessing
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
	
	/**
	 * Sets the in-progress/complete status of the goal
	 * 
	 * @param newState	
	 */
	public void setProgressState(Progress newState){
		completion = newState;
	}
	
	/**
	 * 
	 * @return
	 */
	public Progress getProgressState(){
		//TODO: a goal's state depends somewhat on the state of its children, e.g. a goal set to NOT_STARTED that has children COMPLETED or IN_PROGRESS is considered to be IN_PROGRESS despite its own set state.
		return completion;
	}
	
	/**
	 * Calculates the estimated time (in hours) that it will take to complete 
	 * this goal.
	 * 
	 * A goal's estimated time is the sum of its children's estimated time.
	 * Goals themselves have no estimated time, as they represent abstract 
	 * ideas. If a goal has no concrete tasks for children, then its estimated 
	 * time is 0 hours.
	 * 
	 * @return A double containing the estimated total decimal hours required to complete this goal.
	 */
	public double estimatedTime(){
		
		double time = 0;
		for(Iterator<Goal> times = children.iterator(); times.hasNext();){
			time = time + times.next().estimatedTime();
		}
		
		return time;
	}

	/**
	 * Calculates the total recorded time spent working on this goal.
	 * 
	 * A goal's elapsed time is the sum of its children's elapsed time.
	 * Goals themselves have no elapsed time, as they represent abstract ideas.
	 * If a goal has no concrete tasks for children, then its elapsed time is 
	 * 0 hours.
	 * 
	 * @return A double containing the total recorded time spent working on this goal's subtasks.
	 */
	public double elapsedTime(){
		
		double time = 0;
		for(Iterator<Goal> times = children.iterator(); times.hasNext();){
			time = time + times.next().elapsedTime();
		}
		
		return time;
	}
}
