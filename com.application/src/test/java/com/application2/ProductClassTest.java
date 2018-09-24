package com.application2;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductClassTest  {

	ProductClassPage pcp;
	BasePage bp;
	
	ProductClassTest()
	{
		pcp=new ProductClassPage();
		bp=new BasePage();
	}
	
	@Test
	public void firstproductclick() 
	{
		
		pcp.getIframes();
		
	}
	
	@Test(priority=1)
	public void checktwittersharebuttonexit()
	{
		Assert.assertTrue(bp.elementfound(pcp.gettwitterelement()));
		Assert.assertTrue(bp.elementfound(pcp.getshareelement()));
		String text=pcp.getdisplayelement().getText();
		boolean result =pcp.driver.getPageSource().contains(text);
		Assert.assertTrue(result);
	
	}
	
}
