package com.application2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePage {
	
	public String browser="chrome";
	public static WebDriver driver;

	public BasePage()
	{
		if(driver==null)
		{
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriversImportant\\chromedriver.exe");
				driver=new ChromeDriver();
			}
		}
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public boolean elementfound(WebElement element)
	{
		boolean result=false;
		try
		{
			result = element.isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public int count(WebElement element)
	{
		String str=element.getText();
		String[] allstrings=str.split(" ");
		
		return Integer.parseInt(allstrings[2]);
	}
	
	
	public String clickWebElement(WebElement element)
	{
		element.click();
		String Title=driver.getTitle();
		return Title;
	}
	
	public void sendemails(WebElement newslettertext2, WebElement newsletterbutton2) {
			// TODO Auto-generated method stub
			
		Random r=new Random();
		int value=r.nextInt(5000);
		String email="sudarshan"+String.valueOf(value)+"@gmail.com";
		newslettertext2.sendKeys(email);
		newsletterbutton2.click();
		}
	
	
	public void mousehover(WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
}
