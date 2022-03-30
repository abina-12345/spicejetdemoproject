package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/folder", 
                 glue="glue",
                 plugin={"pretty","html:target/myresults"},
                 monochrome=true)

public class MyRunner1 {

}
