package Classes;

import java.util.Scanner;

public class Utils { // Classe para adicionar comandos longos utils orem não aproprios para as classes do promgramawr

    Scanner input = new Scanner(System.in);

    public boolean resposta(){
        System.out.println("[1] - SIM");
        System.out.println("[2] - NAO");
        int resp = input.nextInt();
        input.nextLine();

        if(resp == 1){
            return true;
        }else{
            return false;
        }
    }

    public void perguntar(){
        System.out.println("Deseja novamente?");
        resposta();
    }
}
