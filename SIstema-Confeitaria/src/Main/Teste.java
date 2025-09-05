package Main;

import Classes.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;


public class Teste {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        JFrame janela = new JFrame();

        // Configuração da Janela
        janela.setLayout(null);

        int altJanela = 600;
        int largJanela = 500;

        janela.setBounds(0, 0, 600, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        // Configuração dos elementos
        JButton botaoCriarProdutoNovo = new JButton("Criar Produto");
        botaoCriarProdutoNovo.setBounds(largJanela/2, 50, 150, 30);

        // Adicionando elementos

        janela.add(botaoCriarProdutoNovo);

        // Ações dos Elementos

        botaoCriarProdutoNovo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janelaDeCadastro = new JFrame("Adicionar Produto");

                janelaDeCadastro.setBounds(0, 0, 250, 350);
                janelaDeCadastro.setLayout(new GridLayout(2, 1));

                JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                JLabel nomeProduto = new JLabel("Nome:");
                nomeProduto.setBounds(30, 30, 40, 30);

                JTextField campoNomeProduto = new JTextField();
                campoNomeProduto.setBounds(80, 30, 50, 30);

                janelaDeCadastro.add(nomeProduto);
                janelaDeCadastro.add(campoNomeProduto);

                janelaDeCadastro.setVisible(true);
            }
        });

        ArrayList<Produto> produtosFeitos = new ArrayList<>();

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

            Produto produto1 = new Produto(nome, peso, listaIngredientes, precoKg);

            produtosFeitos.add(produto1);

            System.out.println("Deseja adicionar algum produto?");
            System.out.println("[1] - SIM");
            System.out.println("[2] - NAO");
            resp = input.nextInt();
            input.nextLine(); // consome o ENTER
        }

        System.out.println("\nProdutos cadastrados:");
        for (Produto p : produtosFeitos) {
            System.out.println(p.getNome());
            p.informacoes();
        }
    }
}
