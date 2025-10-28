package Repositorys;

import ItemParaPedido.ItemPedido;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoRepository {
    private List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
    private ItemPedidoRepository instancia;

    private ItemPedidoRepository(){
        super();
    }

    public ItemPedidoRepository getInstance(){
        if(this.instancia == null){
            this.instancia = new ItemPedidoRepository();
        }
        return this.instancia;
    }

    public void salvar(ItemPedido itemPedido){
        itemPedido.setId((long) (itemPedidos.size() + 1));
        itemPedidos.add(itemPedido);
    }

    public ItemPedido buscarPorId(Long id){
        for(ItemPedido item: itemPedidos){
            if(item.getId() == id){
                return item;
            }
        }
        throw new RuntimeException("Item nao localizado");
    }

    public void excluir(Long id){
        itemPedidos.remove(this.buscarPorId(id));
    }
}
