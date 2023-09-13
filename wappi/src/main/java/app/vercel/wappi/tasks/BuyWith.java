package app.vercel.wappi.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.vercel.wappi.userinterfaces.Home.*;

public class BuyWith implements Task {

    private final List<String> products;

    public BuyWith(List<String> products) {
        this.products = products;
    }

    @Step("{0} buy using a coupon code")

    @Override
    public <T extends Actor> void performAs(T actor) {
        Logger logger = Logger.getLogger(BuyWith.class.getName());

        WELCOME_CUPONS.resolveFor(actor).click();
        actor.remember("coupon", CUPON_CODE.resolveFor(actor).getText());
        actor.attemptsTo(Click.on(CLOSE_CUPON),
                Click.on(START)
        );

        for (int i = 0; i < products.size(); i++) {
            actor.attemptsTo(
                    AddProduct.toCart(products.get(i), "yes")
            );
            if (i < products.size() - 1) {
                CLOSE_MODAL.resolveFor(actor).click();
            }
        }

        logger.log(Level.INFO, () -> "Finalize buy with coupon");
    }

    public static BuyWith coupon(List<String> products) {
        return Tasks.instrumented(BuyWith.class, products);
    }
}
