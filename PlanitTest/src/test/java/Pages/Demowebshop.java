package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public class Demowebshop 
{
	
	WebDriver driver;
	
	
	public Demowebshop(WebDriver driver)
	{
		this.driver = driver;
	}

	
	By Link = By.xpath("//*[contains(text(),'Log in')]");
	
	By Username = By.id("Email");
	
	By Password = By.id("Password");
	
	By Submit = By.xpath("//input[@value='Log in']");
	
	
	
	public WebElement Login_Link()
	{
		return driver.findElement(Link);
	}
	
	public WebElement Unm()
	{
		return driver.findElement(Username);
	}
	
	public WebElement Pwd()
	{
		return driver.findElement(Password);
	}
	
	public WebElement Loginsubmit()
	{
		return driver.findElement(Submit);
	}
}
