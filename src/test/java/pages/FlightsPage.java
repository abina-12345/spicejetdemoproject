package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DivTableUtilitiesClass;

public class FlightsPage {
	
	@FindBy(xpath="//div[@id='list-results-section-0']//div[text()='SpiceMAX']/following::div[2]") public WebElement dt1;
	@FindBy(xpath="//div[@id='list-results-section-1']//div[text()='SpiceMAX']/following::div[2]") public WebElement dt2;
	
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']") public WebElement continu;
	
	public FlightsPage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectLowestFareD(RemoteWebDriver driver)
	{
		DivTableUtilitiesClass obj=new DivTableUtilitiesClass();
		List<WebElement> flights=obj.getChilDivs(dt1);
		int lfare=0;
		for(WebElement flight:flights)
		{
			By b=By.xpath("child::div/div[2]/div[1]//span/parent::div");
			String value=obj.getDivValue(driver, flight, b);
			String num=value.replaceAll("[^0-9]","");
			if(lfare==0)
			{
				lfare=Integer.parseInt(num);
			}
			else if(lfare>Integer.parseInt(num))
			{
				lfare=Integer.parseInt(num);
				flight.findElement(By.xpath("child::div/div[2]/div[1]//*name()='svg']")).click();
			}
		}
		System.out.println(lfare);

	}
	

	public void selectLowestFareR(RemoteWebDriver driver)
	{
		DivTableUtilitiesClass obj=new DivTableUtilitiesClass();
		List<WebElement> flights=obj.getChilDivs(dt2);
		int lfare=0;
		for(WebElement flight:flights)
		{
			By b=By.xpath("child::div/div[2]/div[1]//span/parent::div");
			String value=obj.getDivValue(driver, flight, b);
			String num=value.replaceAll("[^0-9]","");
			if(lfare==0)
			{
				lfare=Integer.parseInt(num);
			}
			else if(lfare>Integer.parseInt(num))
			{
				lfare=Integer.parseInt(num);
				flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name()='svg']")).click();
			}
		}
		System.out.println(lfare);

	}
	
	public void clickContinue() throws Exception
	{
		continu.click();
		Thread.sleep(5000);
	}
	
	public void selectHighestFareD(RemoteWebDriver driver) throws Exception
	{
		driver.manage().window().maximize();
		DivTableUtilitiesClass obj=new DivTableUtilitiesClass();
		List<WebElement> flights=obj.getChilDivs(dt1);
		int hfare=0;
		for(WebElement flight:flights)
		{
			driver.executeScript("arguments[0].scrollIntoView();",flight);
			By b=By.xpath("child::div/div[2]/div[1]//span/parent::div");
			String value=obj.getDivValue(driver, flight, b);
			String num=value.replaceAll("[^0-9]","");
			if(hfare==0)
			{
				hfare=Integer.parseInt(num);
			}
			else if(hfare<Integer.parseInt(num))
			{
				hfare=Integer.parseInt(num);
				
				flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name()='svg']/ancestor::div[2]")).click();
				
			}
		}
		System.out.println(hfare);
		Thread.sleep(6000);


	}
	
	public void selectHighestFareR(RemoteWebDriver driver)
	{
		
		DivTableUtilitiesClass obj=new DivTableUtilitiesClass();
		List<WebElement> flights=obj.getChilDivs(dt2);
		int hfare=0;
		for(WebElement flight:flights)
		{
			driver.executeScript("arguments[0].scrollIntoView();",flight);
			By b=By.xpath("child::div/div[2]/div[1]//span/parent::div");
			String value=obj.getDivValue(driver, flight, b);
			String num=value.replaceAll("[^0-9]","");
			if(hfare==0)
			{
				hfare=Integer.parseInt(num);
			}
			else if(hfare<Integer.parseInt(num))
			{
				hfare=Integer.parseInt(num);
				
				flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name()='svg']/ancestor::div[2]")).click();
				
			}
		}
		System.out.println(hfare);
	}
	
	

}
