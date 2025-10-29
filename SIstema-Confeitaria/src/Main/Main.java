package Main;

import Cliente.Cliente;
import ItemParaPedido.ItemPedido;
import ListaDePedidos.Pedidos;
import Produtos.EnumTipo;
import Produtos.Produto;

import java.util.List;

public class Main {
    public static void main(String[] args){

        Cliente c1 = new Cliente("Felpo", "11/03/2006", "35501514",false, "37998700311");
        Cliente c2 = new Cliente("Chicao", "11/03/2006", "35501514",false, "37998700311");
        Cliente c3 = new Cliente("Chicaos", "11/03/2006", "35501514",false, "37998700311");

        Produto p1 = new Produto("Coca", List.of("Açúcar", "Drogas"), 32);
        Produto p2 = new Produto("Fanta", List.of("Açúcar", "Drogas"), 10);

        Pedidos pedidos = new Pedidos();

        ItemPedido iP1 = new ItemPedido(p1, c1, 17.5, 1, pedidos);
        ItemPedido iP2 = new ItemPedido(p2, c1, 17.5, 1, pedidos);

        System.out.println(c1.getData());

        System.out.println(c1.getId());

        System.out.println((c2.getId()));

        System.out.println(c3.getId());

        System.out.println(p1.getId());

        System.out.println(p2.getId());

        iP1.detalhes();

        System.out.println("-----");

        pedidos.imprirClientes();
    }
}
