package Classes;


import java.util.List;

public class Pedido extends Utils{



    private Produtos produto; //Conferir se pode fazer mais de um produto por pedido    
    private Cliente cliente;
    private List<String> listaIngredientesFinal;
    private int quantidade;
    private String codigo;
    private double precoFinal;
    private boolean pago;
    private boolean concluido;
    private boolean aniversariante;
    private boolean bairroContemplado;


    // Especiais

    public void fazerPedido(Produtos produto, Cliente cliente, int quantidade){

        if(cliente.getRestricao()){
            System.out.println("Lembre que o Cliente tem restrição!!!");
        }

        System.out.println("Deseja adicionar ingrediente?");
        resposta();
        while(resposta()){
            System.out.println("Digite o nome do ingrediente:");
            String ingrediente = input.nextLine();

            this.adicionarIngredientesNome(ingrediente);
            perguntar();
        }

        System.out.println("Deseja remover ingrediente?");
        resposta();
        while(resposta()){
            System.out.println("Digite nome que deseja remover:");
            String ingrediente = input.nextLine();

            this.removerIngredientesNome(ingrediente);
            perguntar();
        }

        System.out.println("Quantos % deseja dar de desconto?");
        double porcentagem = input.nextDouble();
        desconto(produto, porcentagem);

        detalhesPedido();
    }

    private void montandoIngredientes(){
        this.listaIngredientesFinal = this.produto.getIngrendientes();
    }

    public void removerIngredientesNome(String ingrediente){

        for(String ingredientes : this.listaIngredientesFinal){
            if(ingredientes == ingrediente){
                // Remover ingrediente igual
            }
        }
    }

    public void adicionarIngredientesNome(String ingrediente){
        this.listaIngredientesFinal.add(ingrediente);
    }

    public void mostrarIngredientes(){
        for(String ingrediente : this.listaIngredientesFinal){
            System.out.print(ingrediente);
        }
    }

    private void desconto(Produtos produto, double porcent){

        this.precoFinal = precoFinal - descontoAniversario(this.aniversariante) - descontoBairroContemplado(this.bairroContemplado) - descontoPorcentagem(porcent) - descontoUnidades(quantidade);
    }

    private double descontoUnidades(int quantidade){
        if(quantidade >= 50 && quantidade < 100){
            return this.produto.preco * 0.15;
        }

        if(quantidade >= 100){
            return this.produto.preco * 0.30;
        }

        return 0;
    }

    private double descontoPorcentagem(double porcent){
        return this.produto.preco * porcent / 100;
    }

    private double descontoAniversario(boolean aniversariante){
        if(aniversariante){
            return this.produto.preco * 0.2;
        }
        return 0;
    }

    private double descontoBairroContemplado(boolean bairroContemplado){
        if(bairroContemplado){
            return this.produto.preco * 0.1;
        }

        return 0;
    }

    public void detalhesPedido(){
        System.out.println("------ Detalhes do Pedido ------\n");
        System.out.println("produto :........... " + this.produto.getNome());
        System.out.println("Tipo :.............. " + this.produto.getTipo());
        System.out.println("Cliente :........... " + this.cliente.getNome());
        System.out.println("Preço inicial :..... " + this.produto.getPreco());
        System.out.println("Preço final :....... " + this.getPrecoFinal() + "\n");
        System.out.println("Lista de ingredientes:");
        mostrarIngredientes();
    }

    // Getters and Setters


    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
