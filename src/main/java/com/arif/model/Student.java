package com.arif.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

	@Id
	private int roll;
	private String fName;
	private String lName;
	private String currClass;

	public Student() {

	}

	public Student(int roll, String fName, String lName, String currClass) {
		super();
		this.roll = roll;
		this.fName = fName;
		this.lName = lName;
		this.currClass = currClass;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getCurrClass() {
		return currClass;
	}

	public void setCurrClass(String currClass) {
		this.currClass = currClass;
	}

}
