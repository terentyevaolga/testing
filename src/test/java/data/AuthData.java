package data;

public final class AuthData {
    private final String login;
    private final String password;

    public AuthData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String login() {
        return login;
    }

    public String password() {
        return password;
    }
}
