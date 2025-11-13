package Controller;

import Entidade.Cliente;
import Service.ClienteService;

public class ClienteController {

    private ClienteService service = ClienteService.getInstance();

    public static ClienteController instancia;

    private ClienteController(){
        super();
    }

    public static ClienteController getInstance(){
        if(instancia == null){
            instancia = new ClienteController();
        }
        return instancia;
    }

    public boolean cadastrarCliente(Cliente cliente){
        return service.cadastrarCliente(cliente);
    }
}
