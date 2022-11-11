package app.vercel.wappi.utils;

import app.vercel.wappi.models.LogInInfo;
import app.vercel.wappi.models.UserData;
import com.github.javafaker.Faker;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static app.vercel.wappi.utils.Constants.COUNTRY;
import static app.vercel.wappi.utils.Constants.FILE_PATH;

public class Generate {

    private Generate() {
    }

    private static final Faker FAKER = new Faker(new Locale("en"));

    public static LogInInfo theInfo() {
        return new LogInInfo(
                FAKER.bothify("??????##"),
                FAKER.bothify("???###???")
        );
    }

    public static UserData userData(){
        Date date = FAKER.date().birthday();
        File file = new File(FILE_PATH);
        return new UserData(
                file,
                FAKER.name().firstName(),
                FAKER.name().lastName(),
                new SimpleDateFormat("dd/MM/yyyy").format(date),
                COUNTRY
        );
    }
}
