package pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DivCalendarUtility;


public class HomePage {
	
	@FindBy(xpath="//div[text()='From']/following::input[1]") public WebElement from;
	@FindBy(xpath="//div[text()='To']/following::input[1]") public WebElement to;
	
	@FindBy(xpath="//div[@data-testid='round-trip-radio-button']") public WebElement roundtrip;
	@FindBy(xpath="(//div[text()='Search Flight'])[1]/parent::div") public WebElement searchFlight;
	@FindBy(xpath="(//div[contains(@data-testid,'undefined-month')])[1]/ancestor::div[2]") public WebElement calendar;
	
	@FindBy(xpath="(//div[text()='Departure Date']/following::*[name()='svg'])[1]") public WebElement depcalendar;
	@FindBy(xpath="(//div[text()='Return Date']/following::*[name()='svg'])[1]") public WebElement retcalendar;
	
	@FindBy(xpath="//div[@id='list-results-section-0']//div[text()='SpiceMAX']/following::div[2]") public WebElement dt1;
	@FindBy(xpath="//div[@id='list-results-section-1']//div[text()='SpiceMAX']/following::div[2]") public WebElement dt2;
	
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']") public WebElement continu;
	public HomePage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void clickRtrip() throws Exception
	{
		roundtrip.click();
		Thread.sleep(4000);
	}
	
	public void clickFrom()
	{
		from.click();
	}
	
	public void fillFrom(String x) throws Exception
	{
		from.sendKeys(x);
		Thread.sleep(5000);
	}
	
	
	public void clearTo()
	{
		to.clear();
	}
	
	public void fillTo(String x) throws Exception
	{
		to.sendKeys(x);
		Thread.sleep(10000);
	}
	
	
	
	
	public void selectDepartureDate(RemoteWebDriver driver, int x, String y, int z) throws Exception
	{
		
		DivCalendarUtility obj=new DivCalendarUtility();
		obj.selectDate(driver, calendar,x ,y ,z);
		Thread.sleep(10000);
		
	}
	public void selectReturnDate(RemoteWebDriver driver, int x, String y, int z) throws Exception
	{
		DivCalendarUtility obj=new DivCalendarUtility();
		
		obj.selectDate(driver, calendar, x, y, z);
	}
	
	public void flights() throws Exception
	{
		searchFlight.click();
		Thread.sleep(10000);
	}
	
	

}
