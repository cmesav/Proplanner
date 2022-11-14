package app.vercel.wappi.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static app.vercel.wappi.userinterfaces.Home.ERROR_COUPON_FIELD;

public class CouponField implements Question<String> {

    @Step("{0} check the error on coupon field")
    @Override
    public String answeredBy(Actor actor) {
        return ERROR_COUPON_FIELD.resolveFor(actor).getText();
    }

    public static CouponField error() {
        return new CouponField();
    }
}
