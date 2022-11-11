package app.vercel.wappi.models;

import java.io.File;

public class UserData {

    private File file;
    private String name;
    private String lastName;
    private String birthDate;
    private String country;

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

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
