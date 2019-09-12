package com.example.student.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.student.dto.ReportCard;
import com.example.student.dto.StudentReportCard;
import com.example.student.model.StudentDetails;
import com.example.student.repository.StudentRepository;

@Service
public class StudentService
{
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StudentRepository studentRepo;

	
	public StudentDetails addStudentDetails(StudentDetails data)
	{
		System.out.println("StudentService :: addStudentDetails()");
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails = studentRepo.save(data);
		
		return studentDetails;
	}
	
	public StudentReportCard getStudentReportCard(int rollNo, int year)
	{
		System.out.println("StudentService :: getStudentReportCard()");
		
		StudentReportCard studentReportCard = new StudentReportCard();
		StudentDetails studentDetails = new StudentDetails();
		ReportCard reportCard = new ReportCard();
		
		String request_url = "http://MARKS/getreportcard/" + rollNo + "/" + year;
		Map<String,Integer> uriVariables = new HashMap<>();
		uriVariables.put("rollNo", rollNo);
		uriVariables.put("year", year);
		
		studentDetails = studentRepo.findByRollNoAndYear(rollNo, year);
		reportCard = restTemplate.getForObject(request_url, ReportCard.class, uriVariables);
		
		studentReportCard.setName(studentDetails.getName());
		studentReportCard.setReportCard(reportCard);
		
		return studentReportCard;
	}
	
	public StudentDetails getStudentDetails(int rollNo)
	{
		System.out.println("StudentService :: getStudentDetails()");
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails = studentRepo.findByRollNo(rollNo);
		
		return studentDetails;
	}
	
	public void deleteStudentDetails(int rollNo)
	{
		System.out.println("StudentService :: deleteStudentDetails()");
	
		studentRepo.deleteById(studentRepo.findByRollNo(rollNo).get_id());
	}
}
