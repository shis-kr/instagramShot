package Base;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.apache.commons.io.FileUtils;

import PageObjects.AppConstants;
import PageObjects.AppData;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class BaseInsta {

	public static AndroidDriver driver = null;
	protected static String packname = null;
	DesiredCapabilities cap;
	File app;
	protected static WebDriverWait wait = null;
	
	protected String Con_Package_Name = "com.instagram.android";
	protected String Con_Activity_Name = "com.instagram.android.activity.MainTabActivity";

	@BeforeMethod
	public AppiumDriver initializeDrivers()
	{
		try
		{
			File AppDir = new File("app");
			File app =new File(AppDir, "com.instagram.android.apk");
			
			cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "Android Device");
			
			cap.setCapability("app", app.getAbsolutePath());
			
			cap.setCapability("app-package", Con_Package_Name);
			cap.setCapability("app-activity", Con_Activity_Name);
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		return driver;
	}
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}
	
	public static MobileElement findElementByClassName(String className)
	{
		return (MobileElement)driver.findElement(By.className(className));
	}
	
	public static MobileElement findElementById(String id)
	{
		return (MobileElement)driver.findElement(By.id(id));
	}
	
	public static MobileElement findElementByName(String name)
	{
		return (MobileElement)driver.findElement(By.name(name));
		
	}
	
	public static MobileElement findElementByXpath(String xpath)
	{
		return (MobileElement) driver.findElement(By.xpath(xpath));
	}
	
	public static void clickId(String id)
	{
		findElementById(id).click();
	}
	
	public static void clickName(String name)
	{
		findElementByName(name).click();
	}
	
	public static void clickClass(String className)
	{
		findElementByClassName(className).click();
	}
	
	public static void clickXpath(String xpath)
	{
		findElementByXpath(xpath).click();
	}
	
	public static List<WebElement> findElementsbyName(String name)
	{
		return driver.findElements(By.name(name));
	}
	
	public static List<WebElement> findElementsbyXpath(String xpath)
	{
		return driver.findElements(By.xpath(xpath));
	}
	
	public static List<WebElement> findElementsbyclassName(String className)
	{
		return driver.findElements(By.className(className));
	}
	
	public static List<WebElement> findElementsbyId(String id)
	{
		return driver.findElements(By.id(id));
	}
	
	public static void  swipeBottomVertically()
	{
		  try
		  {
			  Dimension size = driver.manage().window().getSize();
			  int starty = (int) (size.height * 0.80);
			  int endy = (int) (size.height * 0.20);
			  int startx = size.width / 2;
			  driver.swipe(startx, endy, startx, starty, 3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
	}
	
	public static void swipeTopVertically()
	{
		  try
		  {
			  Dimension size = driver.manage().window().getSize();
			  int starty = (int) (size.height * 0.80);
			  int endy = (int) (size.height * 0.20);
			  int startx = size.width / 2;
			  driver.swipe(startx, starty, startx, endy, 3000);
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
	}
	
	public static void sendKeysforName(String name, String keyword)
	{
		findElementByName(name).sendKeys(keyword);
	}
	
	public static void sendKeysforId(String id,String keyword)
	{
		findElementById(id).sendKeys(keyword);
	}
	
	public static void sendKeysforClassName(String className, String keyword)
	{
		findElementByClassName(className).sendKeys(keyword);
	}
	
	public static void sendKeysXpath(String xpath , String keyword)
	{
		findElementByXpath(xpath).sendKeys(keyword);
	}
	
	public static void hideKeyboard()
	{
		try
		{
			driver.hideKeyboard();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void navigateBack()
	{
		driver.navigate().back();
	}
	
	public static String getIdValue(String id)
	{
		return driver.findElement(By.id(id)).getText();
	}
	
	public static String getClassValue(String className)
	{
		return driver.findElement(By.className(className)).getText();
	}
	
	public static String getNameValue(String name)
	{
		return driver.findElement(By.name(name)).getText();
	}
	
	public static String getXpathValue(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static void clickHome()
	{
		List<WebElement> tabs = findElementsbyId(AppConstants.bottomFieldId);
		tabs.get(0).click();
	}
	
	public static void clickSearchTab()
	{
		List<WebElement> tabs = findElementsbyId(AppConstants.bottomFieldId);
		tabs.get(1).click();
	}
	
	public static void clickPostTab()
	{
		List<WebElement> tabs = findElementsbyId(AppConstants.bottomFieldId);
		tabs.get(2).click();
	}
	
	public static void clickNotificationsTab()
	{
		List<WebElement> tabs = findElementsbyId(AppConstants.bottomFieldId);
		tabs.get(3).click();
	}
	
	public static void clickProfileTab()
	{
		List<WebElement> tabs = findElementsbyId(AppConstants.bottomFieldId);
		tabs.get(4).click();
	}
	
	public static void logout()
	{
		clickProfileTab();
		Assert.assertTrue(findElementById(AppConstants.profileActionBar).isDisplayed());
		
		WebElement profileBar = findElementById(AppConstants.profileActionBar);
		List<WebElement> profileOptions = profileBar.findElements(By.className("android.widget.ImageView"));
		profileOptions.get(1).click();
		
		for(int i=0;i<10;i++)
		{
			if(driver.findElementsByName(AppConstants.LogoutText).size()>0)
			{
				clickName(AppConstants.LogoutText);
				break;
			}
			else
			{
				swipeTopVertically();
			}
		}
		Assert.assertTrue(findElementById(AppConstants.logoutAlertId).isDisplayed());
		clickId(AppConstants.logoutId);
		Assert.assertTrue(findElementById(AppConstants.loginLogoId).isDisplayed());
	}
	
	public static void login()
	{
		clickId(AppConstants.loginId);
		Assert.assertTrue(findElementById(AppConstants.loginLogoId).isDisplayed());
		sendKeysforId(AppConstants.userNameId, AppData.username);
		sendKeysforId(AppConstants.passwordId, AppData.instagramPassword);
		clickId(AppConstants.logIn);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AppConstants.profileActionBar)));
		Assert.assertTrue(findElementById(AppConstants.headerId).isDisplayed());
	}
	
	public static void backbutton()
	{
		clickId(AppConstants.backButtonId);
	}
	
//	public static String screenShot(WebDriver driver, String path, String screenShotName)
//	{
//		String dest = "";
//		try
//		{
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File source = (File) ts.getScreenshotAs(OutputType.FILE);
//			dest = path + "/" + screenShotName + ".png";
//			System.out.println(path);
//			File destination = new File(dest);
//			FileUtils.copyFile(source, destination);
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//			return e.getMessage();
//		}
//		
//		return dest;
//	}

	
	public static void takeScreenShot()
	{
		  String destDir = "screenshots";
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		  new File(destDir).mkdirs();
		  String destFile = dateFormat.format(new Date()) + ".png";

		  try 
		  {
		   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		  }
		  catch (IOException e)
		  {
		   e.printStackTrace();
		  }
	}
	
	public static void searchSomething(String keyword)
	{
		clickSearchTab();
		clickId(AppConstants.searchBarId);	
		sendKeysforId(AppConstants.searchBarId, keyword);
	}
	
	public static void clickSearchTop()
	{
		List<WebElement> tabs = findElementsbyId(AppConstants.searchTabsId);
		tabs.get(0).click();
	}
	
	public static void clickSearchPeople()
	{
		List<WebElement> tabs = findElementsbyId(AppConstants.searchTabsId);
		tabs.get(0).click();
	}
	
	public static void clickSearchTags()
	{
		List<WebElement> tabs = findElementsbyId(AppConstants.searchTabsId);
		tabs.get(0).click();
	}
	
	public static void clickSearchPlaces()
	{
		List<WebElement> tabs = findElementsbyId(AppConstants.searchTabsId);
		tabs.get(0).click();
	}
	
	public static void takeScreenshotProfileImages()
	{
		while(true)
		{	
			if(findElementsbyId(AppConstants.myProfileNameId).size()>0)
			{
				WebElement profileBar = findElementById(AppConstants.myProfileNameId);
				WebElement profileHeadImage = findElementById(AppConstants.profileImageHeaderId);
				Point profileName = profileBar.getLocation();
				int xcordpro = profileName.getX();
				int ycordpro = profileName.getY();
				
				Point profileNameHead = profileHeadImage.getLocation();
				int xcordhead = profileNameHead.getX();
				int ycordhead = profileNameHead.getY();					
				driver.swipe(xcordpro, ycordhead, xcordpro, ycordpro/2, 800);
				System.out.println("swiping for first image");
				takeScreenShot();
			}
			
			else if(findElementsbyId(AppConstants.profileImageHeaderId).size()==2)
			{
				List<WebElement> profileHeader = findElementsbyId(AppConstants.profileImageHeaderId);
				Point profileName = profileHeader.get(1).getLocation();
				int xcordpro = profileName.getX();
				int ycordpro = profileName.getY();
				System.out.println(xcordpro);
				System.out.println(ycordpro);
				
				Point profileNameHead = profileHeader.get(0).getLocation();
				int xcordhead = profileNameHead.getX();
				int ycordhead = profileNameHead.getY();
				System.out.println(xcordhead);
				System.out.println(ycordhead);
				System.out.println("swiping for more images");
				driver.swipe(xcordpro, ycordhead, xcordpro, ycordpro/3, 800);
				
				
				
				
				takeScreenShot();
			}
			
			else
			{
				break;
			}
		}
	}
}