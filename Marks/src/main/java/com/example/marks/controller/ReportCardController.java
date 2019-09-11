package com.example.marks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.marks.model.ReportCard;
import com.example.marks.service.ReportCardService;

@RestController
public class ReportCardController 
{
	
	@Autowired
	ReportCardService reportCardService;
	
	@GetMapping(value="/getreportcard/{rollno}/{year}")
	public ReportCard getReportCard(@PathVariable("rollno") int rollNo, @PathVariable("year") int year)
	//@PostMapping(value="/getreportcard")
	//public ReportCard getReportCard(@RequestBody RequestObject obj)
	{
		System.out.println("Controller :: getReportCard()");
		
		ReportCard reportCard = new ReportCard();
		reportCard = reportCardService.getReportCard(rollNo, year);
		
		System.out.println(reportCard.get_id());
		return reportCard;
	}
	
	@PostMapping(value="/addreportcard")
	public ReportCard addReportCard(@RequestBody ReportCard reportCard)
	{
		System.out.println("Controller :: addReportCard()");
		
		return reportCardService.addReportCard(reportCard);
	}
	
	@DeleteMapping(value="deletereportcard/{rollno}/{year}")
	public void deleteReportCard(@PathVariable("rollno") int rollNo,@PathVariable("year") int year)
	{
		System.out.println("Controller :: deleteReportCard()");
		
		reportCardService.deleteReportCard(rollNo, year);
	}
}
