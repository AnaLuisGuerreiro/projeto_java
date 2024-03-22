package GameStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static GameStart.general_functions.*;

public class functions_cliente {

    /**
     * Apresentação do menu com 8 opções para o cliente
     */
    public static void menuCliente() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        // Ficheiros
        String file_admins = "Ficheiros/GameStart_Admins.csv";
        String file_categorias = "Ficheiros/GameStart_Categorias.csv";
        String file_clientes = "Ficheiros/GameStart_Clientes.csv";
        String file_copyright = "Ficheiros/GameStart_Copyright.csv";
        String file_vendas = "Ficheiros/GameStart_Vendas.csv";

        int opcao=0;

        do {

            // Opções do cliente
            System.out.print("""
                    ------------- Menu Cliente -------------
                    1. Novo registo
                    2. Procurar estacionamento
                    3. Imprimir catálogo
                    4. Imprimir catálogos gráficos
                    5. Imprimir catálogo editora
                    6. Imprimir catálogo por categoria
                    7. Imprimir jogo mais recente
                    8. Sair
                    """);
            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    novoRegisto();
                    break;
                case 2:
                    break;
                case 3:
                    ficheiroParaMatriz(file_vendas);
                    imprimirCatalogo();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
            }


        } while (opcao != 8);

    }


    /** Opção 1
     * Metodo para simular um registo de um novo cliente
     */
    public static void novoRegisto(){
        Scanner input = new Scanner(System.in);

        String nome,email;
        int contacto;

        System.out.println("\nInserir Cliente");
        System.out.print("Insira nome: ");
        nome = input.next();
        System.out.print("Insira contacto: ");
        contacto = input.nextInt();
        System.out.print("Insira email: ");
        email = input.next();

        System.out.println("\nCliente inserido com sucesso: " + nome + " | " + contacto + " | " + email);





    }

    /**
     * Calcular numeros triangulares e multiplos de 5 ate aos 121 lugares existentes
     * @return array de lugares vagos
     */
    public static int procurarEstacionamento(){
       return 1;
    }

    public static void imprimirCatalogo() {

    }

}
