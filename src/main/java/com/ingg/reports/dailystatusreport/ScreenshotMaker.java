package com.ingg.reports.dailystatusreport;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScreenshotMaker implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(ScreenshotMaker.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Value("${screenshots.location}")
    private String saveFolder;

    @Value("${report.location}")
    private String url;

    public void generateScreenshot() {
        try {
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            File scrFile = ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
            File destFile = new File(saveFolder + "report-"+dateFormat.format(new Date())+".png");
            logger.info("Generating file {}",destFile);
            FileUtils.copyFile(scrFile, destFile);

            driver.close();
        } catch (Exception e) {
            logger.error("Something did not work",e);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        generateScreenshot();
    }
}
