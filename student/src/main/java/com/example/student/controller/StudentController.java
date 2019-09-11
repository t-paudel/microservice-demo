package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.ReportCard;
import com.example.student.service.StudentService;

@RestController
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{rollno}/{year}")
	public void getReportCard(@PathVariable("rollno") int rollNo, @PathVariable("year") int year)
	{
		System.out.println("controller");
		
		ReportCard reportCard = new ReportCard();
		reportCard = studentService.getReportCard(rollNo,year);
		
		System.out.println(reportCard.getRollNo() + " " + reportCard.getYear());
	}
}
