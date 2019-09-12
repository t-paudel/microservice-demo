package com.example.student.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
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
	
	public StudentDetails updateStudentDetails(StudentDetails data, int rollNo)
	{
		System.out.println("StudentService :: updateStudentDetails()");

		StudentDetails studentDetails = new StudentDetails();
		Query query = new Query(Criteria.where("rollNo").is(rollNo));
		Update update = new Update();
		Field[] fields;
		
		studentDetails = studentRepo.findByRollNo(rollNo);
		fields = StudentDetails.class.getDeclaredFields();
		for(Field f:fields)
		{
			f.setAccessible(true);
			try 
			{
				if(!Objects.isNull(f.get(data)))
				{
					update.set(f.getName(), f.get(data));
				}
			} 
			catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fields getting updated = " + update);
		
		mongoTemplate.updateFirst(query, update, StudentDetails.class);
		if(!Objects.isNull(data.getRollNo()))
			studentDetails = studentRepo.findByRollNo(data.getRollNo());
		else
			studentDetails = studentRepo.findByRollNo(rollNo);
		
		
		return studentDetails;
	}
	
	public void deleteStudentDetails(int rollNo)
	{
		System.out.println("StudentService :: deleteStudentDetails()");
	
		studentRepo.deleteById(studentRepo.findByRollNo(rollNo).get_id());
	}
}
