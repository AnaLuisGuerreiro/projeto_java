package GameStart;

import java.util.Scanner;

import static GameStart.functions_cliente.*;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variaveis
        int user;

        // Inicio do programa
        System.out.print("""
                #### \uD83C\uDFAE GAMESTART \uD83C\uDFAE ####
                ##########################
                Utilizador:
                1. Cliente
                2. Admin
                3. Sair
                """);
        user = input.nextInt();

        // Validação e apresentação de menus (Admin ou cliente)
        if(user == 1){
            menuCliente(file_vendas);
        } else{
            System.out.println("Erro. Digite novamente:");
            user=input.nextInt();
        }


    }
}