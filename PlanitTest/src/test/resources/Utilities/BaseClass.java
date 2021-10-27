package Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	
	static WebDriver driver;

	public static WebDriver StartBrowser(String browserName,String url)
	{
	if(browserName.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("chrome"))
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("IE"))
	{
		driver = new InternetExplorerDriver();
	}
	
	driver.manage().window().maximize();
	driver.get(url);
	
	return driver;
}
	
	
}