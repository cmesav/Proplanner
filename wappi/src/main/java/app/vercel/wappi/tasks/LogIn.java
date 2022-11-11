package app.vercel.wappi.tasks;

import app.vercel.wappi.models.LogInInfo;
import app.vercel.wappi.utils.Generate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static app.vercel.wappi.userinterfaces.LogIn.*;

public class LogIn implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        LogInInfo logInInfo =Generate.theInfo();

        actor.wasAbleTo(
                Enter.theValue(logInInfo.getUserName()).into(USER_NAME),
                Enter.theValue(logInInfo.getPassword()).into(PASSWORD).thenHit(Keys.ENTER)
        );

    }

    public static LogIn webSite(){
        return Tasks.instrumented(LogIn.class);
    }

}
