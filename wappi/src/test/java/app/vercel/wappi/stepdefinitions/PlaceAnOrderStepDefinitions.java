package app.vercel.wappi.stepdefinitions;

import app.vercel.wappi.exceptions.PurchaseValidationError;
import app.vercel.wappi.questions.CouponField;
import app.vercel.wappi.questions.PurchaseProduct;
import app.vercel.wappi.tasks.AddProduct;
import app.vercel.wappi.tasks.BuyWith;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static app.vercel.wappi.userinterfaces.Home.CLOSE_MODAL;
import static app.vercel.wappi.utils.Constants.FINAL_VALIDATION;
import static app.vercel.wappi.utils.Constants.FINAL_VALIDATION_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class PlaceAnOrderStepDefinitions {

    @When("I add the product {string} to the cart")
    public void iAddTheProductToTheCart(String product) {
        theActorInTheSpotlight().attemptsTo(
                AddProduct.toCart(product, "no"),
                Click.on(CLOSE_MODAL)
        );
    }

    @Then("I see the product in my orders")
    public void iSeeTheProductInMyOrders() {
        theActorInTheSpotlight().should(
                seeThat(PurchaseProduct.info(), equalTo(FINAL_VALIDATION))
                        .orComplainWith(PurchaseValidationError.class, FINAL_VALIDATION_ERROR)
        );
    }

    @When("I add the products to the cart")
    public void iAddTheProductsToTheCart(List<String> products) {
        theActorInTheSpotlight().attemptsTo(BuyWith.coupon(products));
    }

    @Then("I see the error message {string}")
    public void iSeeTheErrorMessage(String errorMessage) {
        theActorInTheSpotlight().should(seeThat(CouponField.error(),equalTo(errorMessage)));
    }
}
