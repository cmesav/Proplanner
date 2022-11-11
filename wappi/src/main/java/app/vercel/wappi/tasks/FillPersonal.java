package app.vercel.wappi.tasks;

import app.vercel.wappi.models.UserData;
import app.vercel.wappi.utils.Generate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

import java.util.logging.Level;
import java.util.logging.Logger;

import static app.vercel.wappi.userinterfaces.Home.*;
import static app.vercel.wappi.userinterfaces.PersonalInformation.*;

public class FillPersonal implements Task {

    @Step("{0} fills the personal information form to update")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Logger logger = Logger.getLogger(FillPersonal.class.getName());

        UserData userData = Generate.userData();

        actor.attemptsTo(
                Click.on(PERSONAL_INFO),
                Enter.keyValues(userData.getFile().getAbsolutePath()).into(UPLOAD_IMAGE),
                Enter.theValue(userData.getName()).into(NAME),
                Enter.theValue(userData.getLastName()).into(LAST_NAME),
                Enter.theValue(userData.getBirthDate()).into(BIRTH_DATE),
                SelectFromOptions.byVisibleText(userData.getCountry()).from(COUNTRY),
                Click.on(GENDER),
                Click.on(SAVE_BUTTON)
        );

        logger.log(Level.INFO, () -> "Personal Info form filled successfully");
    }

    public static FillPersonal information() {
        return Tasks.instrumented(FillPersonal.class);
    }
}
