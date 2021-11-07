package com.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bean.Report;


public interface ReportCategory extends JpaRepository<Report, Integer>{
	
	@Query(value = "select r from Report r where r.category=:category")
	List<Report> findAllByCategory(@Param("category") String category);
	
	@Query("select r from Report r where r.date=:date")
	List<Report> findAllByDate(@Param("date")String date);

}
