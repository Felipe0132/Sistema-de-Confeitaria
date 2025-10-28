package Repositorys;

import Cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private ClienteRepository instancia; // O que seria isso

    private ClienteRepository(){
        super(); // Duvida do porque
    }

    public ClienteRepository getInstance(){ // Porque nao pega o Static?
        if (this.instancia == null){
            this.instancia = new ClienteRepository();
        }
        return this.instancia;
    }

    public void salvar(Cliente cliente){
        cliente.setId(clientes.size() + 1);
        clientes.add(cliente);
    }

    public Cliente buscarPorId(Long id){
        for(Cliente cliente: clientes){
            if(cliente.getId() == id){
                return cliente;
            }
        }
        throw new RuntimeException("Cliente nao encontrado!");
    }

    public void excluir(Long id){
        clientes.remove(this.buscarPorId(id));
    }
}