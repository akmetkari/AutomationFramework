package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.RegistrationPage;

public class Registration extends BaseClass{
	
	@Test(dataProvider = "TestDataForRegistration",dataProviderClass = DataProviders.class)
	public void createUser(Map<String, String> userData) 
	{
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.loginOption();
		
		loginPage.clickOnSignInLink();
		
		RegistrationPage register=new RegistrationPage(driver);
		
		register.registerUser(
                userData.get("Name"), userData.get("Email"), userData.get("Password"),
                userData.get("Interest"), userData.get("Gender"), userData.get("State"), userData.get("Hobbies")
        );
				
		boolean status=register.signUpMsg();
		
		Assert.assertTrue(status,"Registration Failed");
		
	}

}
