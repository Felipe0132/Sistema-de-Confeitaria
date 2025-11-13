package Controller;

import Entidade.ItemPedido;
import Service.ItemPedidoService;

public class ItemPedidoController {
    private ItemPedidoService service = ItemPedidoService.getInstance();

    private static ItemPedidoController instancia;

    private ItemPedidoController(){
        super();
    }

    public static ItemPedidoController getInstancia(){
        if(instancia == null){
            instancia = new ItemPedidoController();
        }
        return instancia;
    }

    public boolean cadastrarItemPedido(ItemPedido item){
        return service.cadastrarItemPedido(item);
    }
}
