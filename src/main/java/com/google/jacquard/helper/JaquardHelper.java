package com.google.jacquard.helper;




import com.google.jacquard.utils.CommadLineExec;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Dim;
import org.openqa.selenium.*;

import com.google.jacquard.base.PageActivity;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import javax.swing.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class JaquardHelper extends PageActivity {

	public JaquardHelper(AndroidDriver driver, ExtentTest test) {
		super(driver, test);
		// TODO Auto-generated constructor stub
	}
CommadLineExec commadLineExec;
	// public AndroidDriver driver;
	// public ExtentTest test;

	// public JaquardHelper(AndroidDriver driver, ExtentTest test) {
	//
	// this.driver = driver;
	// this.test = test;
	//
	// }
public int gettotalJestureCount() throws InterruptedException {

//    AndroidElement interact = (AndroidElement) driver.findElementById("com.google.atap.jacquard:id/text_view_label");
//    AndroidElement reflect = (AndroidElement) driver.findElementById("com.google.atap.jacquard:id/text_view_label");





    //if ( interact.getText().contains("Interact")){
       // driver.swipe(972,899,15, 899,666);
        Thread.sleep(600);





        AndroidElement woreitBest = (AndroidElement) driver.findElementById("com.google.atap.jacquard:id/imageView_icon_sxsw");
        woreitBest.click();

        AndroidElement  countText = (AndroidElement) driver.findElementById("com.google.atap.jacquard:id/ability_usage_count");
        countText.getText();


    //  test.log(LogStatus.INFO,"Count "+countText.getText());



  //  }


return 3;
}

	public void swipeinandout(){

        driver.swipe(972,899,15, 899,666);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.swipe(455,899,972, 899,666);

//        try{
//	        test.log(LogStatus.INFO,"finding the element" );
//
//	        AndroidElement interact = (AndroidElement) driver.findElementById("com.google.atap.jacquard:id/text_view_label");
//
//
//	        if ( interact.getText().contains("Interact"))
//	       {
//               driver.swipe(972,899,15, 899,666);
//           }
//
//        }catch (NoSuchElementException e){
//
//            driver.swipe(455,899,972, 899,666);
//        }


//        Dimension size = driver.manage().window().getSize();
//        int anchor = (int) (size.height * anchorPercentage);
//        int startPoint = (int) (size.width * startPercentage);
//        int endPoint = (int) (size.width * finalPercentage);
//        new TouchAction(driver).press(startPoint, anchor).waitAction(duration).moveTo(endPoint, anchor).release().perform();

        //In documentation they mention moveTo coordinates are relative to initial ones, but thats not happening. When it does we need to use the function below
        //new TouchAction(driver).press(startPoint, anchor).waitAction(duration).moveTo(endPoint-startPoint,0).release().perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        driver.swipe(972,899,15, 899,666);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }




     //   TouchAction action = new TouchAction(driver);

        // Tomorrow's work
    //
        //    action.waitAction(   Duration.ofSeconds(66));
	}

	public boolean isAppConnectedToJacket(){

		driver.manage().timeouts().implicitlyWait(15, SECONDS);

		driver.openNotifications();


		return true;


	}



	public boolean isMusicPlaying(){

		driver.manage().timeouts().implicitlyWait(15, SECONDS);

		driver.openNotifications();

return true;


	}
	public boolean isbluetoothEnabled(){

		driver.manage().timeouts().implicitlyWait(15, SECONDS);

		driver.openNotifications();

//		  AndroidElement launcher = (AndroidElement) driver.findElement(By.id("com.google.android.apps.nexuslauncher:id/page_indicator"));
//      launcher.click();
//
//		AndroidElement searchTxt = (AndroidElement) driver
//				.findElement(By.id("com.google.android.apps.nexuslauncher:id/search_box_input"));
//		searchTxt.sendKeys("Settings");
//
//		AndroidElement settingsApp = (AndroidElement) driver
//				.findElement(By.xpath("//android.widget.TextView[@content-desc='Settings']"));
//
//
//		settingsApp.click();

		TouchAction action = new TouchAction(driver);


		AndroidElement openSettings = (AndroidElement) driver.findElementByAccessibilityId("Open quick settings.");

		openSettings.click();

		//AndroidElement bluetoothIcon = (AndroidElement) driver.findElement(By.xpath(Constants.bluetoothIcon));
		//AndroidElement bluetoothIcon = (AndroidElement) driver.findElementByXPath(Constants.bluetoothIcon);
		AndroidElement bluetoothIcon = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[@text='Bluetooth']");


action.longPress(bluetoothIcon).perform();

AndroidElement bluetoothStatus = (AndroidElement) driver.findElementById("com.android.settings:id/switch_bar");
String status =bluetoothStatus.getAttribute("text");
if (status.contains("On")){

  //  test.log(LogStatus.INFO,"bluetooth is connected");
    driver.pressKeyCode(AndroidKeyCode.BACK);
    return true;

}else {

    return false;
}
		//action.press(bluetoothIcon).perform();
//bluetoothIcon.click();



		
	}


//    public  WebElement fluentwait(AndroidDriver driver, final By byType){
//        Wait wait = new FluentWait(driver)
//                .withTimeout(45, TimeUnit.SECONDS)
//                .pollingEvery(5, TimeUnit.SECONDS)
//                .ignoring(NoSuchElementException.class);
//        WebElement foo = wait.until(new Function() {
//            public WebElement apply(AppiumDriver driver) {
//                return driver.findElement(byType);
//            }
//        });
//        wait.until(ExpectedConditions.elementToBeClickable(byType));
//        return foo;
//    }



    public boolean isElementPresentById(String id) {


		AndroidElement androidElement = null;
	boolean	isElementPresent = false;



		try {
			//com.google.atap.jacquard:id/button_introducing_jacquard
			androidElement = (AndroidElement) driver.findElementById(id);

            // Waiting 30 seconds for an element to be present on the page, checking

            // for its presence once every 5 seconds.





			if (androidElement.isDisplayed()){

				isElementPresent = true;
			}
		}catch (Exception e){
			isElementPresent = false;
	//		test.log(LogStatus.INFO,"Element not found "+id);
		}

return isElementPresent;


	}


	public AndroidElement findByid(String id){
		AndroidElement androidElement = null;

		try {
			//com.google.atap.jacquard:id/button_introducing_jacquard
			androidElement = (AndroidElement) driver.findElementById(id);
		}catch (Exception e){
	//		test.log(LogStatus.INFO,"Element not found by "+id);
            System.out.println("Element not found by " +id);
        }

		return  androidElement;


	}



	
	public void launchJaquard() {

		driver.manage().timeouts().implicitlyWait(15, SECONDS);
		
		  AndroidElement launcher = (AndroidElement) driver.findElement(By.id("com.google.android.apps.nexuslauncher:id/page_indicator"));
        launcher.click();   

		
		//test.log(LogStatus.INFO, "searching for the app Jaquard");
		AndroidElement searchTxt = (AndroidElement) driver
				.findElement(By.id("com.google.android.apps.nexuslauncher:id/search_box_input"));
		searchTxt.sendKeys("Ja");

		driver.manage().timeouts().implicitlyWait(15, SECONDS);


		AndroidElement jaquardApp = (AndroidElement) driver
				.findElementByAccessibilityId(Constants.jaquardApp_resourceId);

		if (jaquardApp.isDisplayed()) {
			jaquardApp.click();
		} else {
			//test.log(LogStatus.FAIL, "could not app using search");
		}





	}

    public void clickOnWhatIsJaquard(){

		if (isElementPresentById("com.google.atap.jacquard:id/button_introducing_jacquard"));
		{
			AndroidElement whatisJaquard_button = findByid("com.google.atap.jacquard:id/button_introducing_jacquard");
			whatisJaquard_button.click();
		}
	}


	public void pressHome(){

        driver.pressKeyCode(AndroidKeyCode.HOME);
    }


	public void clickOngetStated(){


        if (isElementPresentById("com.google.atap.jacquard:id/button_start_jacquard")){

      // 	test.log(LogStatus.INFO,"User on splash screen activity");
            System.out.println("Getting started screen displayed on foreground");
            AndroidElement getstartedButton = findByid("com.google.atap.jacquard:id/button_start_jacquard");
            getstartedButton.click();
            System.out.println("Getting started passed");
        }




    }


    public void keepApplicationInTheForeGround(){

		System.out.println(driver.currentActivity());

		Dimension dimension = driver.manage().window().getSize();

		double x = dimension.getHeight() *0.5 ;
		double y = dimension.getWidth() * 0.5 ;


		for (int i = 1; i<=25;i++) {
			System.out.println(driver.currentActivity());
			TouchAction action = new TouchAction(driver);
			action.tap(((int) x), ((int) y)).perform();
		}





	}


public void clickOnlearnInteractions(){
        if (isElementPresentById("com.google.atap.jacquard:id/learnInteractionsButton")){

        	//test.log(LogStatus.PASS,"Step : Getting started passed");
            AndroidElement learnInteraction = findByid("com.google.atap.jacquard:id/learnInteractionsButton");
			learnInteraction.click();


			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

    }

	public void clickOnAcceptAgrement(){
		if (isElementPresentById("com.google.atap.jacquard:id/button_accept")){
			AndroidElement accept = findByid("com.google.atap.jacquard:id/button_accept");
			accept.click();
           // test.log(LogStatus.PASS,"Clicked on tag is ready");
            System.out.println("Clicked on tag is ready");
        }


	}



	public void selectGoogleAccount(){

//		com.google.atap.jacquard:id/button_tag_ready

		if (isElementPresentById("com.google.android.gms:id/account_name")){

			AndroidElement accountName = findByid("com.google.android.gms:id/account_name");
			accountName.click();

		}

	}
	public void clickOnILookFab(){


		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (isElementPresentById("com.google.atap.jacquard:id/fabulous_button")){

				AndroidElement accountName = findByid("com.google.atap.jacquard:id/fabulous_button");
				accountName.click();

			}

		}



		public void allowBluetoothAccess(){

	//		com.google.atap.jacquard:id/button_tag_ready

			if (isElementPresentById("com.android.packageinstaller:id/permission_allow_button")){

				AndroidElement allowButton = findByid("com.android.packageinstaller:id/permission_allow_button");
				allowButton.click();

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}





		public boolean selectAJacket(){

	//		com.google.atap.jacquard:id/button_tag_ready

			if (isElementPresentById("com.google.atap.jacquard:id/garment_identifier_textview")){

				AndroidElement jacket = findByid("com.google.atap.jacquard:id/garment_identifier_textview");
				jacket.click();
				//test.log(LogStatus.PASS,"Jacket Found");
                System.out.println("Jacket found");

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return true;
			}else{

			//	test.log(LogStatus.PASS,"Jacket not  Found");
                System.out.println("Not found");
                return false;
			}

		}public boolean clickTryOutNewThreads(){

	//		com.google.atap.jacquard:id/button_tag_ready

			if (isElementPresentById("com.google.atap.jacquard:id/try_threads_button")){

				AndroidElement tryNewThreads = findByid("com.google.atap.jacquard:id/try_threads_button");
				tryNewThreads.click();
				return true;

			}else{

				return false;
			}

		}



    public void clickOnTagIsReady(){

//		com.google.atap.jacquard:id/button_tag_ready

		if (isElementPresentById("com.google.atap.jacquard:id/button_tag_ready")){

			AndroidElement tagIsReady = findByid("com.google.atap.jacquard:id/button_tag_ready");
			tagIsReady.click();
			//test.log(LogStatus.PASS,"Clicked on tag is ready");
		}

	}

	public void clickonEnableJacquard(){
        //driver.runAppInBackground(Duration.ofSeconds(66));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (isElementPresentById("com.google.atap.jacquard:id/button_enable_jacquard")){

			AndroidElement enableJacquard = findByid("com.google.atap.jacquard:id/button_enable_jacquard");
			enableJacquard.click();
		//	test.log(LogStatus.PASS,"Step : Enable jaquardNow clicked");
		}


	}

	//com.google.atap.jacquard:id/button_enable_jacquard
	public void playVideosOnWhatIsJaquard(){

		if (isElementPresentById("com.google.atap.jacquard:id/intro_video_button") && isElementPresentById("com.google.atap.jacquard:id/welcome_video_button"));
		{
			AndroidElement firstVideo = findByid("com.google.atap.jacquard:id/intro_video_button");
			firstVideo.click();
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            driver.pressKeyCode(AndroidKeyCode.BACK);

            AndroidElement secondVideo = findByid("com.google.atap.jacquard:id/welcome_video_button");
            secondVideo.click();
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           driver.pressKeyCode(AndroidKeyCode.BACK);

            isElementPresentById("com.google.atap.jacquard:id/back_button");
            AndroidElement backButton = findByid("com.google.atap.jacquard:id/back_button");
            backButton.click();
        }
	}


	public void pressBackOn(){

		if(isElementPresentById("com.google.atap.jacquard:id/back_button")) {
            AndroidElement backButton = findByid("com.google.atap.jacquard:id/back_button");
            backButton.click();
        }else{

            System.out.println("Back button not found");
            takeScreenShot();

        }
	}

public void clickOnBlushinAndBack(){



}




	public void takeApplicationinBackground(double minutes){

commadLineExec = new CommadLineExec(test);
String cpuusage =  commadLineExec.getcurrenCPUUsage();
        System.out.println(cpuusage);
        pressHome();
        test.log(LogStatus.PASS, "** Battery " + commadLineExec.getcurrentBatteryLevel() + " ** Battery " + commadLineExec.getcurrentBatteryTemperature() + "** CPU usage:   " +cpuusage);
     //   test.log(LogStatus.INFO,"** Battery "+commadLineExec.getcurrentBatteryLevel()+" While the app in foreground");
        test.log(LogStatus.INFO,"Application will be background for "+minutes*60 +" seconds");
        try {

            Thread.sleep((long) (minutes*60000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.PASS, "** Battery " + commadLineExec.getcurrentBatteryLevel() + " ** Battery " + commadLineExec.getcurrentBatteryTemperature() + "** CPU usage:    " + commadLineExec.getcurrenCPUUsage());
       // test.log(LogStatus.INFO,"** Battery "+commadLineExec.getcurrentBatteryLevel()+" While the app in background");
        launchJaquard();






    }
public void takeApplicationinBackground(double minutes , String Screen){

commadLineExec = new CommadLineExec(test);

test.log(LogStatus.INFO,"The user is on the ##### "+Screen+"#####");
String cpuusage =  commadLineExec.getcurrenCPUUsage();
        System.out.println(cpuusage);
        pressHome();
        test.log(LogStatus.PASS, "** Battery " + commadLineExec.getcurrentBatteryLevel() + " ** Battery " + commadLineExec.getcurrentBatteryTemperature() + "** CPU usage:   " +cpuusage);
     //   test.log(LogStatus.INFO,"** Battery "+commadLineExec.getcurrentBatteryLevel()+" While the app in foreground");
        test.log(LogStatus.INFO,"Application will be background for "+minutes*60 +" seconds");
        try {

            Thread.sleep((long) (minutes*60000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.PASS, "** Battery " + commadLineExec.getcurrentBatteryLevel() + " ** Battery " + commadLineExec.getcurrentBatteryTemperature() + "** CPU usage:   " + commadLineExec.getcurrenCPUUsage());
       // test.log(LogStatus.INFO,"** Battery "+commadLineExec.getcurrentBatteryLevel()+" While the app in background");
        launchJaquard();






    }



	public void clickonGotIt() {
		//com.google.atap.jacquard:id/positive_button
driver.manage().timeouts().implicitlyWait(20, SECONDS);
		;
		if (isElementPresentById("com.google.atap.jacquard:id/positive_button")) {
            AndroidElement gotItButton = findByid("com.google.atap.jacquard:id/positive_button");
            gotItButton.click();
        }else {
		    takeScreenShot();
		   // TakesScreenshot();
		    //test.log();

        }


	}
}
