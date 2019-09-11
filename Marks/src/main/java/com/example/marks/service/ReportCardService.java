package com.example.marks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marks.model.ReportCard;
import com.example.marks.repository.ReportCardRepository;

@Service
public class ReportCardService 
{
	@Autowired
	ReportCardRepository reportCardRepo;
	
	public ReportCard getReportCard(int rollNo, int year)
	{
		System.out.println(ReportCardService.class);
		
		ReportCard reportCard = new ReportCard();
		reportCard = reportCardRepo.findByRollNoAndYear(rollNo, year);
		
		return reportCard;
	}
	
	public ReportCard addReportCard(ReportCard reportCard)
	{
		return reportCardRepo.save(reportCard);
	}
}
