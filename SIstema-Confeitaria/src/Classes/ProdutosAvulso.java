package Classes;


public class ProdutosAvulso {

    private String nome;
    private int quantidade;
    private double preco;

    // CONSTRUTOR

    public ProdutosAvulso(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // ESPECIAIS



    public void informacoes(){
        System.out.println("------ " + this.getNome() + " ------");
        System.out.println(" ");
        System.out.println("Quantidade: " + this.getQuantidade());
        System.out.println("Preço: " + this.getPreco());
    }

    // GETTERS AND SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void setPreco(double preco){
        this.preco = preco;
    }

    private double getPreco(){
        return this.preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
