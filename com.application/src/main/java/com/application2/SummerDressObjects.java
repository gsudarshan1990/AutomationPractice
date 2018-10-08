package com.application2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDressObjects extends BasePage {

	
	@FindBy(xpath="//*[@id='selectProductSort']")
	private WebElement summerdressdropdown;

	private List<String> DressStringdetails=new ArrayList<String>();
	private List<WebElement> listafterload;
	
	SummerDressObjects()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSummerDressDropDown()
	{
		return summerdressdropdown;
	}
	
	public List<WebElement> getAtoZoption()
	{
		return listafterload;
	}
	
	public List<String> getAtoZOptionsTextValue()
	{
		return DressStringdetails;
	}
	public void selectAtoZOption() 
	{
		WebElement dropdownmenu=getSummerDressDropDown();
		Select select=new Select(summerdressdropdown);
		
		if(select.isMultiple())
		{
			
		}
		else
		{
			select.selectByValue("name:asc");
			WebDriverWait wait=new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("ul/p/img")));
			listafterload=driver.findElements(By.xpath(".//*[@id='center_column']/ul/li"));
			for(WebElement element:listafterload)
			{
				
				String value=getStringDetails(element);
				DressStringdetails.add(value);
			}
		}

	}
	
	public String getStringDetails(WebElement parent)
	{
		
		WebElement anchor=parent.findElement(By.xpath(".//a[@class='product-name']"));
		return anchor.getText();
	}

	public boolean checkOrder()
	{
		boolean isSorted=true;
		for(int i=0;i<DressStringdetails.size()-1;i++)
		{
			if(DressStringdetails.get(i+1).compareTo(DressStringdetails.get(i))<0)
			{
				isSorted=false;
			}
		}
		return isSorted;
	}
}
