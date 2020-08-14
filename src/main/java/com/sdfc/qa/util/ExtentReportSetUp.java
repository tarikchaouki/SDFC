package com.sdfc.qa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.model.Test;
import com.sdfc.qa.base.TestBase;

public class ExtentReportSetUp extends TestBase {
	
	
	public static ExtentReports SetUpExtentRep() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy  HH-mm-ss");
		// get current date
		Date date= new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir")+"\\Reports\\ExtentReport_" + actualDate + ".html";
		
		ExtentSparkReporter sparkareport = new ExtentSparkReporter(reportPath);
		extent = new  ExtentReports();
		extent.attachReporter(sparkareport);
		
		sparkareport.config().setDocumentTitle("DocumentTitle");
		sparkareport.config().setTheme(Theme.DARK);
		sparkareport.config().setReportName("ReportName");
		
		return extent;
	}

}
