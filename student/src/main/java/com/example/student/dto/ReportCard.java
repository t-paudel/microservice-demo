package com.example.student.dto;

import java.util.List;

import com.example.student.model.SubjectAndMarks;

public class ReportCard 
{
	private int rollNo;
	private int year;
	private List<SubjectAndMarks> marks;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<SubjectAndMarks> getMarks() {
		return marks;
	}

	public void setMarks(List<SubjectAndMarks> marks) {
		this.marks = marks;
	}
}
