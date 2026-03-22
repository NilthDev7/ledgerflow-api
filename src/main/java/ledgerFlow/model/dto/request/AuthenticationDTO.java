package ledgerFlow.model.dto.request;

public class AuthenticationDTO {

    String login;
    String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return senha;
    }

    public void setPassword(String senha) {
        this.senha = senha;
    }

    public AuthenticationDTO(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
}
