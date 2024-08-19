package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/resources/features/loginpage.feature",
			glue= {"stepDefinations"},
			plugin= {"pretty", "html:target/cucumber-reports"},
			monochrome=true,
			publish=true

		)
public class TestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
