package app.vercel.wappi.tasks;

import app.vercel.wappi.interaction.Country;
import app.vercel.wappi.models.UserData;
import app.vercel.wappi.userinterfaces.Home;
import app.vercel.wappi.utils.Generate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static app.vercel.wappi.userinterfaces.PersonalInformation.*;

public class FillPersonal implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        UserData userData = Generate.userData();

        actor.attemptsTo(
                Click.on(Home.PERSONAL_INFO),
                Enter.keyValues(userData.getFile().getAbsolutePath()).into(UPLOAD_IMAGE),
                Enter.theValue(userData.getName()).into(NAME),
                Enter.theValue(userData.getLastName()).into(LAST_NAME),
                Enter.theValue(userData.getBirthDate()).into(BIRTH_DATE),
                Country.selection(userData.getCountry()),
                Click.on(GENDER),
                Click.on(SAVE_BUTTON)
        );
    }

    public static FillPersonal information() {
        return Tasks.instrumented(FillPersonal.class);
    }
}
