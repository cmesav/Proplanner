package app.vercel.wappi.stepdefinitions;

import app.vercel.wappi.exceptions.UpdateInfoError;
import app.vercel.wappi.questions.Update;
import app.vercel.wappi.tasks.FillPersonal;
import app.vercel.wappi.tasks.LogIn;
import app.vercel.wappi.tasks.ValidateMandatory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;

import static app.vercel.wappi.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static app.vercel.wappi.userinterfaces.PersonalInformation.*;

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

    @When("I send the personal info form void")
    public void iSendThePersonalInfoFormVoid() {
        theActorInTheSpotlight().attemptsTo(
                ValidateMandatory.fields()
        );
    }

    @Then("I see the error in the mandatory fields")
    public void iSeeTheErrorInTheMandatoryFields() {

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(FIELD_ERROR_MESSAGE.of("1")).text().isEqualTo(IMAGE_ERROR),
                Ensure.that(FIELD_ERROR_MESSAGE.of("2")).text().isEqualTo(NAME_ERROR),
                Ensure.that(FIELD_ERROR_MESSAGE.of("3")).text().isEqualTo(LAST_NAME_ERROR),
                Ensure.that(FIELD_ERROR_MESSAGE.of("4")).text().isEqualTo(DATE_ERROR),
                Ensure.that(FIELD_ERROR_MESSAGE.of("5")).text().isEqualTo(COUNTRY_ERROR)
        );
    }
}
