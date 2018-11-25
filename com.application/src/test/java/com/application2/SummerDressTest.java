package com.application2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SummerDressTest {

	SummerDressObjects summerobjects;
	SummerDressTest()
	{
		summerobjects=new SummerDressObjects();
	}	
	@Test(dependsOnGroups = { "first group" })
	public void selectAtoZ() 
	{
		summerobjects.selectAtoZOption();		
		Assert.assertTrue(summerobjects.checkOrder());
	}
	
	@Test(dependsOnMethods= {"selectAtoZ"})
	public void reduceprice()
	{
		summerobjects.clicklist();
		List<WebElement> discounttag=new ArrayList<WebElement>();
		discounttag=summerobjects.getDiscountRedTag();
		
		for(WebElement discountelement:discounttag)
		{
			Assert.assertTrue(summerobjects.elementfound(discountelement));
		}
	}
}
