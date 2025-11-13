package Entidade;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class ItemPedido {

    Scanner scanner = new Scanner(System.in);

    protected Produto produto;
    protected Cliente cliente;
    protected Integer id;
    protected Integer quantidade;
    protected Double peso;
    protected Double precoFinal;
    protected List<String> ingredientes;


    public ItemPedido(Produto produto,Cliente cliente, Double peso, Integer quantidade) {
        this.produto = produto;
        this.cliente = cliente;
        this.peso = peso;
        this.quantidade = quantidade;
        this.precoFinal = this.produto.calcularValorFinal(quantidade) * peso;
        this.ingredientes = new ArrayList<>(this.produto.getIngredientes());
        this.removerIngrediente();
        this.adicionarIngrediente();
        this.aumentarValor();

    }

    public ItemPedido(Produto produto,Cliente cliente, Integer quantidade) {
        this.produto = produto;
        this.cliente = cliente;
        this.quantidade = quantidade;
        this.precoFinal = this.produto.calcularValorFinal(quantidade);
        this.ingredientes = new ArrayList<String>(this.produto.getIngredientes());
        this.removerIngrediente();
        this.adicionarIngrediente();
        this.aumentarValor();
    }

    private void atualizarPrecoFinal(){
        this.precoFinal += - descontoUnidade(this.quantidade) - darDesconto() + aumentarValor();
    }

    public Double aumentarValor(){
        while (true) {
            try {
                System.out.println("Deseja acrescentar quantos % no valor?");
                double aumento = scanner.nextDouble();

                if (aumento < 0) {
                    throw new IllegalArgumentException("O número deve ser maior ou igual que 0!");
                }
                return this.precoFinal * aumento/100;
            }catch (NumberFormatException e){
                System.out.println("Erro: entrada inválida. Digite um número decimal.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    private double descontoUnidade(Integer unidade){
        if(produto.getTipo() == EnumTipo.PorKg) {
            if (unidade > 5) {
                return this.precoFinal * 0.15;
            }
        } else if (produto.getTipo() == EnumTipo.Unitario) {
            if (unidade > 70){
                return this.precoFinal * 0.15;
            }
        }
        return 0;
    }

    private double darDesconto(){
        while (true) {
            try {
                System.out.println("Digite quantos % deseja dar: ");
                double desconto = scanner.nextDouble();

                if (desconto < 0) {
                    throw new IllegalArgumentException("O número deve ser maior ou igual que 0!");
                }
                return this.precoFinal * desconto / 100;
            }catch (NumberFormatException e){
                System.out.println("Erro: entrada inválida. Digite um número decimal.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void removerIngrediente(){
        while (true) {
            try {
                if(this.cliente.getRestricao()){
                    System.out.println("LEMBRE QUE O CLIENTE TEM RESTRICOES!");
                }

                System.out.println("Digite o ingrediente que deseja remover: ");
                String ingrediente = scanner.nextLine();

                if (ingrediente.isEmpty()) {
                    throw new IllegalArgumentException("A string não pode estar vazia!");
                }

                if (this.ingredientes.remove(ingrediente)) {
                    System.out.println("Elemento removido!");
                } else {
                    System.out.println("Elemento nao encontrado!");
                    return;
                }
            }catch (Exception e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }
    }

    public void adicionarIngrediente(){
        while (true) {
            try {

                System.out.println("Digite o ingrediente que deseja adicionar: ");
                String ingrediente = scanner.nextLine();

                if (ingrediente.isEmpty()) {
                    throw new IllegalArgumentException("A string não pode estar vazia!");
                }

                if (this.ingredientes.remove(ingrediente)) {
                    System.out.println("Elemento Adcionado!");
                } else {
                    System.out.println("Elemento nao adicionado!");
                    return;
                }
            }catch (Exception e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }
    }

    public void detalhes(){
        System.out.println("----- INFORMAÇÕES -----");
        System.out.println("ID         : " + this.getId());
        System.out.println("Produto    : " + this.produto.getNome());
        System.out.println("Cliente    : " + this.cliente.getNome());
        System.out.println("Preço Final: " + this.precoFinal);
        System.out.println("Quantidade : " + this.quantidade);
        System.out.println("Ingredentes: " + this.ingredientes);
        if(produto.getTipo() == EnumTipo.PorKg){
            System.out.println("Peso       : " + this.peso);

        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }
}

