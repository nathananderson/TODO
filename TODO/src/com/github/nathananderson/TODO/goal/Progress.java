
package com.github.nathananderson.TODO.goal;

public enum Progress {
	NOT_STARTED ("Not Started", 1),
	IN_PROGRESS("In Progress", 2),
	FINISHED("Completed", 3);
	
	private final String text;
    private final int state; 
    
    private Progress(String text, int state) {
        this.text = text;
        this.state = state;
    }
    
    public String text(){
    	return text;
	}
    
    public int state(){
    	return state;
    }
}
