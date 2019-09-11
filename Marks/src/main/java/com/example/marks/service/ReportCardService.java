package com.example.marks.service;

import java.util.Objects;

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
		System.out.println("ReportCardService :: getReportCard()");
		
		ReportCard reportCard = new ReportCard();
		reportCard = reportCardRepo.findByRollNoAndYear(rollNo, year);
		
		return reportCard;
	}
	
	public ReportCard addReportCard(ReportCard reportCard)
	{
		System.out.println("ReportCardService :: addReportCard()");
		
		ReportCard rCard = new ReportCard();
		rCard = reportCardRepo.findByRollNoAndYear(reportCard.getRollNo(), reportCard.getYear());
		if(Objects.isNull(rCard))
			return reportCardRepo.save(reportCard);
		else
		{
			reportCard.set_id(rCard.get_id());
			return reportCardRepo.save(reportCard);
		}
	}
	
	public ReportCard updateReportCard(ReportCard reportCard)
	{
		System.out.println("ReportCardService :: updateReportCard()");
		
		ReportCard oldReportCard = new ReportCard();
		oldReportCard = reportCardRepo.findByRollNoAndYear(reportCard.getRollNo(), reportCard.getYear());
		
		return oldReportCard;
	}
	
	public void deleteReportCard(int rollNo, int year)
	{
		System.out.println("ReportCardService :: deleteReportCard()");
		
		reportCardRepo.deleteById(reportCardRepo.findByRollNoAndYear(rollNo, year).get_id());
	}
}
