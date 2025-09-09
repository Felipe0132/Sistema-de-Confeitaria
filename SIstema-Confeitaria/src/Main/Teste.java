package Main;

import Classes.ProdutosAvulso;
import Classes.ProdutosFeitos;

import java.util.ArrayList;
import java.util.Scanner;


public class Teste {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        ArrayList<ProdutosFeitos> listaDeProdutosFeitos = new ArrayList<>();

        int resp, resp2;

        System.out.println("Deseja adicionar algum produto?");
        System.out.println("[1] - SIM");
        System.out.println("[2] - NAO");
        resp = input.nextInt();
        input.nextLine(); // consome o ENTER


        while(resp != 2){

            ArrayList<String> listaIngredientes = new ArrayList<>();

            System.out.println("Digite o nome do produto:");
            String nome = input.nextLine();

            System.out.println("Digite o peso do produto (Em Kg)");
            double peso = input.nextDouble();
            input.nextLine(); // consome o ENTER

            System.out.println("Digite os ingredientes que deseja colocar:");
            do{
                System.out.println("Digte o ingrediente:");
                String ingrediente = input.nextLine();

                listaIngredientes.add(ingrediente);

                System.out.println("Deseja adicionar algum ingrediente?");
                System.out.println("[1] - SIM");
                System.out.println("[2] - NAO");
                resp2 = input.nextInt();
                input.nextLine(); // consome o ENTER
            }while(resp2 != 2);

            System.out.println("Digite o preço por Kg:");
            double precoKg = input.nextDouble();
            input.nextLine(); // consome o ENTER

            ProdutosFeitos produto1 = new ProdutosFeitos(nome, peso, listaIngredientes, precoKg);

            listaDeProdutosFeitos.add(produto1);

            System.out.println("Deseja adicionar algum produto?");
            System.out.println("[1] - SIM");
            System.out.println("[2] - NAO");
            resp = input.nextInt();
            input.nextLine(); // consome o ENTER
        }

        System.out.println("\nProdutos cadastrados:");
        for (ProdutosFeitos p : listaDeProdutosFeitos) {
            System.out.println(p.getNome());
            p.informacoes();
        }
    }
}
