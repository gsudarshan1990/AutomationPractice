package com.application2;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.application2.BasePage;
import com.application2.DressPageObjects;

public class DressPageTest {
	
	DressPageObjects DressPageobj;
	BasePage bp;
	
	
	DressPageTest()
	{
		DressPageobj=new DressPageObjects();
		bp=new BasePage();
	}
	
	@Test(priority=0)
	public void clickdresstab()
	{
		DressPageobj.getDressTab().click();
	}
	
	/*@Test
	public void verifySize()
	{
		
		String textSize=DressPageobj.getSizesmall().getText();
		String[] Size=textSize.split(" ");
		Assert.assertEquals("S", Size[0]);
	}
	
	@Test
	public void verifyMedium()
	{
		
		String textSize=DressPageobj.getSizeMedium().getText();
		String[] Size=textSize.split(" ");
		Assert.assertEquals("M", Size[0]);
	}
	
	@Test
	public void verifyLarge()
	{
		
		String textSize=DressPageobj.getSizeLarge().getText();
		String[] Size=textSize.split(" ");
		Assert.assertEquals("L", Size[0]);
	}*/

	
	@Test(priority=1)
	public void verifynumberofproducts()
	{
		WebElement element=DressPageobj.getproductdisplay();
		int n=bp.count(element);
		//System.out.println(n);
		System.out.println("The number of counts from the products page is:"+n);
		
		int numberfromdresscount=DressPageobj.numberfromdresscount();
		
		if(n==numberfromdresscount)
		{
				System.out.println("The number from text and the count from the dress page item remains same");
		}
		DressPageobj.getDressTab().click();
	}
	
	@Test(priority=2)
	public void verifyfirstProductisaddedtocart()
	{
	
		DressPageobj.clickfirstproduct();
		
		WebElement checkoutelement=DressPageobj.getCheckout();
		
		Assert.assertTrue(bp.elementfound(checkoutelement));
	}
	
	

}
