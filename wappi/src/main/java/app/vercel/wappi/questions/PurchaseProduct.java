package app.vercel.wappi.questions;

import app.vercel.wappi.models.Product;
import app.vercel.wappi.utils.ReturnProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;

import static app.vercel.wappi.userinterfaces.Home.PURCHASE_ORDERS;
import static app.vercel.wappi.userinterfaces.MyOrders.ORDER_INFO;
import static app.vercel.wappi.utils.Constants.FINAL_VALIDATION;

public class PurchaseProduct implements Question<String> {

    @Step("{0} check the purchase order info")

    @Override
    public String answeredBy(Actor actor) {

        String product = actor.recall("product");
        Product addedProduct = actor.recall("addedProduct");
        Product purchaseProduct = ReturnProduct.info(
                ORDER_INFO.of(product).resolveAllFor(actor).textContents()
        );
        actor.attemptsTo(Click.on(PURCHASE_ORDERS));

        if (addedProduct.getDescription().equals(purchaseProduct.getDescription())
                && addedProduct.getPrice().equals(purchaseProduct.getPrice())){
            return FINAL_VALIDATION;
        }else {

            return "error";
        }

    }

    public static PurchaseProduct info(){
        return new PurchaseProduct();
    }

}
