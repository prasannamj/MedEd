package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.HomeScreen;
import screens.LoginScreen2;
import screens.PreLoginScreen;
import utilities.ScrollUtill;

public class HomeScreenTest extends TestBase {

	PreLoginScreen pre_login; 
	LoginScreen2 loginpage;
	HomeScreen  Home_screen;
	
	
	@BeforeTest
	public void init()
	{
		setup();
		pre_login = new PreLoginScreen(driver);
		loginpage = new LoginScreen2(driver);
		Home_screen = new HomeScreen(driver);
	}
	
	
	@Test
	public void swip() {
	
		pre_login.clickLoginBTn().EnteruserName().Enterpassword().clickLoginBTn();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ScrollUtill.scrollUp(2, driver);
//		takeScreenshot();
	}
	
	@AfterTest
	public void quit() 
	{
		Quit();
	}
	
}
