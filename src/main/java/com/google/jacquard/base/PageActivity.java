package com.google.jacquard.base;

import com.google.jacquard.helper.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by okulkarni on 10/17/2016.
 */
public class PageActivity {
    public AndroidDriver driver;
    public ExtentTest test;

    public PageActivity(AndroidDriver driver , ExtentTest test) {
        this.driver=driver;
        this.test = test;

    }

public void takeScreenShot(){


    Date date  = new Date();
    String updatedName = date.toString().replace(":","_").replace(" ","_");

    File scrFile;
    String path = Constants.USER_DIR+"\\screenshots\\"+updatedName+".png";

    System.out.println(path);
    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    //The below method will save the screen shot in d drive with name "screenshot.png"
    try {
        FileUtils.copyFile(scrFile, new File(path));
    } catch (IOException e) {
        e.printStackTrace();
    }
    //Change
    //test.log(LogStatus.INFO,"Adding the screens ",test.addScreenCapture(path));
    System.out.println("Image-> "+path);


}

    public static void captureLog(AppiumDriver driver, String testName)
            throws Exception {
        DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        String logPath = "C:\\";

       // log.info(driver.getSessionId() + ": Saving device log...");
        List<LogEntry> logEntries = driver.manage().logs().get("logcat").filter(Level.ALL);
        File logFile = new File(logPath + reportDate + "_" + testName + ".txt");
        PrintWriter log_file_writer = new PrintWriter(logFile);
        log_file_writer.println(logEntries );
        log_file_writer.flush();

    }
}


