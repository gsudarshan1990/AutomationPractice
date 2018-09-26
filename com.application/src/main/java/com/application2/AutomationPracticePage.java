/**
 * 
 */
package com.application2;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sudarshan
 *
 */
public class AutomationPracticePage extends BasePage {
	
	private int count=0;
	
	private WebElement addtocart[]=new WebElement[7];
	
	@FindBy(xpath="//li//a[text()='Women']")
	private WebElement womentab;
	
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li[2]//*[text()='Dresses']")
	private WebElement dresstab;
	
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li[3]//*[text()='T-shirts']")
	private WebElement tshirts;
	
	@FindBy(xpath="//div[@class='columns-container']//div[@id='columns']//*//*[@title='Return to Home']")
	private WebElement movetoHomePage;
	
	@FindBy(xpath="//*[@id='newsletter-input']")
	private WebElement newslettertext;
	
	@FindBy(xpath="//div[@class='form-group']//*[@type='submit']")
	private WebElement newsletterbutton;
	
	
	@FindBys(@FindBy(xpath="//div[@id='center_column']//div//ul[@id='homefeatured']//li"))
	private List<WebElement> dresseslist;
	
	@FindBy(xpath="//ul[@id='homefeatured']//li[1]")
	private WebElement firstdressProduct;
	
	
	
	@FindBy(xpath="//p[contains(@class,'alert alert-success')]")
	private WebElement successmessage;
	
	
	
	public AutomationPracticePage()
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getWomenTab()
	{
		return womentab;
	}
	
	public WebElement getDressesTab()
	{
		return dresstab;
	}
	
	public WebElement getTShirts()
	{
		return tshirts;
	}
	
	public String clickdresstab()
	{
		return clickWebElement(dresstab);
				
	}
	
	public void moveToHomePage()
	{
		movetoHomePage.click();
	}
	
	public String clickwomentab()
	{
		return clickWebElement(womentab);
	}
	
	
	public String clicktshirtstab()
	{
		return clickWebElement(tshirts);
	}
	
	
	public String enternewslettertext(String email)
	{
		newslettertext.sendKeys(email);
		newsletterbutton.click();
		WebElement success=driver.findElement(By.xpath("//p[contains(@class,'alert alert-success')]"));
		String message1=success.getText();
		return message1;
		
	}
	
	public WebElement getSuccessMessage()
	{
		sendemails(newslettertext,newsletterbutton);
		return successmessage;
	}
	
	


	public List<WebElement> getListOfProducts()
	{
		return dresseslist;
	}
	
	public WebElement getaddtocart(WebElement parent)
	{
		mousehover(parent);
		return parent.findElement(By.xpath(".//*[text()='Add to cart']"));
	}
	
	
	
	
	public int mousehover()
	{
		//Actions actions=new Actions(driver);
		//actions.moveToElement(this.firstdressProduct).build().perform();
		//WebElement addtocart=firstdressProduct.findElement(By.xpath("//div//div[@class='right-block']//div[@class='button-container']//a[@title='Add to cart']"));
		//System.out.println(addtocart.getText());
		//addtocart.isDisplayed();
		//System.out.println(dresseslist);
		//System.out.println(dresseslist.size());
		
		
		for(int i=0;i<dresseslist.size();i++)
		{
			Actions actions1=new Actions(driver);
			actions1.moveToElement(this.dresseslist.get(i)).build().perform();
			int number=i+1;
			String elementxpath="//ul[@id='homefeatured']//li["+number+"]//div[@class='product-container']//div[@class='right-block']//div[@class='button-container']//a[@title='Add to cart']";
			
			addtocart[i]=dresseslist.get(i).findElement(By.xpath(elementxpath));
			if(addtocart[i].isDisplayed())
			{
				count++;
			}
		}
		System.out.println(count);
		return count;
	}
	
	public String clicksummerdress()
	{

		driver.navigate().to("http://automationpractice.com/index.php");
		mousehover(dresstab);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class,'menu-content')]//li[2]//ul[contains(@class,'submenu-container')]//li[3]//a[text()='Summer Dresses']")));
		WebElement summerdress1=driver.findElement(By.xpath("//ul[contains(@class,'menu-content')]//li[2]//ul[contains(@class,'submenu-container')]//li[3]//a[text()='Summer Dresses']"));
		mousehover(summerdress1);
		summerdress1.click();
		String Title=driver.getTitle();
		return Title;
				

		
		
		
		
		
	}

}
