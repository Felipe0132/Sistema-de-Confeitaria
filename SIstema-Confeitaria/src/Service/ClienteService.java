package Service;

import Entidade.Cliente;
import Repositorys.ClienteRepository;

public class ClienteService {
    private ClienteRepository repo = ClienteRepository.getInstance();

    private static ClienteService instancia;

    private ClienteService(){
        super();
    }

    public static ClienteService getInstance(){
        if(instancia == null){
            instancia = new ClienteService();
        }
        return instancia;
    }

    public boolean cadastrarCliente(Cliente cliente){
        if(cliente.getNome() == null || cliente.getNome().isBlank()){
            return false;
        }

        return repo.inserirCliente(cliente);
    }
}
