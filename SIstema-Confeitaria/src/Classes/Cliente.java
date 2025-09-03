package Classes;

public class Cliente {

    private String nome;
    private String numeroTelefone;
    //private *TIPO* dataAniversario;
    private String cep;
    private String cpf;
    private boolean restricao;

    public Cliente(String nome, String numeroTelefone, String cep, String cpf, boolean restricao) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.cep = cep;
        this.cpf = cpf;
        this.restricao = restricao;
    }


}
