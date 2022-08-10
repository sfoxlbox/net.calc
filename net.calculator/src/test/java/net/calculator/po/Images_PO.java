package net.calculator.po;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Images_PO {
WebDriver driver; 
	
	public Images_PO (WebDriver driver) {  // creating constractor
	this.driver = driver;            
	PageFactory.initElements(driver, this); 
	}
	
	@FindBy (how =How.XPATH, using= "/html[1]/body[1]/div[3]/div[1]/h1[1]")
	WebElement Title2;
	
	
	public void images() throws InterruptedException
	{
		
		
		for (int x =1; x<5;x++)
		{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement images = driver.findElement(By.xpath("//body/div[4]/div/table/tbody/tr/td["+x+"]/div/a"));
		wait.until(ExpectedConditions.visibilityOf(images));
		Actions action = new Actions(driver);
		
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
		
		images.click();
		
		Assert.assertEquals(Title2.getText(),text );
		System.out.println("Picture "+x+ " is displayed");
		Thread.sleep(2000);
		System.out.println("Title is :"+Title2.getText());
		driver.navigate().back();
		
		}
	}
}
