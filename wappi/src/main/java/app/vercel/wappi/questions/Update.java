package app.vercel.wappi.questions;

import app.vercel.wappi.userinterfaces.PersonalInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Update implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return PersonalInformation.CONFIRMATION.resolveFor(actor).getText().trim();
    }

    public static Update messageIs(){
        return new Update();
    }
}
