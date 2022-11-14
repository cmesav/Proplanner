package app.vercel.wappi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogIn {

    private LogIn() {
    }

    public static final Target USER_NAME = Target.the("User Name")
            .located(By.id("username"));
    public static final Target PASSWORD = Target.the("Password")
            .located(By.id("password"));

}
