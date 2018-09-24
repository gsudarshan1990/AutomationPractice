package com.application2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DressPageObjects extends BasePage {

	
	@FindBy(xpath="//*[@id='ul_layered_id_attribute_group_1']/li[1]/label//a")
	private WebElement dresssizesmall;
	
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li[2]//*[text()='Dresses']")
	private WebElement dresstab;
	
	@FindBy(xpath="//*[@id='ul_layered_id_attribute_group_1']//li[2]//a[text()='M']")
	private WebElement dresssizemedium;
	
	@FindBy(xpath="//*[@id='ul_layered_id_attribute_group_1']/li[3]//a[text()='L']")
	private WebElement dresssizelarge;
	
	@FindBy(xpath="//div[@id='center_column']//h1//span[2]")
	private WebElement numberofproductdisplay;
	
	@FindBys(@FindBy(xpath="//ul[@class='product_list grid row']/li"))
	private List<WebElement> list;
	
	@FindBy(xpath="//ul[@class='product_list grid row']//li[1]")
	private WebElement firstelement;
	 
	private WebElement checkout;
	

	
	public DressPageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSizesmall()
	{
		return dresssizesmall;
		
		
	}
	
	public WebElement getDressTab()
	{
		return dresstab;
	}
	
	public WebElement getSizeMedium()
	{
		return dresssizemedium;
	}
	
	public WebElement getSizeLarge()
	{
		return dresssizelarge;
	}

	
	public WebElement getproductdisplay()
	{
		return numberofproductdisplay;
	}

	public int numberfromdresscount()
	{
		int number=list.size();
		return number;
	}
	
	public WebElement FirstProduct()
	{
		return firstelement;
	}
	
	public void clickfirstproduct()
	{
		Actions action = new Actions(driver);
		
		Actions actions1=action.moveToElement(firstelement);
		
		actions1.build().perform();
		
		driver.findElement(By.xpath("//ul[@class='product_list grid row']//li[1]//div[@class='right-block']//div[@class='button-container']//a[@title='Add to cart']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Proceed to checkout")));
		
		checkout=driver.findElement(By.xpath("//div[@id='layer_cart']//div[@class='button-container']//a[@title='Proceed to checkout']"));
		
		
	}
	
	

	public WebElement getCheckout() {
		
		return checkout;
	}
	
	
}
