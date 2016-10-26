package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseInsta;
import PageObjects.AppConstants;
import PageObjects.AppData;

public class Test1 extends BaseInsta{

	@Test(enabled=false)
	public static void launch()
	{
		try
		{
			login();
			searchSomething(AppData.searchKeyword);
			backbutton();
			logout();
		}
		catch(Exception e)
		{
			e.getStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@Test()
	public static void profileImageScreenshots()
	{
		try
		{
			login();
			searchSomething(AppData.searchKeyword);
			hideKeyboard();
			List<WebElement> searchResult = findElementsbyId(AppConstants.searchRowResultId);
			for(WebElement result : searchResult)
			{
				String userName = result.findElement(By.id(AppConstants.searchRowUserNameId)).getText();
				if(userName.contains(AppData.shishirUserName))
				{
					result.click();
					break;
				}
			}
			Assert.assertTrue(driver.findElement(By.id(AppConstants.myProfileNameId)).isDisplayed());
			driver.findElementById(AppConstants.photoLayoutOneId).click();
			clickId(AppConstants.photoLayoutOneId);
			
			takeScreenshotProfileImages();
			
//			swipeTopVertically();
//			int siz = findElementsbyId(AppConstants.profileImageHeaderId).size();
//			System.out.println(siz);
			
			
			
			
//			WebElement profileBar = findElementById(AppConstants.myProfileNameId);
//			Point profileName = profileBar.getLocation();
//			int xcordpro = profileName.getX();
//			int ycordpro = profileName.getY();
//			System.out.println(xcordpro);
//			System.out.println(ycordpro);
//			
//			WebElement profileHeadImage = findElementById(AppConstants.profileImageHeaderId);
//			Point profileNameHead = profileHeadImage.getLocation();
//			int xcordhead = profileNameHead.getX();
//			int ycordhead = profileNameHead.getY();
//			System.out.println(xcordhead);
//			System.out.println(ycordhead);
//			
//			driver.swipe(xcordhead, ycordhead, xcordpro, ycordpro/2, 800);
//			
			logout();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}
}
