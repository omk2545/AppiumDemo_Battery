package com.google.jacquard.test.testcases;

import com.google.jacquard.helper.Constants;
import com.google.jacquard.helper.JaquardHelper;
import com.google.jacquard.test.TestBase;
import com.google.jacquard.utils.CommadLineExec;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by omkar on 31-05-2017.
 */
public class Demo extends TestBase {

    CommadLineExec commadLineExec;
    AndroidDriver JaquardApp;
    AndroidDriver SimulatorApp;

    // AndroidDriver device1;

    ExtentTest test;
    JaquardHelper jaquardHelper;
    String testName = "UserOnboardingDemo";

    @BeforeMethod
    public void init() throws Exception {

       test = createTest(testName);
       commadLineExec = new CommadLineExec(test);
        commadLineExec.clearAllappdata();
        commadLineExec.initBatteryData();
        JaquardApp = createDeviceInstance(Constants.portNo, Constants.deviceName, Constants.appPackage,
                Constants.appActivity);
        jaquardHelper = new JaquardHelper(JaquardApp, test);
    }


    @Test
    public void demoJacquardApp() {

//        String name = Thread.currentThread().getStackTrace()[1].getMethodName();
//        test= createTest(name);
//        System.out.println("Test: " +name);



//        jaquardHelper = new JaquardHelper(JaquardApp, test);
//        commadLineExec = new CommadLineExec(test);
//        commadLineExec.clearAllappdata();


        test.log(LogStatus.INFO, "### Battery before the app launch ### ** Battery " + commadLineExec.getcurrentBatteryLevel() + " ** Battery " + commadLineExec.getcurrentBatteryTemperature() + "** CPU usage: " + commadLineExec.getcurrenCPUUsage());

        jaquardHelper.launchJaquard();
        jaquardHelper.keepApplicationInTheForeGround();
       // jaquardHelper.takeApplicationinBackground(0.2, "  splash screen ");

        jaquardHelper.clickOngetStated();
//        test.log(LogStatus.INFO, "User is on the ##### splash screen  ####");

        //  jaquardHelper.takeApplicationinBackground(0.5, " Abilities screen ");
        jaquardHelper.clickonEnableJacquard();

        jaquardHelper.clickOnTagIsReady();
        //jaquardHelper.takeApplicationinBackground(0.3, " Activate tag ");

        jaquardHelper.clickOnAcceptAgrement();
        //jaquardHelper.takeApplicationinBackground(0.5, " User acceptance agreement screen ");
        jaquardHelper.selectGoogleAccount();
        test.log(LogStatus.INFO, "The user is on the ##### Put on the new jacket screen #####");
        jaquardHelper.clickOnILookFab();
        test.log(LogStatus.INFO, "The user is on the ##### Tuck and Snap screen #####");
        jaquardHelper.allowBluetoothAccess();
        test.log(LogStatus.INFO, "The user is on the ##### searching screen #####");

        if (jaquardHelper.selectAJacket()) {
            test.log(LogStatus.INFO, "The user is on the ##### Pairing screen #####");

            if (jaquardHelper.clickTryOutNewThreads()) {
                jaquardHelper.clickOnlearnInteractions();

                test.log(LogStatus.INFO, "The user is on the ##### learn interactions screen #####");;

                for (int i = 1; i < 5; i++) {


                    if (i%2 ==0 ) {
                        test.log(LogStatus.INFO, "The user is on the ##### Interact screen #####");
                    }else{

                        test.log(LogStatus.INFO, "The user is on the ##### Reflect screen #####");
                    }

                    System.out.println("App on the foreground");
                    // jaquardHelper.takeApplicationinBackground(0.5);
                    System.out.println("I " + i);

                    for (int j = 0; j < 1; j++) {
                        System.out.println("J " + j);
                        jaquardHelper.swipeinandout();
                    }
                }
            }
        } else {
            jaquardHelper.clickonGotIt();
            for (int i = 0; i < 2; i++) {
                System.out.println("Iteration: " + i);
                jaquardHelper.pressBackOn();
                jaquardHelper.clickOnILookFab();
            }
            jaquardHelper.clickonGotIt();

        }





    }


    @AfterMethod
    public void tearDown() {
        /**Code to close Appium driver Instance **/

        JaquardApp.quit();
        test.log(LogStatus.PASS, "Test Completed Successfully  !!!");
        test.log(LogStatus.PASS, "### Battery Stats after the test completion ### ** Battery " + commadLineExec.getcurrentBatteryLevel() + " ** Battery " + commadLineExec.getcurrentBatteryTemperature() + "** CPU usage: " + commadLineExec.getcurrenCPUUsage());

        /**Code to print batteryData to a file**/
        commadLineExec.printBatteryData(testName);


        JaquardApp.quit();
        extentReports.endTest(test);
        extentReports.flush();

        /**Code to  generate battery Historian Graph**/
        commadLineExec.generateBatteryHistorianGraph(testName);


    }


}
