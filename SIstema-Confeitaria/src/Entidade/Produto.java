package Entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {

    protected String nome;
    protected Integer id;
    protected Double preco;
    protected List<String> ingredientes = new ArrayList<>();
    protected EnumTipo tipo;

    public Produto(String nome, List<String> ingredientes, Double preco) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.preco = preco;
        this.setTipo();
    }

    public void setTipo() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite o tipo do produto:");
            System.out.println("[1] - PorKg");
            System.out.println("[2] - Unitario");

            int escolha = scanner.nextInt();
            if (escolha == 1) {
                this.tipo = EnumTipo.PorKg;
                break;
            } else if (escolha == 2) {
                this.tipo = EnumTipo.Unitario;
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.\n");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double calcularValorFinal(Integer quantidade){
        return this.preco * quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public EnumTipo getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipo tipo) {
        this.tipo = tipo;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
}