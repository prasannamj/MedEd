package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtilities {

	private static AppiumDriver<MobileElement> driver;
	private static URL serverUrl;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static String APPIUM_PORT;
	private static int IMPLICIT_WAIT_TIME;
	private static int EXPLICIT_WAIT_TIME;
	private static String BASE_PKG;
	private static String APP_ACTIVITY;
	private static String APP_PACKAGE;
	private static String APP_PATH;
	private static String PLATFORM_NAME;
	private static String PLATFORM_VERSION;
	private static String DEVICE_NAME;
	private static String UDID;
	private static String APP;
	private static String AUTOMATION_NAME;
	
	private static Properties prop = new Properties();
	private static FileInputStream fis;

	public static void loadAndriodConfProp(String loadPropertyFile) {

		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/propertys/"+loadPropertyFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		APP_PACKAGE = prop.getProperty("androidAppPackage");
		APP_ACTIVITY = prop.getProperty("androidAppActivity");
//		APP_PATH = prop.getProperty("application.path");
		PLATFORM_NAME = prop.getProperty("platfromName");
		PLATFORM_VERSION = prop.getProperty("platformVersion");
		DEVICE_NAME = prop.getProperty("DeviceName");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		AUTOMATION_NAME = prop.getProperty("androidAutomationName");
		
	}
	
	//setting android capabilities
	public static void setAndroidCapabilities() {
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
		capabilities.setCapability("automationName", AUTOMATION_NAME);

	}
	
	
	
	
	public static void loadIOSConfProp(String loadPropertyFile) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static void setIOSCapabilities() {
		
		
		
	}
	
	
	public static AppiumDriver<MobileElement> getAndroidDriver() {
		
		try {
			
//			serverUrl = new URL("http://Localhost:"+ APPIUM_PORT+" /wd/hub");
			serverUrl=new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new AndroidDriver<MobileElement>(serverUrl,capabilities);
		return driver;
		
	}
	
	
	public static AppiumDriver<MobileElement> getIOSDriver() {
		
		
		return driver;
		
	}

}

