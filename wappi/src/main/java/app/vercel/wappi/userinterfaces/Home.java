package app.vercel.wappi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Home {

    private Home() {
    }

    public static final Target PERSONAL_INFO = Target.the("Personal Information")
            .locatedBy("//*[contains(text(),'personal')]");

    public static final Target CUPONS = Target.the("Cupons")
            .locatedBy("//*[contains(text(),'Cupones')]");


}
