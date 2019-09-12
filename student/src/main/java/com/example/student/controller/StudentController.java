package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.StudentReportCard;
import com.example.student.model.StudentDetails;
import com.example.student.service.StudentService;

@RestController
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping(value="/addstudentdetails")
	public StudentDetails addStudentDetails(@RequestBody StudentDetails body)
	{
		System.out.println("StudentController :: addStudentDetails()");
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails = studentService.addStudentDetails(body);
		
		return studentDetails;
	}
	
	@GetMapping(value="/getstudentreportcard/{rollNo}/{year}")
	public StudentReportCard getStudentReportCard(@PathVariable("rollNo") int rollNo, @PathVariable("year") int year)
	{
		System.out.println("StudentController :: getStudentReportCard()");
		
		StudentReportCard studentReportCard = new StudentReportCard();
		studentReportCard = studentService.getStudentReportCard(rollNo, year);  
		
		return studentReportCard;
	}
	
	@GetMapping(value="/getstudentdetails/{rollNo}")
	public StudentDetails getStudentDetails(@PathVariable("rollNo")int rollNo)
	{
		System.out.println("StudentController :: getStudentDetails()");
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails = studentService.getStudentDetails(rollNo);
		
		return studentDetails;
	}
	
	@PatchMapping(value="/updatestudentdetails/{rollNo}")
	public StudentDetails updateStudentDetails(@RequestBody StudentDetails body,@PathVariable("rollNo")int rollNo)
	{
		System.out.println("StudentController :: updateStudentDetails()");
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails = studentService.updateStudentDetails(body, rollNo);
		
		return studentDetails;
	}
	
	@DeleteMapping(value="/deletestudentdetails/{rollNo}")
	public void deleteStudentDetails(@PathVariable("rollNo")int rollNo)
	{
		System.out.println("StudentController :: deleteStudentDetails()");
		
		studentService.deleteStudentDetails(rollNo);
	}
}
