package com.ingg.reports.dailystatusreport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScreenshotScheduling {
    private static final Logger logger = LoggerFactory.getLogger(ScreenshotScheduling.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    ScreenshotMaker screenshotMaker;

    @Scheduled(fixedRate = 50000)
    public void reportCurrentTime() {
        logger.info("The time is now {}", dateFormat.format(new Date()));
        screenshotMaker.generateScreenshot();
    }

    @Scheduled(cron="0 30 17 * * *")
    public void oncePerDay() {
        logger.info("The time is now {}", dateFormat.format(new Date()));
        screenshotMaker.generateScreenshot();
    }
}
