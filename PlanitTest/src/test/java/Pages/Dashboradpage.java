package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboradpage 
{
	
	WebDriver driver;
	
	
	
	public Dashboradpage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	By UnmLink = By.xpath("//a[contains(text(),'testdemo')]");
	
	By bookslink = By.xpath("//*[@class='top-menu']//li//a[contains(text(),'Books')]");
	
	By Booktile = By.xpath("//*[@class='product-title']");
	
	By Itembutton = By.xpath("//*[@class='product-item']//*[@class='buttons']");
	
	By cart_link = By.xpath("(//span[@class='cart-label'])[1]");
	
	By Subtotal_Link = By.xpath("//table[@class='cart-total']//tbody//tr");
	
	By agreement_link = By.id("termsofservice");
	
	By checkout = By.id("checkout");
	
	By address_dropdown = By.id("billing-address-select");
	
	By countryId =  By.id("BillingNewAddress_CountryId");
	
	By city = By.id("BillingNewAddress_City");
	
	By address1 = By.id("BillingNewAddress_Address1");
	
	By zipcode = By.id("BillingNewAddress_ZipPostalCode");
	
	By phone_number = By.id("BillingNewAddress_PhoneNumber");
	
	By continue_btn = By.xpath("//*[@id='billing-buttons-container']//input");
	
	
	public WebElement Login_Link()
	{
		return driver.findElement(UnmLink);
	}
	
	
	public WebElement Books_Link()
	{
		return driver.findElement(bookslink);
	}
	
	
	public List<WebElement> Books_Title()
	{
		return driver.findElements(Booktile);
	}
	
	public List<WebElement> Item_button()
	{
		return driver.findElements(Itembutton);
	}
	
	public WebElement CartLink()
	{
		return driver.findElement(cart_link);
	}
	
	public WebElement SubtotalLink()
	{
		return driver.findElement(Subtotal_Link);
	}
	
	
	public WebElement Agreement_link()
	{
		return driver.findElement(agreement_link);
	}
	
	public WebElement Checkout_link()
	{
		return driver.findElement(checkout);
	}
	
	
	public WebElement Address_dropdown()
	{
		return driver.findElement(address_dropdown);
	}
	
	
	public WebElement CountryId()
	{
		return driver.findElement(countryId);
	}
	
	
	public WebElement City()
	{
		return driver.findElement(city);
	}
	
	public WebElement Address1()
	{
		return driver.findElement(address1);
	}
	
	public WebElement Zipcode()
	{
		return driver.findElement(zipcode);
	}
	
	public WebElement Phone_number()
	{
		return driver.findElement(phone_number);
	}
	
	
	public WebElement Continue_btn()
	{
		return driver.findElement(continue_btn);
	}


}
