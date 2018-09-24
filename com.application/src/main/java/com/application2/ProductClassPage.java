package com.application2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductClassPage extends BasePage {
	
	
	@FindBy(xpath="//ul[@id='homefeatured']//li[1]//div[1]//div[1]/div[1]//a[@title='Faded Short Sleeve T-shirts']")
	private WebElement firstelement;
	
	
	private WebElement twitter;
	private WebElement share;
	private WebElement displaytext;
	
	ProductClassPage()
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getfirstelement() {
		
		return firstelement;
		
	}
	

	public void getIframes()
	{
		firstelement.click();
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@id,'fancybox-frame')]")));
		
		twitter=driver.findElement(By.xpath(" //body[@id='product']//div[@itemtype='http://schema.org/Product']/div/div[2]//button[1]"));
		share=driver.findElement(By.xpath(" //body[@id='product']//div[@itemtype='http://schema.org/Product']/div/div[2]//button[2]"));
		displaytext=driver.findElement(By.xpath("//div[@class='primary_block row']/div[2]/div[@id='short_description_block']/div/p"));
		
		
	}
	

	
	
	
	
	public WebElement gettwitterelement()
	{
		return twitter;
	}
	
	public WebElement getshareelement()
	{
		return share;
	}
	
	public WebElement getdisplayelement()
	{
		return displaytext;
	}
}
