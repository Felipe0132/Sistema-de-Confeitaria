package Repositorys;

import Entidade.ItemPedido;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoRepository {
    private List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
    private static ItemPedidoRepository instancia;

    private ItemPedidoRepository(){
        super();
    }

    public static ItemPedidoRepository getInstance(){
        if(instancia == null){
            instancia = new ItemPedidoRepository();
        }
        return instancia;
    }

    public boolean inserirItemPedido(ItemPedido itemPedido){
        itemPedido.setId((itemPedidos.size() + 1));
        itemPedidos.add(itemPedido);
        return true;
    }

    public ItemPedido buscarPorId(Integer id){
        for(ItemPedido item: itemPedidos){
            if(item.getId().equals(id)){
                return item;
            }
        }
        throw new RuntimeException("Item nao localizado");
    }

    public void excluir(Integer id){
        itemPedidos.remove(this.buscarPorId(id));
    }
}
