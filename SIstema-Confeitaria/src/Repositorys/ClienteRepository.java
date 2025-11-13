package Repositorys;

import Controller.ClienteController;
import Entidade.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private static ClienteRepository instancia; // O que seria isso

    private ClienteRepository(){
        super(); // Duvida do porque
    }

    public static ClienteRepository getInstance(){ // Porque nao pega o Static?
        if (instancia == null){
            instancia = new ClienteRepository();
        }
        return instancia;
    }

    public boolean inserirCliente(Cliente cliente){
        cliente.setId(clientes.size() + 1);
        clientes.add(cliente);
        return true;
    }

    public Cliente buscarPorId(Integer id){
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                return cliente;
            }
        }
        throw new RuntimeException("Cliente nao encontrado!");
    }

    public void excluir(Integer id){
        clientes.remove(this.buscarPorId(id));
    }

    public boolean alterar(Integer id, Cliente cliente){
        Cliente clienteAlteracao = buscarPorId(id);
        if(!clienteAlteracao.getNome().equalsIgnoreCase(cliente.getNome())){
            int indice = clientes.indexOf(clienteAlteracao);
            clienteAlteracao.setNome(cliente.getNome());
            clientes.set(indice, clienteAlteracao);
            return true;
        }

        if(!clienteAlteracao.getCep().equalsIgnoreCase(cliente.getCep())){
            int indice = clientes.indexOf(clienteAlteracao);
            clienteAlteracao.setCep(cliente.getCep());
            clientes.set(indice, clienteAlteracao);
            return true;
        }

        if(!clienteAlteracao.getRestricao() == cliente.getRestricao()){
            int indice = clientes.indexOf(clienteAlteracao);
            clienteAlteracao.setRestricao(cliente.getRestricao());
            clientes.set(indice, clienteAlteracao);
            return true;
        }

        if(!clienteAlteracao.getData().isEqual(cliente.getData())){
            int indice = clientes.indexOf(clienteAlteracao);
            clienteAlteracao.setData(cliente.getData());
            clientes.set(indice, clienteAlteracao);
            return true;
        }
        return false;
    }
}