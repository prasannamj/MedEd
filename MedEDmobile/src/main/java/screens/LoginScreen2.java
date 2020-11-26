package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen2 extends ScreenBase{
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Email')]")
	public WebElement UserName;

	@AndroidFindBy(xpath = "//*[contains(@text,'Password')]")
	public WebElement Password;

	@AndroidFindBy(xpath = "//*[contains(@text,'Login')]")
	public WebElement loginBtn;
	
//	
//	@AndroidFindBy(xpath = "//*[contains(@text,'Done')]")
//	public WebElement DoneBtn;
	
	

	public LoginScreen2(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	

	public LoginScreen2 EnteruserName()
	{
		UserName.sendKeys("prasannamj23@gmail.com");
		return this;
	}

	public LoginScreen2 Enterpassword()
	{
		Password.sendKeys("qwerty@1");
		return this;
	}

	public LoginScreen2 clickLoginBTn()
	{
		loginBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
//	
//	public HomeScreen clickDoneBtn()
//	{
////		DoneBtn.click();
//		return new HomeScreen(driver);
//	}
}
