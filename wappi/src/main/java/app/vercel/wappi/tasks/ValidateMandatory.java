package app.vercel.wappi.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.util.logging.Level;
import java.util.logging.Logger;

import static app.vercel.wappi.userinterfaces.Home.PERSONAL_INFO;
import static app.vercel.wappi.userinterfaces.PersonalInformation.*;

public class ValidateMandatory implements Task {

    @Step("{0} validate the mandatory fields")

    @Override
    public <T extends Actor> void performAs(T actor) {

        Logger logger = Logger.getLogger(ValidateMandatory.class.getName());

        actor.attemptsTo(
                Click.on(PERSONAL_INFO),
                Enter.theValue("a").into(NAME).thenHit(Keys.BACK_SPACE),
                Enter.theValue("a").into(LAST_NAME).thenHit(Keys.BACK_SPACE),
                Enter.theValue("a").into(BIRTH_DATE).thenHit(Keys.BACK_SPACE),
                SelectFromOptions.byVisibleText("Seleccionar").from(COUNTRY),
                Click.on(GENDER),
                Click.on(SAVE_BUTTON)
        );
        logger.log(Level.INFO, () -> "Personal info form cleared successfully");
    }

    public static ValidateMandatory fields() {
        return Tasks.instrumented(ValidateMandatory.class);
    }
}
