package app.vercel.wappi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Home {

    private Home() {
    }

    public static final Target START = Target.the("Cupons")
            .locatedBy("//*[contains(text(),'Inicio')]");
    public static final Target PERSONAL_INFO = Target.the("Personal Information")
            .locatedBy("//*[contains(text(),'personal')]");

    public static final Target CUPONS = Target.the("Cupons")
            .locatedBy("//*[contains(text(),'Cupones')]");
    public static final Target WELCOME_CUPONS = Target.the("Get welcome coupon")
            .located(By.id("welcome-coupon"));
    public static final Target CUPON_CODE = Target.the("Coupon Code")
            .located(By.id("coupon-code"));
    public static final Target CLOSE_CUPON = Target.the("Coupon Code")
            .locatedBy("//*[@id='coupon-modal']//*[@class='close']");
    public static final Target OFFER_INFO = Target.the("Offers Info {0}")
            .locatedBy("//*[text()='{0}']//parent::tr//child::td");
    public static final Target OFFER_BUTTON = Target.the("Order")
            .locatedBy("//*[text()='{0}']//parent::tr//child::td//child::button");
    public static final Target MODAL_OFFER_DESCRIPTION = Target.the("Modal Offer description")
            .locatedBy("//*[@class='offer-description']");
    public static final Target MODAL_OFFER_PRICE = Target.the("Modal Offer price")
            .locatedBy("//*[@class='offer-price']");
    public static final Target MODAL_OFFER_DATE = Target.the("Modal Offer Date")
            .located(By.cssSelector("span.info:nth-child(1)"));
    public static final Target MODAL_OFFER_SHIPPING = Target.the("Modal Offer Shipping")
            .located(By.cssSelector("span.info:nth-child(2)"));
    public static final Target MODAL_OFFER_BUSINESS = Target.the("Modal Offer Business")
            .located(By.cssSelector("span.info:nth-child(3)"));
    public static final Target MODAL_OFFER_LOCATION = Target.the("Modal Offer Location")
            .located(By.cssSelector("span.info:nth-child(4)"));
    public static final Target ORDER_CONFIRM_BUTTON = Target.the("Order Confirm button")
            .located(By.id("order-confirm"));
    public static final Target CONFIRMATION_MODAL = Target.the("Confirmation message")
            .locatedBy("//app-confirmation-modal//*[@class='confirmation-modal-info']");
    public static final Target COUPON_FIELD = Target.the("Coupon field")
            .located(By.id("coupon"));
    public static final Target ERROR_COUPON_FIELD = Target.the("Error Coupon field")
            .located(By.id("e-coupon"));
    public static final Target CLOSE_MODAL = Target.the("Close confirmation modal")
            .locatedBy("//app-confirmation-modal//*[@class='close']");
    public static final Target PURCHASE_ORDERS = Target.the("Close confirmation modal")
            .locatedBy("//*[contains(text(),'pedidos')]");

}
