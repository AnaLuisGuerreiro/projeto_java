package GameStart;

import java.util.Scanner;

import static GameStart.functions_general.imprimir;
import static GameStart.functions_general.imprimirMatriz;

public class functions_admin {
    public static boolean login(String [][] admins){
        Scanner input = new Scanner(System.in);

        String user, pass;
        boolean correto = false;

        do {

            System.out.print("USERNAME: ");
            user = input.next();
            System.out.print("PASSWORD: ");
            pass = input.next();

            for (int l = 0; l < admins.length; l++) {
                for (int c = 0; c < admins[0].length; c++) {
                    if (user.equalsIgnoreCase(admins[l][0]) && pass.equalsIgnoreCase(admins[l][1])) {
                       correto = true;
                    }
                }
            }

            if(!correto){
                System.out.println("Username e/ou password errada.\n");
            }

        } while (!correto);


        return correto;
    }

    public static void consultaFicheiros(String[][] file){
        Scanner input = new Scanner(System.in);

        int opcao;
        do {

            // Opções do Admin
            System.out.print("""
                                        
                               **** Consulta de ficheiros ****
                    1. Vendas
                    2. Clientes
                    3. Categorias
                    4. Sair 👋
                    """);
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    imprimirMatriz(file);
                    break;

            }
        }while (opcao != 4) ;
    }
}
