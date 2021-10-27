package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Dashboradpage;
import Pages.Demowebshop;
import Utilities.BaseClass;

public class TestCases extends BaseClass
{
	Properties prop;
	
	WebDriver driver;
	
	Demowebshop demoshop;
	
	Dashboradpage dbp;
	
	
	
	
	@BeforeTest
	public void setup() throws IOException
	{
		prop = new Properties();
		 
		 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Utilities\\data.properties");
		 
		 prop.load(fis);
		 
		driver = BaseClass.StartBrowser("chrome", prop.getProperty("url"));
	}
	
	
	@AfterTest
	public void teardown()
	{
		//driver.quit();
		
	}
	
	
	
	@Test
	public void TC1_Login()
	{
		demoshop = new Demowebshop(driver);
		
		demoshop.Login_Link().click();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		demoshop.Unm().sendKeys(prop.getProperty("username"));
		
		demoshop.Pwd().sendKeys(prop.getProperty("password"));
		
		demoshop.Loginsubmit().click();
		
		String Title = driver.getTitle();
		
		System.out.println("The title name is : "+Title);
		
	}
	
	@Test(dependsOnMethods = "TC1_Login")
	public void TC2_Dashboard()
	{
		dbp = new Dashboradpage(driver);
		
		boolean link = dbp.Login_Link().isDisplayed();
		
		Assert.assertTrue(link);
	}
	
	
	@Test(dependsOnMethods = "TC2_Dashboard")
	public void TC3_ItemsaddtoCart() throws InterruptedException
	{
		dbp.Books_Link().click();
		
		String[] ItemNodes = { "Computing", "Fiction"};
		
		List ItemsList = Arrays.asList(ItemNodes);
		
				
		List<WebElement> Books = dbp.Books_Title();

		int BooksCount = Books.size();
		
		int j=0;
		
		for(int i=0;i<BooksCount;i++)
		{
			String bookName = Books.get(i).getText().split(" ")[0];
			
			//System.out.println(bookName);
			
			if(ItemsList.contains(bookName))
			{
				j++;
				
				dbp.Item_button().get(i).click();
				
				Thread.sleep(2000);
				
				boolean confirmation_link = driver.findElement(By.xpath("//*[@class='content']//a")).isDisplayed();
				
				System.out.println(confirmation_link);
				if(j == ItemNodes.length)
				{
					break;
				}
				
			}
		}
		
		Thread.sleep(5000);
		
		dbp.CartLink().click();
		
		String amount = dbp.SubtotalLink().getText();
		
		System.out.println(amount);
		
		dbp.Agreement_link().click();
		
		dbp.Checkout_link().click();
		
	// Selecting the address from drop down
		
		Select seladd = new Select(dbp.Address_dropdown());
		
		List<WebElement> list = seladd.getOptions();
		
		int lc  = list.size();
		
		for(int i=0;i<lc;i++)
		{
			String address = list.get(i).getText();
			
			if(address.contains("New Address"))
			{
				list.get(i).click();
			}
		}
		
		// Selecting the country in dropdwon
		
		Select selcnt = new Select(dbp.CountryId());
		
		List<WebElement> list_cnt = selcnt.getOptions();
		
		int lc_cnt  = list_cnt.size();
		
		for(int i=0;i<lc;i++)
		{
			String country = list_cnt.get(i).getText();
			
			if(country.contains("India"))
			{
				list_cnt.get(i).click();
			}
		}
		
		
		dbp.City().sendKeys(prop.getProperty("City"));
		
		dbp.Address1().sendKeys(prop.getProperty("Address1"));
		
		dbp.Zipcode().sendKeys(prop.getProperty("Zipcode"));
		
		dbp.Phone_number().sendKeys(prop.getProperty("Phone_number"));
		
		dbp.Continue_btn().click();
		
		
		
		
		
		
		
	
	}

}
