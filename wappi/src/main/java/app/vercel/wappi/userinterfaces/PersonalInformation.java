package app.vercel.wappi.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PersonalInformation {

    private PersonalInformation() {
    }

    public static final Target UPLOAD_IMAGE = Target.the("Select File")
            .locatedBy("(//*[@id='image'])[2]");

    public static final Target NAME = Target.the("Name")
            .located(By.id("name"));

    public static final Target LAST_NAME = Target.the("Last Name")
            .located(By.id("lastName"));

    public static final Target BIRTH_DATE = Target.the("Born Date")
            .located(By.id("bornDate"));

    public static final Target COUNTRY = Target.the("Country")
            .located(By.id("country"));

    public static final Target GENDER = Target.the("Gender")
            .located(By.id("M"));

    public static final Target SAVE_BUTTON = Target.the("Save Button")
            .located(By.id("save-profile"));

    public static final Target CONFIRMATION = Target.the("Confirmation message")
            .locatedBy("//*[@class='confirmation-modal-info']");


}
