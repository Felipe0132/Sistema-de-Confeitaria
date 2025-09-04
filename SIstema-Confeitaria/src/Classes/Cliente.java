package Classes;

public class Cliente {

    private String nome;
    private String numeroTelefone;
    //private *TIPO* dataAniversario;
    private String cep;
    private String cpf;

    public Cliente(String nome, String numeroTelefone, String cep, String cpf) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.cep = cep;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
}
