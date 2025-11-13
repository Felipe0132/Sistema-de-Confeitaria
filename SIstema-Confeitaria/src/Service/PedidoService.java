package Service;

import Entidade.Pedido;
import Repositorys.PedidoRepository;

public class PedidoService {
    private PedidoRepository repo = PedidoRepository.getInstance();

    private static PedidoService instancia;

    private PedidoService(){
        super();
    }

    public static PedidoService getInstance(){
        if(instancia == null){
            instancia = new PedidoService();
        }
        return instancia;
    }

    public boolean cadastrarPedido(Pedido pedido) {
        if(pedido.getCliente() == null){
            return false;
        }
        if(pedido.getPrecoFinal() <= 0 || pedido.getPrecoFinal().isNaN()){
            return false;
        }
        if(pedido.getProdutos() == null){
            return false;
        }

        return repo.inserirPedido(pedido);
    }
}
