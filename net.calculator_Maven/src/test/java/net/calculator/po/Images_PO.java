package net.calculator.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class Images_PO {
WebDriver driver; 
	
	public Images_PO (WebDriver driver) {  // creating constractor
	this.driver = driver;            
	PageFactory.initElements(driver, this); 
	}
	
	@FindBy (how =How.TAG_NAME, using= "h1")
	WebElement Title2;
	
	public void images() throws InterruptedException
	{
		for (int x =1; x<5;x++)
		{
		WebElement images = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[\"+x+\"]/div[1]/a"));
		
		WebElement logo = driver.findElement(By.xpath("//tbody/tr[1]/td["+x+"]/div[1]/a[1]/img[1]"));
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		SoftAssert sa = new SoftAssert();
		
		action.sendKeys(Keys.F5);
		String text;
		switch (x) {
		case 1 : text ="Financial Calculators";
		break;
		case 2 : text ="Fitness and Health Calculators";
		break;
		case 3 : text ="Math Calculators";
		break;
		case 4 : text ="Other Calculators";
		break;
		default: text = "fix"; 
		}
		
		sa.assertEquals(logo.isDisplayed(), true);
		System.out.println("Logo "+x+ " is Asserted");
		images.click();
		Thread.sleep(1000);
		sa.assertEquals(Title2.getText(),text );
		System.out.println("Title Text "+x+ " is Asserted");
		driver.navigate().back();
		Thread.sleep(1000);
		}
	}
}
