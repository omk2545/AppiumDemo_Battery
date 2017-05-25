package rough;


import com.google.jacquard.utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Created by okulkarni on 11/9/2016.
 */
public class TestApp {

    public AndroidDriver device1;
    public AndroidDriver device2;
public ExtentReports extentReports;
    public ExtentTest test;




    public void LockAndunclock(){



    }



    public   void pressint(AndroidDriver driver){

        WebElement androidElement ;
        androidElement = driver.findElement(By.id("digit_7"));
        androidElement.click();

    }


    public void openElan(AndroidDriver driver1){


    }

    @BeforeMethod
public void init(){

        test = createTest("Sequential Calls");

}



@Test
public void testSeqCalls() throws Exception {

   // ExtentTest test = createTest("TestOmkar");
//    ExtentTest test1 = createTest("Device 2");
test.log(LogStatus.INFO,"Creating a Instances ");

  //   device1  = createDeviceInstance("4726","148.147.153.141:5555","com.android.launcher3");



     device2  = createDeviceInstance("4736","148.147.195.53:5555","com.android.launcher3");

    //pressint(device1);


   // openLauncher(device1);
    test.log(LogStatus.INFO,"Opening launcher ");
    openLauncher(device2);
    test.log(LogStatus.INFO,"Opening Launcher ");


//    Helper helper = new Helper();
//
//    for(int i = 0;i<5;i++) {
//        helper.addContact(device2,test);
//    }
//    for(int i= 1 ; i<=100; i++) {
//
//        test.log(LogStatus.INFO,"Iteartion Started" +i);
//    //    helper.Dailnumber(4223, device1);
//       helper.redail(device1);
//
//        Thread.sleep(400);
//t
//        //  helper.endCurrentcall(device1);
//
//        //pressint(device2);
//
//        //ressint(device2);
//
//        helper.answerCall(device2);
//        test.log(LogStatus.INFO,"Device 2 Answers" +i);
//
//        helper.endCurrentcall(device1);
//        test.log(LogStatus.INFO,"Ending current Call Device ");
////        helper.Dailnumber(4213,device2);
//
//
//        helper.redail(device2);
//
//        helper.answerCall(device1);
//
//        helper.endCurrentcall(device2);
//        System.out.println("Completed"+i);
//
//        test.log(LogStatus.PASS," Iteration "+i+" Completed Successfully ");
//
//    }
//   // AndroidDriver driver;

    //AndroidDriver driver;







//    AndroidElement menuBtn = (AndroidElement) device1.findElement(By.xpath("//android.widget.TextView[@content-desc='Apps']"));
//
//    menuBtn.click();

//    AndroidElement menuBt_2 = (AndroidElement) device2.findElement(By.xpath("//android172.16.10.238.widget.TextView[@content-desc='Apps']"));
//
//    menuBt_2.click();
//
//
//
//    AndroidElement elanAppIcon = (AndroidElement) device1.findElement(By.xpath("//android.widget.TextView[@content-desc='Avaya Vantage™ Light']"));
//
//    elanAppIcon.click();

//    AndroidElement elanAppIcon_1 = (AndroidElement) device2.findElement(By.xpath("//android.widget.TextView[@content-desc='Avaya Vantage™ Light']"));
//
//    elanAppIcon_1.click();

//
//    openLauncher(device1);
//
//    openLauncher(device2);









//LauncherActivity launcherActivity = new LauncherActivity(device1,test);
////LauncherActivity launcherActivity2 = new LauncherActivity(device2,test1);
//
//    launcherActivity.openLauncher();
//   // launcherActivity2.openLauncher();
//
//
//    HomePageElan  homePageElan = launcherActivity.OpenElan();
//    homePageElan.dialNumber(4700);
//// HomePageElan  homePageElan2 = launcherActivity2.OpenElan();
//    homePageElan2.dialNumber(4700);

//
//    LauncherActivity launcherActivity = new LauncherActivity(device1,test);
//    LauncherActivity launcherActivity1 = new LauncherActivity(device2,test);
//    launcherActivity.openLauncher();
//    launcherActivity1.openLauncher();
//
//    HomePageElan  homePageElan = launcherActivity.OpenElan();
//    homePageElan.dialNumber(4700);
//
//
//    HomePageElan  homePageElan1 = launcherActivity1.OpenElan();
//    homePageElan1.dialNumber(4600);

//    BaseActivityPage baseActivityPage = new BaseActivityPage(device1,test);
//
//
//    //            DailingScreenPage dailingScreenPage = baseActivityPage.gotoDailingPage();
////            dailingScreenPage.Dailnumber(4990);
////
//
//    DailingScreenPage settings = baseActivityPage.gotoDailingPage();
//  //  DailingScreenPage dailingScreenPage = new DailingScreenPage(device1,test);
//    // se
//    settings.Dailnumber(4223);



//    BaseActivityPage baseActivityPage = new BaseActivityPage(device1,test);
//
//    Settings settings = baseActivityPage.gotoSetteings();
//    settings.setAccount("4213");







  //  AndroidDriver device2 = createDeviceInstance("4726","148.147.154.52:5555");














}





    public void openLauncher(AndroidDriver driver){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AndroidElement menuBtn = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Apps']"));

        menuBtn.click();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        AndroidElement eqinox = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Avaya Equinox']"));
//
//        eqinox.click();

   AndroidElement elanAppIcon = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Avaya Vantage™ Basic']"));

        elanAppIcon.click();

    }




@AfterMethod
public void TearDown(ITestResult result){


    if (result.getStatus() == ITestResult.FAILURE) {
        test.log(LogStatus.FAIL,"Test Failed");
    }else{

        test.log(LogStatus.PASS,"Test Case Pass");

    }





    System.out.println("Closing Instances ");

//    device1.quit();
    device2.quit();
    extentReports.endTest(test);
    extentReports.flush();


}




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
        capabilities.setCapability("platformVersion", "6.0.1");

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

        String url  = "http://127.0.0.1:"+Port+"/wd/hub";

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
