package com.google.jacquard.test.testcases;

import com.google.jacquard.utils.CommadLineExec;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.google.jacquard.test.TestBase;
import com.google.jacquard.helper.Constants;
import com.google.jacquard.helper.JaquardHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class TestAbilities extends TestBase {
    CommadLineExec commadLineExec;
	AndroidDriver JaquardApp;
	AndroidDriver SimulatorApp;

	// AndroidDriver device1;

	ExtentTest test;
	JaquardHelper jaquardHelper;
    String testName = "UserOnboardingScenario";
	@BeforeMethod
	public void init() throws Exception {




		test = createTest(testName);
		//test.log(LogStatus.INFO, "Creating android driver instances");

        commadLineExec = new CommadLineExec(test);
       //commadLineExec.initBatteryData();
        commadLineExec.clearAllappdata();
       // commadLineExec.getCurrentBatteryStatsNew();
        // JaquardApp =
		// createDeviceInstance("4723","172.16.4.200:5555","com.android.launcher3");

		JaquardApp = createDeviceInstance(Constants.portNo, Constants.deviceName, Constants.appPackage,
				Constants.appActivity);
		jaquardHelper = new JaquardHelper(JaquardApp, test);
	}


	//@Test
	public void testJacketNotFound(){
	    //commadLineExec.getCurrentBatteryStatsNew();

        jaquardHelper.launchJaquard();

        jaquardHelper.clickOngetStated();
    jaquardHelper.clickonEnableJacquard();
    jaquardHelper.clickOnTagIsReady();

    jaquardHelper.clickOnAcceptAgrement();
    jaquardHelper.selectGoogleAccount();
    jaquardHelper.clickOnILookFab();
    jaquardHelper.allowBluetoothAccess();

    jaquardHelper.clickonGotIt();

        for (int i = 0; i < 50; i++) {
            System.out.println("Iteration: "+i);
            jaquardHelper.pressBackOn();
            jaquardHelper.clickOnILookFab();
            jaquardHelper.clickonGotIt();

        }

//commadLineExec.getCurrentBatteryStatsNew();




    }


    @Test
    public void roughTest() {

	    test.log(LogStatus.INFO, "### Battery before the app launch ### ** Battery " + commadLineExec.getcurrentBatteryLevel() + " ** Battery " + commadLineExec.getcurrentBatteryTemperature() + "** CPU usage: " + commadLineExec.getcurrenCPUUsage());

        jaquardHelper.launchJaquard();
        //test.log(LogStatus.INFO, "User is on the ##### ####");
      //  jaquardHelper.takeApplicationinBackground(0.5, "  splash screen activity");

        jaquardHelper.clickOngetStated();
        test.log(LogStatus.INFO, "User is on the ##### splash screen  ####");

      //  jaquardHelper.takeApplicationinBackground(0.5, " Abilities screen ");
        jaquardHelper.clickonEnableJacquard();

        jaquardHelper.clickOnTagIsReady();
        jaquardHelper.takeApplicationinBackground(0.5, " Activate tag ");

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

                for (int i = 1; i < 3; i++) {
                   

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
@Test
public void testAppInTheBackgroudAndForeGround() {


   test.log(LogStatus.INFO, "### Battery before the app launch ### ** Battery " + commadLineExec.getcurrentBatteryLevel() + " ** Battery " + commadLineExec.getcurrentBatteryTemperature() + "** CPU usage: " + commadLineExec.getcurrenCPUUsage());
    jaquardHelper.launchJaquard();

    jaquardHelper.takeApplicationinBackground(0.5);

    jaquardHelper.clickOngetStated();

    test.log(LogStatus.INFO, "User has clicked on Get Started Button and is on the Abilities screen");

    jaquardHelper.clickonEnableJacquard();


    jaquardHelper.takeApplicationinBackground(0.5);
    jaquardHelper.clickOnTagIsReady();


    test.log(LogStatus.INFO, "User is on the activate screen and clicking tag is ready button");
    jaquardHelper.clickOnAcceptAgrement();


    test.log(LogStatus.INFO, "User has accepted the Agreement");

    jaquardHelper.selectGoogleAccount();
    test.log(LogStatus.INFO, "User has selected the google account ");
    jaquardHelper.clickOnILookFab();

    jaquardHelper.allowBluetoothAccess();

    test.log(LogStatus.INFO, "User has allowed the permission for jacket");
    if (jaquardHelper.selectAJacket()) {
        test.log(LogStatus.INFO, "Selected jacket is now connected via bluetooth !!!");


        if (jaquardHelper.clickTryOutNewThreads()) {
            jaquardHelper.clickOnlearnInteractions();

            test.log(LogStatus.INFO, "User is on interaction screen");

            for (int i = 0; i < 20; i++) {
                    test.log(LogStatus.INFO, "application is on the foreground");
                System.out.println("App on the foreground");
                    jaquardHelper.takeApplicationinBackground(0.5);
                System.out.println("I "+i);

                for (int j = 0; j < 5; j++) {
                    System.out.println("J " +j);
                    jaquardHelper.swipeinandout();
                }
             }
        }


    }else{
        jaquardHelper.clickonGotIt();

        for (int i = 0; i < 50; i++) {
            System.out.println("Iteration: "+i);
            jaquardHelper.pressBackOn();
            jaquardHelper.clickOnILookFab();
            jaquardHelper.clickonGotIt();

        }

    }

}

	//@Test
	public void testOnboadingFlow() throws Exception {

//	    jaquardHelper.launchJaquard();
//	    for (int i = 1;i< 50; i++ ) {
//            jaquardHelper.swipeinandout();
//        }
	jaquardHelper.launchJaquard();

	jaquardHelper.clickOngetStated();
	jaquardHelper.pressHome();

	jaquardHelper.launchJaquard();

	jaquardHelper.clickonEnableJacquard();
	jaquardHelper.clickOnTagIsReady();
	//commadLineExec.getCurrentBatteryStatus();
	jaquardHelper.clickOnAcceptAgrement();
	jaquardHelper.selectGoogleAccount();
	jaquardHelper.clickOnILookFab();
    jaquardHelper.allowBluetoothAccess();



    if (jaquardHelper.selectAJacket()){



    }
	Thread.sleep(5000);

    if (jaquardHelper.clickTryOutNewThreads()){


 jaquardHelper.clickOnlearnInteractions();

        for (int i =1;i<200; i++) {

            System.out.println("Iteration"+i);

            jaquardHelper.swipeinandout();


        }


    }else{

        //handle alert for the no jacket found
//test.log(LogStatus.INFO,"Jacket not found");

    }






	}

	@AfterMethod
	public void teardDown() {

        test.log(LogStatus.PASS,"Test Completed Successfully  !!!");
        test.log(LogStatus.PASS, "### Battery Stats after the test completion ### ** Battery " + commadLineExec.getcurrentBatteryLevel() + " ** Battery " + commadLineExec.getcurrentBatteryTemperature() + "** CPU usage: " + commadLineExec.getcurrenCPUUsage());

      // commadLineExec.printBatteryData(testName);
//        commadLineExec.getCurrentBatteryStatsNew();
        JaquardApp.quit();

	//	commadLineExec.getCurrentBatteryStatus();

	 //   commadLineExec.generateBatteryHistorianGraph(testName);
		extentReports.endTest(test);
		extentReports.flush();

	}

}
