package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass
{
	@Test(dataProvider = "LoginTestData",dataProviderClass = DataProviders.class)
	public void validLogin(Map<String, String> userData)
	{
		LoginPage login=new LoginPage(driver);
		
		String username = userData.get("Username");
		System.out.println("uname is "+username);
	    
		String password = userData.get("Password");
	    System.out.println("password is "+password);
		
	    login.loginOption();
	
		HomePage homePage=login.loginToApplication(username,password);
		
		Assert.assertTrue(homePage.isManageDisplayed());
		
		homePage.signOutFromApplication();
	
		Assert.assertTrue(login.isSignInDisplayed());
	}
	
	
}
