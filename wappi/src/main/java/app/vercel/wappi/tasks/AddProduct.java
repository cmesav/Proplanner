package app.vercel.wappi.tasks;

import app.vercel.wappi.models.Product;
import app.vercel.wappi.utils.ReturnProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.logging.Level;
import java.util.logging.Logger;

import static app.vercel.wappi.userinterfaces.Home.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class AddProduct implements Task {

    private final String productName;
    private final String coupon;

    public AddProduct(String productName, String coupon) {
        this.productName = productName;
        this.coupon = coupon;
    }

    @Step("{0} purchase the product")

    @Override
    public <T extends Actor> void performAs(T actor) {

        Logger logger = Logger.getLogger(AddProduct.class.getName());

        Product product = ReturnProduct.info(
                OFFER_INFO.of(productName).resolveAllFor(actor).textContents()
        );

        actor.attemptsTo(
                Click.on(OFFER_BUTTON.of(productName)),
                Ensure.that(MODAL_OFFER_DESCRIPTION).hasText(product.getDescription()),
                Ensure.that(MODAL_OFFER_PRICE).hasText(product.getPrice()),
                Ensure.that(MODAL_OFFER_DATE).text().contains(product.getDate()),
                Ensure.that(MODAL_OFFER_SHIPPING).text().contains(product.getShipping()),
                Ensure.that(MODAL_OFFER_BUSINESS).text().contains(product.getTrade()),
                Ensure.that(MODAL_OFFER_LOCATION).text().contains(product.getAddress())
        );

        if (coupon.equals("yes")){
            String couponCode = actor.recall("coupon");
            actor.attemptsTo(
                    Enter.theValue(couponCode).into(COUPON_FIELD)
            );
        }

        actor.attemptsTo(
                Click.on(ORDER_CONFIRM_BUTTON),
                WaitUntil.the(CONFIRMATION_MODAL, isEnabled()),
                Ensure.that(CONFIRMATION_MODAL).isEnabled()
        );

        actor.remember("product", productName);
        actor.remember("addedProduct", product);

        logger.log(Level.INFO, () -> "Finalize Add product modal");

    }

    public static AddProduct toCart(String productName, String coupon) {
        return Tasks.instrumented(AddProduct.class, productName, coupon);
    }
}
