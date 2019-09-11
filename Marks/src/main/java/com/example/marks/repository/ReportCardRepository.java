package com.example.marks.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.marks.model.ReportCard;

@Repository
public interface ReportCardRepository extends MongoRepository<ReportCard, String> 
{
	ReportCard findByRollNoAndYear(int rollNo, int year);
}
