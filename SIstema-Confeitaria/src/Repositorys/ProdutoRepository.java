package Repositorys;

import Entidade.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<Produto>();
    private static ProdutoRepository instancia; // O que seria isso

    private ProdutoRepository(){
        super(); // Duvida do porque
    }

    public static ProdutoRepository getInstance(){ // Porque nao pega o Static?
        if (instancia == null){
            instancia = new ProdutoRepository();
        }
        return instancia;
    }

    public boolean inserirProduto(Produto produto){
        produto.setId((produtos.size() + 1));
        produtos.add(produto);
        return true;
    }

    public Produto buscarPorId(Integer id){
        for(Produto produto: produtos){
            if(produto.getId().equals(id)){
                return produto;
            }
        }
        throw new RuntimeException("Produto nao encontrado!");
    }

    public void excluir(Integer id){
        produtos.remove(this.buscarPorId(id));
    }
}
