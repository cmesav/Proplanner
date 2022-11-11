package app.vercel.wappi.utils;

import app.vercel.wappi.models.LogInInfo;
import app.vercel.wappi.models.UserData;
import com.github.javafaker.Faker;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.vercel.wappi.utils.Constants.COUNTRY;
import static app.vercel.wappi.utils.Constants.FILE_PATH;

public class Generate {

    private Generate() {
    }

    private static final Logger logger = Logger.getLogger(Generate.class.getName());


    private static final Faker FAKER = new Faker(new Locale("en"));

    public static LogInInfo theInfo() {

        logger.log(Level.INFO, () -> "Enter to Generate log in data");

        return new LogInInfo(
                FAKER.bothify("??????##"),
                FAKER.bothify("???###???")
        );
    }

    public static UserData userData(){

        logger.log(Level.INFO, () -> "Enter to Generate user info");

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
