package Controller;

import Entidade.Produto;
import Service.ProdutoService;

public class ProdutoController {
    private ProdutoService service = ProdutoService.getInstance();

    private static ProdutoController instancia;

    private ProdutoController(){
        super();
    }

    public static ProdutoController getInstancia(){
        if(instancia == null){
            instancia = new ProdutoController();
        }
        return instancia;
    }

    public boolean cadastrarProduto(Produto produto){
        return service.cadastrarProduto(produto);
    }
}
