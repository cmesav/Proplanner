package app.vercel.wappi.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Country implements Interaction {

    private final String word;

    public Country(String word) {
        this.word = word;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = getDriver();
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText(word);
    }

    public static Country selection(String word){
        return Tasks.instrumented(Country.class,word);
    }


}
