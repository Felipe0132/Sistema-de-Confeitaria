package Service;

import Entidade.ItemPedido;
import Repositorys.ItemPedidoRepository;

public class ItemPedidoService {
    private ItemPedidoRepository repo = ItemPedidoRepository.getInstance();

    private static ItemPedidoService instancia;

    private ItemPedidoService(){
        super();
    }

    public static ItemPedidoService getInstance(){
        if(instancia == null){
            instancia = new ItemPedidoService();
        }
        return instancia;
    }

    public boolean cadastrarItemPedido(ItemPedido item) {
        if(item.getCliente() == null){
            return false;
        }
        if(item.getPrecoFinal() <= 0 || item.getPrecoFinal().isNaN()){
            return false;
        }
        if(item.getProduto() == null){
            return false;
        }
        if(item.getQuantidade() <= 0){
            return false;
        }

        return repo.inserirItemPedido(item);
    }
}
