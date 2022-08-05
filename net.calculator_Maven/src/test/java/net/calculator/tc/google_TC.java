package net.calculator.tc;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.calculator.base;
import net.calculator.po.Screenshot_Po;

public class google_TC extends base{
WebDriver driver;
	
	@BeforeMethod
	public void Setup()
	{
		driver = setproperty();
		driver.get("https://www.priceline.com/");
	}
	@Test
	public void Google_PO() throws InterruptedException {
		
		Screenshot_Po x = new Screenshot_Po(driver);
		
		x.move("March", "2023");
	}
	@AfterMethod
	public  void TearDown()
	{
		
		driver.close();
		driver.quit();
		
	}
}