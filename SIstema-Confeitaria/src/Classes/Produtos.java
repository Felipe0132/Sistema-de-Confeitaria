package Classes;

import java.util.List;

public class Produtos {

    protected String nome;
    protected double preco;
    protected String tipo;
    private double precoKg;
    private List<String> ingredientes;

    // Construtor

    public Produtos(String nome, String tipo, double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Produtos(String nome, String tipo, double precoKg, List<String> ingrendientes) {
        this.nome = nome;
        this.tipo = tipo;
        this.precoKg = precoKg;
        this.ingredientes = ingrendientes;
    }

    // Especiais

    public void mostrarIngredientes(){

        System.out.println("Lista de ingredientes:");
        for(String ingrediente : this.ingredientes){
            System.out.println(ingrediente);
        }
    }

    public void adicionarIngredientes(String ingrediente){
        this.ingredientes.add(ingrediente);
    }

    public void removerIngredientes(String ingrediente){
        // TODO: fazer a função que remove o ingrediente pelo o nome dele
    }

    // Getters and Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void setPreco(double preco){
        this.preco = preco;
    }

    public double getPrecoKg() {
        return precoKg;
    }

    public void setPrecoKg(double precoKg) {
        this.precoKg = precoKg;
    }

    public List<String> getIngrendientes() {
        return ingredientes;
    }

    public void setIngrendientes(List<String> ingrendientes) {
        this.ingredientes = ingrendientes;
    }

}
