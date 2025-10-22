package ListaDePedidos;

import Cliente.Cliente;
import ItemParaPedido.ItemPedido;

import java.time.LocalDate;
import java.util.*;

public class Pedidos {

    static Scanner scanner = new Scanner(System.in);

    //protected List<ItemPedido> pedidos;
    protected Cliente cliente;
    protected double precoTotal;
    protected boolean pago;
    protected boolean concluido;
    protected boolean aniversariante = false;
    protected boolean bairroContemplado = false;

    public static Map<Integer, Map<List<ItemPedido>, Double>> pedidos = new HashMap<>();


    public void imprirClientes(){
        System.out.println("Imprimindo Clientes e Dados:");
        for(Map.Entry<Integer, Map<List<ItemPedido>, Double>> entry1 : pedidos.entrySet()){
            double valorFinal = 0;
            int id = entry1.getKey();
            System.out.println("Id do cliente: " + id);

            Map<List<ItemPedido>, Double> map2 = entry1.getValue();

            System.out.print("Lista os pedidos: ");
            for(Map.Entry<List<ItemPedido>, Double> entry2 : map2.entrySet()){
                for(ItemPedido item : entry2.getKey()){
                    System.out.print(item.getProduto().getNome() + ", ");
                }
                valorFinal += entry2.getValue();
            }
            System.out.println("\nValor Final: R$" + valorFinal);
        }
        System.out.println("\n");
    }

    public void definindoMap(ItemPedido iP){

        int clienteId = iP.getCliente().getId();
        double precoItem = iP.getPrecoFinal();

        Map<List<ItemPedido>, Double> mapaInterno = pedidos.getOrDefault(clienteId, new HashMap<>());

        List<ItemPedido> lista = new ArrayList<>();
        lista.add(iP);

        double valor = 0;

        for(ItemPedido item : lista){
            valor += item.getPrecoFinal();
        }
        


        mapaInterno.put(lista, this.atualizarValorTotal(valor, iP));

        pedidos.put(clienteId, mapaInterno);
    }

    private double atualizarValorTotal(double valor, ItemPedido iP){
        
        valor += -darDesconto() - descontoAniversariante(iP.getCliente().getData()) - descontoBairroContemplado(iP.getCliente().getCep()) + aumentarValor();
        return valor;
    }

    private double darDesconto(){
        while (true) {
            try {
                System.out.println("Digite quantos % deseja dar: ");
                double desconto = scanner.nextDouble();

                if (desconto < 0) {
                    throw new IllegalArgumentException("O número deve ser maior ou igual que 0!");
                }
                return this.precoTotal * desconto / 100;
            }catch (NumberFormatException e){
                System.out.println("Erro: entrada inválida. Digite um número decimal.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public double aumentarValor(){
        while (true) {
            try {
                System.out.println("Deseja acrescentar quantos % no valor?");
                double aumento = scanner.nextDouble();

                if (aumento < 0) {
                    throw new IllegalArgumentException("O número deve ser maior ou igual que 0!");
                }
                return this.precoTotal * aumento/100;
            }catch (NumberFormatException e){
                System.out.println("Erro: entrada inválida. Digite um número decimal.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private void defineAniversariante(LocalDate data){
        LocalDate dataAtual = LocalDate.now();

        if(data.getMonth() == dataAtual.getMonth() && data.getDayOfMonth() == dataAtual.getDayOfMonth()){
            this.aniversariante = true;
        }
    }

    private void defineBairroContemplado(){
        while (true) {
            try {

                System.out.println("Digite o Bairro Contemplado:");
                String bairroContemplado = scanner.nextLine();

                if (bairroContemplado.isEmpty()) {
                    throw new IllegalArgumentException("A string não pode estar vazia!");
                }

                if (this.cliente.getBairro() == bairroContemplado) {
                    this.aniversariante = true;
                }else{
                    System.out.println("Bairro ainda nao esta contemplado");
                }
            }catch (Exception e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }
    }

    private double descontoAniversariante(LocalDate data){
        if(this.aniversariante){
            return this.precoTotal * 0.15;
        }
        return 0;
    }

    private double descontoBairroContemplado(String cep){
        if(this.bairroContemplado){
            return this.precoTotal * 0.15;
        }
        return 0;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean getAniversariante() {
        return aniversariante;
    }

    public boolean getBairroContemplado() {
        return bairroContemplado;
    }
}

