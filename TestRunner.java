package Testrunner;

import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRunner {
	@CucumberOptions(
			features = "./Features",
			glue = {"com.StepDef"},
			tags = {"@UATTesting"},plugin={ "pretty",
				"html:target/site/cucumber-pretty",
				"json:target/cucumber.json"},
				monochrome = true)

			private TestNG CucumberRunner testNG CucumberRunner;
			
			@BeforeClass(alwaysRun = true)
			public void setUp(){
			//To get all the properties in this same class
			testNG CucumberRunner = new TestNG CucumberRunner(this.getClass());
			}

			@Test(dataProvider = "features")
			public void feature(CucumberFeatureWrapper cucumberfeature){
			testNG CucumberRunner.runCucumber(cucumberfeature.getCucumberFeature());
			}
			
		@DataProvider
			public Object[][] features(){
				return testNG CucumberRunner.provideFeatures();
			}
		
		@AfterClass(alwaysRun = true)
		public void tearDownClass(){
			testNG CucumberRunner.finish();
		}


}
