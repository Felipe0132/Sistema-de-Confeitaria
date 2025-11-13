package Service;

import Entidade.Produto;
import Repositorys.ProdutoRepository;

public class ProdutoService {
    private ProdutoRepository repo = ProdutoRepository.getInstance();

    private static ProdutoService instancia;

    private ProdutoService(){
        super();
    }

    public static ProdutoService getInstance(){
        if(instancia == null){
            instancia = new ProdutoService();
        }
        return instancia;
    }

    public boolean cadastrarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            return false;
        }
        if(produto.getPreco() < 0 || produto.getPreco().isNaN()){
            return false;
        }
        if(produto.getTipo() == null){
            return false;
        }
        if(produto.getIngredientes() == null || !produto.getIngredientes().isEmpty()){
            return false;
        }

        return repo.inserirProduto(produto);
    }
}
