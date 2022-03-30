package glue;



import io.cucumber.java.en.When;


public class StepDefiniton2 {
	
	public SharedClass sh;
	//Dependency injection via constructor
	public StepDefiniton2(SharedClass x)
	{ 
		sh=x; 
	}
	
	 @When("click on highest fare for departure flight")
	 public void method11() throws Exception
	 {
		 sh.obj2.selectHighestFareD(sh.driver);
		 
	 }
	 
	 @When("click on highest fare for return flight")
	 public void method12() throws Exception
	 {
		 sh.obj2.selectHighestFareR(sh.driver);
		 Thread.sleep(5000);
	 }
}