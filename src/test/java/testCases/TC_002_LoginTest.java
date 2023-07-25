package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity" , "Master"} )
	public void test_login()
	{
		try
		{	
		logger.info("***** Starting TC_002_LoginTest *****");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.enterEmail(rb.getString("email")); // get it from config.properties file
		lp.enterPassword(rb.getString("password")); //get it from config.properties file
		lp.clickLoginbtn();
		
		MyAccountPage msp= new MyAccountPage(driver);
		boolean targetpage=msp.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC_002_LoginTest *****");
		
		
	}

}
