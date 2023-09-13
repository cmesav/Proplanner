package app.vercel.wappi.setup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class WappiHook {

    @Managed
    private static WebDriver hisBrowser;

    @Before
    public void setUpOneStage() {
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(hisBrowser)));
        OnStage.theActorCalled("cmesa");
    }

    @After
    public void cerrarElEscenario() {
        OnStage.drawTheCurtain();
    }
}
