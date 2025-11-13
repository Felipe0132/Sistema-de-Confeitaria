package Controller;

import Entidade.Pedido;
import Service.PedidoService;

public class PedidoController {
    private PedidoService service = PedidoService.getInstance();

    private static PedidoController instancia;

    private PedidoController(){
        super();
    }

    public static PedidoController getInstancia(){
        if(instancia == null){
            instancia = new PedidoController();
        }
        return instancia;
    }

    public boolean cadastrarPedido(Pedido pedido){
        return service.cadastrarPedido(pedido);
    }
}