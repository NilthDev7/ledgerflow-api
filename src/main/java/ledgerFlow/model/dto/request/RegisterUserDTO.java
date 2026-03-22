package ledgerFlow.model.dto.request;

import ledgerFlow.model.enums.UserRole;

public class RegisterUserDTO {

    private String nome;

    private String login;

    private String senha;

    private UserRole role;

    public RegisterUserDTO(){};

    public RegisterUserDTO(String login, String senha, UserRole role, String nome) {
        this.login = login;
        this.senha = senha;
        this.role = role;
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
