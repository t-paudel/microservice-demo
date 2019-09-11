package com.example.marks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.marks.model.ReportCard;
import com.example.marks.service.ReportCardService;

@RestController
public class Controller 
{
	
	@Autowired
	ReportCardService reportCardService;
	
	@GetMapping(value="/getreportcard/{rollno}/{year}")
	public ReportCard getReportCard(@PathVariable("rollno") int rollno, @PathVariable("year") int year)
	{
		ReportCard reportCard = new ReportCard();
		
		return reportCard;
	}
	
	@PostMapping(value="/addreportcard")
	public ReportCard addReportCard(@RequestBody ReportCard reportCard)
	{
		System.out.println("adding report card");
		System.out.println("data -> " + reportCard.getRollNo() + " " + reportCard.getYear());
		
		return reportCardService.addReportCard(reportCard);
	}
}
