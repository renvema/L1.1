package services;

public class UserProfile {
    private final String login;

    public UserProfile(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
