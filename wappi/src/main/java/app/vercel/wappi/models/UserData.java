package app.vercel.wappi.models;

import java.io.File;

public class UserData {

    private final File file;
    private final String name;
    private final String lastName;
    private final String birthDate;
    private final String country;

    public UserData(File file, String name, String lastName, String birthDate, String country) {
        this.file = file;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
    }

    public File getFile() {
        return file;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }

}
