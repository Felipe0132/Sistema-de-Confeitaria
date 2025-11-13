package Entidade;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Cliente {

    protected Integer id;
    protected String nome;
    protected LocalDate data; // Data em formato americano
    protected String cep;
    protected String telefone;
    protected Boolean restricao;
    protected String bairro;

    public Cliente(String nome, String data, String cep, Boolean restricao, String telefone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.nome = nome;
        this.data = LocalDate.parse(data, formatter);
        this.cep = cep;
        this.restricao = restricao;
        this.telefone = telefone;
    }

    private void setBairro(){
        // TODO - Funcao que usa o bairro por CEP
    }

    public String getBairro(){
        return this.bairro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getRestricao() {
        return restricao;
    }

    public void setRestricao(boolean restricao) {
        this.restricao = restricao;
    }
}
