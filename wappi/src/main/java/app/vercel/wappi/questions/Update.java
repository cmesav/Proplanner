package app.vercel.wappi.questions;

import app.vercel.wappi.userinterfaces.PersonalInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.annotations.Step;

public class Update implements Question<String> {

    @Step("{0} check the confirmation message")

    @Override
    public String answeredBy(Actor actor) {
        return PersonalInformation.CONFIRMATION.resolveFor(actor).getText().trim();
    }

    public static Update messageIs(){
        return new Update();
    }
}
