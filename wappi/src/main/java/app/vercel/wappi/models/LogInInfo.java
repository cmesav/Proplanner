package app.vercel.wappi.models;

public class LogInInfo {

    private final String userName;
    private final String password;

    public LogInInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
