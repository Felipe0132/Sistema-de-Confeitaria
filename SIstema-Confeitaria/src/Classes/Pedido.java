package Classes;

public class Pedido {

    private Cliente cliente;
    private Produto bolo;


    // CONSTRUTOR

    public Pedido(Cliente cliente, Produto bolo) {
        this.cliente = cliente;
        this.bolo = bolo;
    }

    // ESPECIAIS

    public void removerIngrediente(String ingrediente){
        //TODO
        // Ideia: vamos ter um interface grafica, então o usuario vai ter uma lista de ingredientes que pode remover,
        // são os mesmo que foi adicinado no bolo especifico, assim ele seleciona o ingrediente, vem para essa função
        // e tera uma logica que remove o indice pelo nome
    }

    // GETTERS AND SETTERS

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getBolo() {
        return bolo;
    }

    public void setBolo(Produto bolo) {
        this.bolo = bolo;
    }
}
