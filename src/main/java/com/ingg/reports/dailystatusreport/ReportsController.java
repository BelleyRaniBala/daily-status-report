package com.ingg.reports.dailystatusreport;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

@Controller
public class ReportsController {

    Logger logger = LoggerFactory.getLogger(ReportsController.class);

    @Value("${screenshots.location}")
    private String location;

    @GetMapping("/reports")
    public String greeting( Model model) {
        File folder = new File(location);
        File[] listOfFiles = folder.listFiles();
        Arrays.sort(listOfFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        });
        logger.info("files: {}", listOfFiles);
        model.addAttribute("name", "belley");
        model.addAttribute("listOfFiles", listOfFiles);
        return "reports";
    }


}
