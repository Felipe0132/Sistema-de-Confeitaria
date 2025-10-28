package Repositorys;

import Produtos.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<Produto>();
    private ProdutoRepository instancia; // O que seria isso

    private ProdutoRepository(){
        super(); // Duvida do porque
    }

    public ProdutoRepository getInstance(){ // Porque nao pega o Static?
        if (this.instancia == null){
            this.instancia = new ProdutoRepository();
        }
        return this.instancia;
    }

    public void salvar(Produto produto){
        produto.setId((long) (produtos.size() + 1));
        produtos.add(produto);
    }

    public Produto buscarPorId(Long id){
        for(Produto produto: produtos){
            if(produto.getId() == id){
                return produto;
            }
        }
        throw new RuntimeException("Produto nao encontrado!");
    }

    public void excluir(Long id){
        produtos.remove(this.buscarPorId(id));
    }
}
