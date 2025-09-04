package Main;

import Classes.Bolo;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args){

        ArrayList<String> listaIngredientes = new ArrayList<>();
        Bolo boloDeChocolate = new Bolo("Bolo de Chocolate", 17, listaIngredientes, 23);

        listaIngredientes.add("Chocolate");

        boloDeChocolate.informacoes();
    }
}
