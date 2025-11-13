package Repositorys;

import Entidade.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private static PedidoRepository instancia;

    private PedidoRepository(){
        super();
    }

    public static PedidoRepository getInstance(){
        if(instancia == null){
            instancia = new PedidoRepository();
        }
        return instancia;
    }

    public boolean inserirPedido(Pedido pedido){
        pedido.setId((pedidos.size() + 1));
        pedidos.add(pedido);
        return true;
    }

    public Pedido buscarPorId(Integer id){
        for(Pedido item: pedidos){
            if(item.getId().equals(id)){
                return item;
            }
        }
        throw new RuntimeException("Item nao localizado");
    }

    public void excluir(Integer id){
        pedidos.remove(this.buscarPorId(id));
    }
}
