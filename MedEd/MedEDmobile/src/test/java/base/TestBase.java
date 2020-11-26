package base;




import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.AppiumServer;
import utilities.CommonUtilities;
import org.openqa.selenium.TakesScreenshot;

public class TestBase {
	
	public AppiumDriver<MobileElement> driver;
	public static String loadpropertyfile = "Android_MedEd.properties";
	public static Logger log = Logger.getLogger(TestBase.class);
	
	
	/*public void takeScreenshot() {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

		File scrFile = (( TakesScreenshot ) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\reports\\"+fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	public void setup()
	{
		if(driver==null)
		{

			PropertyConfigurator
				.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\propertys\\log4j.properties");
			
			
			if(loadpropertyfile.startsWith("Android_"))
			{
				
				
				AppiumServer.start();
				log.info("Appium server started");
				CommonUtilities.loadAndriodConfProp(loadpropertyfile);
				log.info(loadpropertyfile +":=>  property file loaded !!");
				CommonUtilities.setAndroidCapabilities();
				driver = CommonUtilities.getAndroidDriver();
				
				
				
				
			}else if(loadpropertyfile.startsWith("IOS_"))
			{
				
			}
	}
	}

	public void Quit() 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		log.info("Test case Execution completed");
		AppiumServer.stop();
		log.info("Appium server stopped");
		
	}
}
