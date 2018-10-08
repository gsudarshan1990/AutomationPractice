package com.application2;

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
}
