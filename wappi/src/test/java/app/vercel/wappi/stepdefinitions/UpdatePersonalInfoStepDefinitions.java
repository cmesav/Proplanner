package app.vercel.wappi.stepdefinitions;

import app.vercel.wappi.exceptions.UpdateInfoError;
import app.vercel.wappi.questions.Update;
import app.vercel.wappi.tasks.FillPersonal;
import app.vercel.wappi.tasks.LogIn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import static app.vercel.wappi.utils.Constants.UPDATE_ERROR;
import static app.vercel.wappi.utils.Constants.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePersonalInfoStepDefinitions {

    @Given("I log in the page")
    public void iLogInThePage() {
        theActorInTheSpotlight().wasAbleTo(
                Open.url(URL),
                LogIn.webSite()
        );
    }
    @When("I fill the data")
    public void iFillTheData() {
        theActorInTheSpotlight().attemptsTo(
                FillPersonal.information()
        );
    }
    @Then("I see the message {string}")
    public void iSeeTheMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat(Update.messageIs(), equalTo(message))
                        .orComplainWith(UpdateInfoError.class,UPDATE_ERROR));
    }

}
