package glue;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FlightsPage;
import pages.HomePage;


public class StepDefiniton1 {
	
	
	public SharedClass sh;
	//Dependency injection via constructor
	public StepDefiniton1(SharedClass x) 
	{ 
		sh=x;
	}
	
	@When("open {string} browser")
	public void method1(String bn)
	{
		if(bn.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		sh.driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			sh.driver=new FirefoxDriver();
		}
		
		
		sh.obj1=new HomePage(sh.driver);
		sh.obj2=new FlightsPage(sh.driver);
		
		
		
	}
	
	@When("launch {string} site")
	public void method2(String x) throws Exception
	{
		sh.driver.get(x);
		Thread.sleep(10000);
	}
	@When("select roundtrip")
	public void method() throws Exception
	{
		sh.obj1.clickRtrip();
	}
	
	/*@When("clear the input fields of from city")
	public void method3()
	{
		obj1.clearFrom();
	}
	*/
	
	@When("enter the depart {string} city")
	public void method4(String frm) throws Exception
	{

		sh.obj1.fillFrom(frm);
	}
	
	@When("clear the input fields of to city")
	public void method5()
	{
		sh.obj1.clearTo();
	}
	
	 @When("enter the arrive {string} city")
	 public void method6(String to) throws Exception
	 {
		 sh.obj1.fillTo(to);
		 Thread.sleep(5000); 
		 
	 }
	 
	 @When("select departure {int} ,{string},{int}")
	 public void method7(Integer dy, String dm, Integer dd) throws Exception
	 {
		// obj1.selectDepartureDate(driver,obj, dy, dm, dd);
		 sh.obj1.selectDepartureDate(sh.driver, dy, dm, dd);
		 Thread.sleep(5000);
		 
	 }
	 @When("select return {int} ,{string},{int}")
	 public void method8(Integer dy, String dm, Integer dd) throws Exception
	 {
		 sh.obj1.selectReturnDate(sh.driver, dy, dm, dd);
		 
	 }
	 
	 @When("select search flight")
	 public void method7() throws Exception
	 {
		 sh.obj1.flights(); 
		 
	 }
	 
	 @When("click on lowest fare for departure flight")
	 public void method8()
	 {
		 sh.obj2.selectLowestFareD(sh.driver);
		 
		 
		 
	 }
	 
	 @When("click on lowest fare for return flight")
	 public void method9() throws Exception
	 {
		 sh.obj2.selectLowestFareR(sh.driver);
		 
		 Thread.sleep(5000);
	 }
	 
	 @When("click continue")
	 public void method10() throws Exception
	 {
		 sh.obj2.clickContinue();
	 }
	 
	 @When("close site")
	 public void method11()
	 {
		 sh.driver.close();
	 }
	 
	

}
 