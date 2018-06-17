package com.ingg.reports.dailystatusreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DailyStatusReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyStatusReportApplication.class, args);
	}
}
