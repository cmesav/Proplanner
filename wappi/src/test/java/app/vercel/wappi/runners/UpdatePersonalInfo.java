package app.vercel.wappi.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/update_personal_info.feature",
        glue = {"app.vercel.wappi.stepdefinitions","app.vercel.wappi.setup"},
        snippets = CucumberOptions.SnippetType.CAMELCASE, tags = "")
public class UpdatePersonalInfo {
}
