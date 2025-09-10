package Classes;

public class Cliente {

    protected String nome;
    // nascimento
    protected String cep;
    protected String CPF;
    protected String telefone;
    protected boolean restricao;


    // Construtor


    public Cliente(String nome, String cep, String CPF, String telefone, boolean restricao) {
        this.nome = nome;
        this.cep = cep;
        this.CPF = CPF;
        this.telefone = telefone;
        this.restricao = restricao;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean getRestricao() {
        return restricao;
    }

    public void setRestricao(boolean restricao) {
        this.restricao = restricao;
    }
}
