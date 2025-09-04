package Classes;

import java.util.List;

public class Bolo {

    private String nome;
    private double peso;
    private double precoKg;
    private double preco;
    private List<String> ingrendientes;

    // CONSTRUTOR

    public Bolo(String nome, double peso, List<String> ingrendientes, double precoKg) {
        this.nome = nome;
        this.peso = peso;
        this.ingrendientes = ingrendientes;
        this.precoKg = precoKg;
        this.setPreco();
    }

    // ESPECIAIS

    private void setPreco(){
        this.preco = this.precoKg * this.peso;
    }

    private double getPreco(){
        return this.preco;
    }

    public void mostrarIngredientes(){
        System.out.println(" ");
        System.out.println("Lista de ingredientes:");
        for(String ingredientes : ingrendientes){
            System.out.println(ingredientes);
        }
    }

    public void informacoes(){
        System.out.println("------ " + this.getNome() + " ------");
        System.out.println(" ");
        System.out.println("Peso: " + this.getPeso());
        System.out.println("Preço: " + this.getPreco());
        this.mostrarIngredientes();
    }

    // GETTERS AND SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecoKg() {
        return precoKg;
    }

    public void setPrecoKg(double precoKg) {
        this.precoKg = precoKg;
    }

    public List<String> getIngrendientes() {
        return ingrendientes;
    }

    public void setIngrendientes(List<String> ingrendientes) {
        this.ingrendientes = ingrendientes;
    }
}
