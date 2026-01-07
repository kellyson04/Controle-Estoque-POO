package ControleEstoquePOO;

public class CreateUser {
    private String user;
    private String cpf;
    private String password;

    public CreateUser(String user,String cpf,String password) {
        this.user = user;
        this.cpf = cpf;
        this.password = password;
    }

    public String getUser() {
        return this.user;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getPassword() {
        return this.password;
    }
}
