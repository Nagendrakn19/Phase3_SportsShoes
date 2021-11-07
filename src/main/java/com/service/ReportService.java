package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Report;
import com.dao.ReportCategory;
import com.dao.ReportDao;


@Service
public class ReportService {
	
	@Autowired
	ReportDao reportDao;

	@Autowired
	ReportCategory reportCategory;
	
	public List<Report> getAllReport()
	{
		return reportDao.getAllReport();
	}
	
	public List<Report> getAllReportBasedOnCategory(String category) {
		return reportCategory.findAllByCategory(category);
	}
	
	public List<Report> getAllReportBasedOnDate(String date) {
		return reportCategory.findAllByDate(date);
	}
}
