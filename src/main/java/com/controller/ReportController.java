package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.bean.Report;
import com.service.ReportService;

@RestController
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	//http://localhost:9191/reports
		@GetMapping("/reports")
		public List<Report> getAllReport()
		{
			return reportService.getAllReport();
		}

		
		//http://localhost:9191/reports/category/Runningshoes
		@GetMapping("/reports/category/{category}")
		public ResponseEntity<List<Report>> getAllReportBasedOnCategory(@PathVariable("category") String category) {
			List<Report> getAllReportBasedOnCategory = reportService.getAllReportBasedOnCategory(category);
			if (getAllReportBasedOnCategory.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			ResponseEntity<List<Report>> responseEntity = new ResponseEntity<List<Report>>(getAllReportBasedOnCategory,
					HttpStatus.OK);
			return responseEntity;
		}
		
		//http://localhost:9191/reports/date/2021-11-02
				@GetMapping("/reports/date/{date}")
				public ResponseEntity<List<Report>> getAllReportBasedOnDate(@PathVariable("date") String date)  {
					List<Report> getAllReportBasedOnDate = reportService.getAllReportBasedOnDate(date);
					if (getAllReportBasedOnDate.isEmpty()) {
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					}
					ResponseEntity<List<Report>> responseEntity = new ResponseEntity<List<Report>>(getAllReportBasedOnDate,
							HttpStatus.OK);
					return responseEntity;
				}
}
