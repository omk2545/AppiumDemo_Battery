package com.google.jacquard.test;

import com.google.jacquard.utils.ExtentManager;
import com.google.jacquard.helper.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by okulkarni on 12/29/2016.
 */
public class TestBase {

    public ExtentReports extentReports;
    public ExtentTest test;
    public AndroidDriver Device1,Device2;

    public ExtentTest createTest(String testName){

//    ExtentTest extentTest;
//    ExtentReports extentReports;

        extentReports = ExtentManager.getInstance();

        test = extentReports.startTest(testName);

        return test;
    }





    public AndroidDriver createDeviceInstance (String Port, String deviceIP , String packageName) throws Exception {
        // 148.147.154.52:5555
        AndroidDriver driver;
        System.out.println("Inside Base test");

        // extentReports = ExtentManager.getInstance();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set it Android Emulator.
        capabilities.setCapability("deviceName", deviceIP);

        // Set browserName desired capability. It's Android in our case here.
        capabilities.setCapability("browserName", "Android");

        // Set android platformVersion desired capability. Set your emulator's android version.
        capabilities.setCapability("platformVersion", "7.0");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", packageName);

        capabilities.setCapability("newCommandTimeout", 500);

        // Set android appActivity desired capability. It is com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.

        capabilities.setCapability("appActivity", "com.android.launcher3.Launcher");
        //  capabilities.setCapability("appActivity", "com.google.android.launcher.StubApp");
        capabilities.setCapability("no-reset", "true");
        capabilities.setCapability("full-reset", "false");

        String url  = "http://0.0.0.0:"+Port+"/wd/hub";

        driver = new AndroidDriver(new URL(url), capabilities);


//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        return  driver;


    }


    public AndroidDriver createDeviceInstance (String Port, String deviceIP , String packageName, String activityName) throws Exception {
        // 148.147.154.52:5555
        AndroidDriver driver;
        System.out.println("Inside Base test");

        // extentReports = ExtentManager.getInstance();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set it Android Emulator.
        capabilities.setCapability("deviceName", deviceIP);

        // Set browserName desired capability. It's Android in our case here.
        capabilities.setCapability("browserName", "Android");

        // Set android platformVersion desired capability. Set your emulator's android version.
        capabilities.setCapability("platformVersion", Constants.androidVersion);

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", packageName);

        capabilities.setCapability("newCommandTimeout", 500);

        // Set android appActivity desired capability. It is com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.

        capabilities.setCapability("appActivity", activityName);
        //  capabilities.setCapability("appActivity", "com.google.android.launcher.StubApp");
        capabilities.setCapability("no-reset", "true");
        capabilities.setCapability("full-reset", "false");

        String url  = "http://0.0.0.0:"+Port+"/wd/hub";

        driver = new AndroidDriver(new URL(url), capabilities);


//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        return  driver;


    }






    
    





}
