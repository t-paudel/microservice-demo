package com.example.marks.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="REPORT_CARD")
public class ReportCard 
{
	@Id
	private String _id;
	
	private int rollNo;
	private int year;
	private List<SubjectAndMarks> marks;
	
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public List<SubjectAndMarks> getMarks() {
		return marks;
	}
	public void setMarks(List<SubjectAndMarks> marks) {
		this.marks = marks;
	}	
}
