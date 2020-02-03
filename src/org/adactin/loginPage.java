package org.adactin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginPage {
	WebDriver driver;
	String url="https://www.adactin.com/HotelApp/index.php";
	
	@BeforeSuite
	public void getBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\EclipseWorkSpace\\Adactin\\dri\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
	@Test(priority=0)
	@Parameters({"uname","pword"})
	public void voidfilltxt(String un, String pw)
	{
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pw);
	}
	@Test(dependsOnMethods= {"voidfilltxt"})
	public void btnclick()
	{
		driver.findElement(By.id("login")).click();
	}

	@Test(priority=1)
	@Parameters({"selectid","selectval","datein","dateout"})
	public void selectdrop(String ids, String val, String di, String dot)
	{
		String selectlist[] = ids.split(",");
		String selectval[] = val.split(",");
		
		for(int i=0; i<selectlist.length;i++)
		{
			WebElement selid = driver.findElement(By.id(selectlist[i]));
			Select sel = new Select(selid);
			sel.selectByVisibleText(selectval[i]);		
		}
		
		WebElement dain = driver.findElement(By.id("datepick_in"));
		WebElement daout = driver.findElement(By.id("datepick_out"));
		dain.clear();
		dain.sendKeys(di);
		daout.clear();
		daout.sendKeys(dot);	
	}
	
	@AfterSuite
	public void closebrowser()
	{		
		
//		driver.close();
	}
}
