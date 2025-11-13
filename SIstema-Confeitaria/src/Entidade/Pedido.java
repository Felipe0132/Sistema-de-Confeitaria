package Entidade;

import java.util.List;

public class Pedido {

    protected Integer id;
    protected Cliente cliente;
    protected List<ItemPedido> produtos;
    protected Double precoFinal;


    public Pedido(Integer id, Cliente cliente, List<ItemPedido> produto, Double preco) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produto;
        this.precoFinal = preco;
    }


    public List<ItemPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ItemPedido> produtos) {
        this.produtos = produtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Double preco) {
        this.precoFinal = preco;
    }
}
