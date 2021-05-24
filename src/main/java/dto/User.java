package dto;

public class User {
    private String userName;
    private String password;

    public User() {
    }

    public User(String s, String s1) {
        this.userName = s;
        this.password = s1;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public User withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }
}
