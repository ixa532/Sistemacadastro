package sistema;

public class Pessoa {

    private String nome;
    private String email;
    private String cidade;

    public Pessoa(String nome, String email, String cidade) {
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }
}