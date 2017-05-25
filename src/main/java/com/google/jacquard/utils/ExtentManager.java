package com.google.jacquard.utils;


import com.google.jacquard.helper.Constants;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import org.joda.time.DateTime;

import java.io.File;

/**
 * Created by okulkarni on 10/20/2016.
 */
public class ExtentManager {

    private static ExtentReports extent;


    public static ExtentReports getInstance() {

        if (extent == null) {
          //  Date d = new Date();

            DateTime d = new DateTime();

String todayDate = String.valueOf(d.getDayOfMonth());
            System.out.println(todayDate);

            System.out.println(d.toLocalTime());
           // String todayDate = String.valueOf(d.getDate());

            File folderName = new File(Constants.USER_DIR+"\\reports\\"+todayDate);
            if (!folderName.exists()) {
                if (folderName.mkdir()) {
                    System.out.println("Directory is created!");
                } else {
                    System.out.println("Failed to create directory!");
                }
            }



            String  date = d.toString();
            date= date.replace(":","_");


            String  dat = date.substring(0,18);


           // String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
            String fileName = dat + ".html";


            //String reportPath = "D:\\reports\\"+fileName;
            String reportPath = Constants.USER_DIR+"\\reports\\"+todayDate+"\\"+fileName;
            System.out.println(reportPath);
            extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);


            extent.loadConfig(new File(System.getProperty("user.dir") + "\\Resources\\ReportsConfig.xml"));
            // optional
            extent.addSystemInfo("Android Version", "7.1.2").addSystemInfo(
                    "Application Version", "34").addSystemInfo("Appium Version","1.4.6");
        }
        return extent;
    }
}
