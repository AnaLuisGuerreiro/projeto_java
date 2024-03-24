package GameStart;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static GameStart.functions_admin.*;
import static GameStart.functions_cliente.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        // Variaveis
        int user;

        // Inicio do programa
        System.out.print("""
                #### \uD83C\uDFAE GAMESTART \uD83C\uDFAE ####
                ##########################
                Utilizador:
                 1. Cliente 🧑
                 2. Admin 🤴
                """);
        user = input.nextInt();

        // Validação e apresentação de menus Cliente
        if(user == 1){
            menuCliente();
        } else{
            System.out.println("Erro. Digite novamente:");
            user=input.nextInt();
        }

        // Validação e apresentação de menus Admin
        if(user == 2){
            menuAdmin();
        } else{
            System.out.println("Erro. Digite novamente:");
            user=input.nextInt();
        }


    }
}