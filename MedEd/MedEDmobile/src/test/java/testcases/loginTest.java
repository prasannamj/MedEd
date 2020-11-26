package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.LoginScreen2;
import screens.PreLoginScreen;

public class loginTest extends TestBase {
	
	PreLoginScreen pre_login; 
	LoginScreen2 loginpage;
	
	@BeforeTest
	public void init()
	{
		setup();
		pre_login = new PreLoginScreen(driver);
		loginpage = new LoginScreen2(driver);
	}
	
	
	@Test(priority=1)
	public void FirstloginBtn()
	{
		pre_login.clickLoginBTn();
	}
	
	@Test(priority=2)
	public void EnterLoginCredentials()
	{
		loginpage.EnteruserName();
		loginpage.Enterpassword().clickLoginBTn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@AfterTest
	public void quit() 
	{
		Quit();
	}

}
