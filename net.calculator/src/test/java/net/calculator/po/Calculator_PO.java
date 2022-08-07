package net.calculator.po;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Calculator_PO {
WebDriver driver; 
	
	public Calculator_PO (WebDriver driver) {  // creating constractor
	this.driver = driver;            
	PageFactory.initElements(driver, this); 
	}
	
	@FindBy (how =How.XPATH, using= "//tbody/tr[2]/td[1]/div[1]/div[4]/span[5]")
	WebElement Home_Price;
	
	@FindBy (how =How.XPATH, using= "//h1[contains(text(),'Free Online Calculators')]")
	WebElement Title;
	
	@FindBy (how =How.ID, using= "calcSearchTerm")
	WebElement SearchField;
	
	@FindBy (how =How.ID, using= "bluebtn")
	WebElement Search;
	
	//@FindBy (how =How.XPATH, using= "//tbody/tr[2]/td["+x+"]/div[1]/div["+y+"]/span["+z+"]")
	//WebElement calculator;
	
	@FindBy (how =How.ID, using= "logo")
	WebElement Logo;
	
	
		
	public void calculator(int x,int y,int z) throws InterruptedException
	{
		
		WebElement calculator = driver.findElement(By.xpath("//tbody/tr[2]/td["+x+"]/div[1]/div["+y+"]/span["+z+"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(calculator));
		calculator.click();
		System.out.print(calculator.getText()+ " ");
		
	}
	
	public void Home_Price()
	{
		Home_Price.getText();
		System.out.println(Home_Price.getText());
	}
	
	public void Title()
	{
		Title.getText();
		assert Title != null:"Free Online Calculators";
		System.out.println(Title.getText());
	}
	public void SearchField()
	{
		SearchField.click();
		SearchField.clear();
		SearchField.sendKeys("Test");
		SearchField.isDisplayed();
	}
	public void Search() throws InterruptedException
	{
		Search.isDisplayed();
		Search.getText();
		Thread.sleep(1000);
		//Assert.assertEquals(Search,"Search");
		assert Search != null:"Search"; 
		System.out.println(Search.getText());	 
	}
	public void GetTitle()
	{
		driver.getTitle();
		System.out.println(driver.getTitle());
	}
	public void logo() throws InterruptedException
	{
		Logo.isDisplayed();
		Point logo = Logo.getLocation();
		System.out.println(Logo.getLocation());
		Assert.assertEquals(Logo.getLocation(), logo );
		System.out.println("Logo" + Logo.getLocation() + " location is Verified");
		Logo.getText();
		Assert.assertEquals(Logo.getText(),"" );
		System.out.println("Logo text is ("+ Logo.getText() +") empty");
		Logo.click();
		Thread.sleep(1000);
	}
	
}
