package Task19;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/feature"}, plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, glue = {"Task19/steps"})
public class Task19 extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
