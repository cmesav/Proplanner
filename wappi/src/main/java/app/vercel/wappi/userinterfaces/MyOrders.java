package app.vercel.wappi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MyOrders {

    private MyOrders() {
    }

    public static final Target ORDER_INFO = Target.the("Order Info {0}")
            .locatedBy("//*[text()='{0}']//parent::tr//child::td");
}
