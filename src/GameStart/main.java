package GameStart;

import java.util.Scanner;

import static GameStart.functions.*;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ficheiros
        String file_admins = "Ficheiros/GameStart_Admins.csv";
        String file_categorias = "Ficheiros/GameStart_Categorias.csv";
        String file_clientes = "Ficheiros/GameStart_Clientes.csv";
        String file_copyright = "Ficheiros/GameStart_Copyright.csv";
        String file_vendas = "Ficheiros/GameStart_Vendas.csv";
dfdf
        // Variaveis
        String user;


        // Inicio do programa
        System.out.println("#### \uD83C\uDFAE GAMESTART \uD83C\uDFAE ####");
        System.out.println("##########################");

        System.out.println("Tipo de utilizador (ADMIN || CLIENTE): ");
        user = input.next();

        // Validação e apresentação de menus (Admin ou cliente)
        if(user.equalsIgnoreCase("cliente")){
            menuCliente();
        } else{
            System.out.println("Erro. Digite novamente:");
            user=input.next();
        }


    }
}