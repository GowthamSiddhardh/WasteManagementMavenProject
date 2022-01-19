package com.cleaningmanagement.exception;

public class FoundException extends Exception {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Employee not found (or) inactive";
	}
	
	public String getMessage2() {
		// TODO Auto-generated method stub
		return "insufficient Balance";
	}
	
	public String getMessage3() {
		// TODO Auto-generated method stub
		return "emailId is Already used";
	}
	public String getMessage4() {
		return "you are inactive";
		
	}
	
	public String getMessage5() {
		return "you can't change the status since the employeestatus is in pending / inprogress state";
		
	}
	
}
