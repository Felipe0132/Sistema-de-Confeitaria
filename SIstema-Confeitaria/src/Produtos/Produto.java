package Produtos;

import Cliente.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {

    protected String nome;
    protected int id;
    protected double preco;
    protected List<String> ingredientes = new ArrayList<>();
    protected EnumTipo tipo;

    private static List<Produto> produtos = new ArrayList<>();

    Scanner scanner = null;

    public Produto(String nome, List<String> ingredientes, double preco) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.preco = preco;
        this.setTipo();

        if(produtos.isEmpty()){
            this.id = 1;
        }else {
            for (int i = 0; i < Produto.getProdutos().size(); i++) {
                if (i == getProdutos().toArray().length - 1) {
                    this.id = i + 2;
                }
            }
        }

        produtos.add(this);
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
    public void setProdutos(List<Produto> produtos) {
        Produto.produtos = produtos;
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double calcularValorFinal(double quantidade){
        return this.preco * quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

}
