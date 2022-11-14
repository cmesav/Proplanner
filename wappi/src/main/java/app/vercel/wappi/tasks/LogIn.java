package app.vercel.wappi.tasks;

import app.vercel.wappi.models.LogInInfo;
import app.vercel.wappi.utils.Generate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.util.logging.Level;
import java.util.logging.Logger;

import static app.vercel.wappi.userinterfaces.LogIn.*;

public class LogIn implements Task {

    @Step("{0} enter the log in info")

    @Override
    public <T extends Actor> void performAs(T actor) {

        Logger logger = Logger.getLogger(LogIn.class.getName());

        LogInInfo logInInfo =Generate.theInfo();

        actor.wasAbleTo(
                Enter.theValue(logInInfo.getUserName()).into(USER_NAME),
                Enter.theValue(logInInfo.getPassword()).into(PASSWORD).thenHit(Keys.ENTER)
        );
        logger.log(Level.INFO, () -> "Log In successfully");
    }

    public static LogIn webSite(){
        return Tasks.instrumented(LogIn.class);
    }

}
