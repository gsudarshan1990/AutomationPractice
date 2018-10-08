package com.application2;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.application2.AutomationPracticePage;

public class AutomationPracticeTestPage {

	AutomationPracticePage app;


	
	public AutomationPracticeTestPage()
	{
		app=new AutomationPracticePage();
		
	}



	@Test
	public void verifywomentab()
	{
		
		Assert.assertTrue(app.elementfound(app.getWomenTab()));
	
	}
	@Test
	public void verifydresstab()
	{
		Assert.assertTrue(app.elementfound(app.getDressesTab()));
	}
	
	@Test
	public void verifytshirts()
	{
		Assert.assertTrue(app.elementfound(app.getTShirts()));
	}

	
	
	@Test
	public void verifywomentabclick()
	{
		String Title=app.clickwomentab();
		Assert.assertEquals(Title, "Women - My Store");
		app.driver.navigate().back();
	}
	
	@Test
	public void verifydresstabclick()
	{
		String Title=app.clickdresstab();
		Assert.assertEquals(Title, "Dresses - My Store");
		app.driver.navigate().back();
	}
	
	@Test
	public void verifytshirtstabclick()
	{
		String Title=app.clicktshirtstab();
		Assert.assertEquals(Title, "T-shirts - My Store");
		app.driver.navigate().back();
	}

	@Test(dependsOnMethods = { "verifywomentabclick" ,"verifydresstabclick","verifytshirtstabclick"}, enabled=false)
	public void verifynewsletter()
	{
		app.enternewslettertext("suda@gmail.com");
	}
	
	@Test(dependsOnMethods = { "verifywomentabclick" ,"verifydresstabclick","verifytshirtstabclick"})
	public void randomemailaddress()
	{
		Assert.assertTrue(app.getSuccessMessage().getText().contains("Newsletter : You have successfully subscribed to this newsletter."));
		app.driver.navigate().back();
	}
	
/*	@Test(dependsOnMethods= {"randomemailaddress"})
	public void checkAddToCart()
	{
		int count=app.mousehover();
		Assert.assertEquals(7, count);
		
	}*/
	
	@Test(dependsOnMethods= {"randomemailaddress"})
	public void verifyAddToCart()
	{
		System.out.println(app.getListOfProducts().size());
		
		for(WebElement e:app.getListOfProducts())
		{
			Assert.assertTrue(app.elementfound(app.getaddtocart(e)));
		}
	}

	
	@Test(dependsOnMethods= {"verifyAddToCart"},groups="first group")
	public void clicksummerdresslink()
	{
		String expected=app.clicksummerdress();
		Assert.assertEquals("Summer Dresses - My Store", expected);
	}
}

