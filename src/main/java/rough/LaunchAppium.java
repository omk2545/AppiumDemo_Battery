package rough;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by omkar on 24-05-2017.
 */


public class LaunchAppium {
    AppiumDriverLocalService appiumDriverLocalService;
    AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void init() throws MalformedURLException {

        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set it Android Emulator.
        capabilities.setCapability("deviceName", "HT71B0201247");

        // Set browserName desired capability. It's Android in our case here.
        capabilities.setCapability("browserName", "Android");

        // Set android platformVersion desired capability. Set your emulator's android version.
        capabilities.setCapability("platformVersion", "7.1.2");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        // capabilities.setCapability("appPackage", "com.cricbuzz.android");
        capabilities.setCapability("appPackage", "com.google.atap.jacquard");

        //  capabilities.setCapability("appPackage", "com.google.apps.nexuslauncher");
        // capabilities.setCapability("appPackage", "com.google.atap.jacquard");


        // Set android appActivity desired capability. It is com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        //     capabilities.setCapability("appActivity", "com.cricbuzz.android.ALGNSplashScreen");
        // capabilities.setCapability("appActivity", "com.google.apps.nexuslauncher.NexusLauncherActivity");

        capabilities.setCapability("appActivity", "com.google.atap.jacquard.application.activities.EntrypointActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4733/wd/hub"), capabilities);
        // driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @Test
    public void testOmakr(){
        MobileElement mobileElement;
        mobileElement = (MobileElement) driver.findElementById("com.google.atap.jacquard:id/button_start_jacquard");

        TouchAction action = new TouchAction(driver);

        action.tap(mobileElement).perform();


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        appiumDriverLocalService.stop();


    }

}
