package Main;

import Classes.Produto;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args){

        ArrayList<String> listaIngredientes = new ArrayList<>();
        Produto boloDeChocolate = new Produto("Bolo de Chocolate", 17, listaIngredientes, 23);

        listaIngredientes.add("Chocolate");

        boloDeChocolate.informacoes();
    }
}
