package com.example.student.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.student.dto.ReportCard;
import com.example.student.repository.StudentRepository;

@Service
public class StudentService
{
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StudentRepository studentRepo;
	
	public ReportCard getReportCard(int rollNo, int year)
	{
		System.out.println("service");
		ReportCard reportCard = new ReportCard();
		String request_url;
		request_url = "http://MARKS/getreportcard/" + rollNo + "/" + year;
		//reportCard = restTemplate.postForObject(request_url, request, ReportCard.class);
		Map<String,Integer> uriVariables = new HashMap<>();
		uriVariables.put("rollno",rollNo);
		uriVariables.put("year",year);
		reportCard = restTemplate.getForObject(request_url, ReportCard.class, uriVariables);
		//reportCard = restTemplate.getForObject(request_url, ReportCard.class);
		
		return reportCard;
	}
}
