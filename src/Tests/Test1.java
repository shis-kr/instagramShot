package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseInsta;
import PageObjects.AppConstants;
import PageObjects.AppData;

public class Test1 extends BaseInsta{

	@Test
	public static void launch()
	{
		try
		{
			clickId(AppConstants.loginId);
			AssertJUnit.assertTrue(findElementById(AppConstants.loginLogoId).isDisplayed());
			sendKeysforId(AppConstants.userNameId, AppData.instagramPassword);
			sendKeysforId(AppConstants.passwordId, AppData.instagramPassword);
//			clickId(AppConstants.logIn);
			AssertJUnit.assertTrue(findElementById(AppConstants.headerId).isDisplayed());
			clickSearchTab();
			clickId(AppConstants.searchBarId);
			
			sendKeysforId(AppConstants.searchBarId, AppData.searchKeyword);
			
//			clickId(AppConstants.fbloginId);
//			// Switching to webview
//			driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
//			Set<String> contextNames = driver.getContextHandles();
//			for (String contextName : contextNames)
//			{
//				System.out.println(contextNames); //prints out something like [NATIVE_APP, WEBVIEW_<APP_PKG_NAME>]
//			}
////			driver.context(contextNames.toArray()[1]); // set context to WEBVIEW_<APP_PKG_NAME>
////
//////				do web testing
////			String myText = driver.findElement(By.cssSelector(".green_button")).click();
////
//////				Switching back to NATIVE_APP
////			driver.context("NATIVE_APP");
////
//////			 	do more native testing if we want
////			 driver.findElement(By.name("home")).click();
			clickProfileTab();
			AssertJUnit.assertTrue(findElementById(AppConstants.profileActionBar).isDisplayed());
			
			WebElement profileBar = findElementById(AppConstants.profileActionBar);
			WebElement profileOptions = profileBar.findElement(By.className("android.widget.ImageView"));
			profileOptions.click();
			
			for(int i=0;i<10;i++)
			{
				if(driver.findElementsById(AppConstants.logoutCardId).size()>0)
				{
					clickId(AppConstants.logoutCardId);
					break;
				}
				else
				{
					swipeTopVertically();
				}
			}
			AssertJUnit.assertTrue(findElementById(AppConstants.logoutAlertId).isDisplayed());
			clickId(AppConstants.logoutId);
		}
		catch(Exception e)
		{
			e.getStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}
