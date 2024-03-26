package GameStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static GameStart.functions_general.*;

public class functions_cliente {


    /** Opção 1
     * Metodo para simular um registo de um novo cliente
     */
    public static void novoRegisto(){
        Scanner input = new Scanner(System.in);

        String nome,email;
        int contacto;

        try {
            System.out.println("\n\s\s\s\s\s\s **** Inserir Cliente ****");
            System.out.print("Insira nome: ");
            nome = input.next();
            System.out.print("Insira contacto: ");
            contacto = input.nextInt();
            System.out.print("Insira email: ");
            email = input.next();

            System.out.println("\n ✅ Cliente inserido com sucesso: " + nome + " | " + contacto + " | " + email );
        } catch (InputMismatchException e){
            System.out.println("Contacto inválido. Deve inserir apenas numeros.");
        }

    }

    /** Opção 2
     * Função para descobrir os numeros triangulares e multiplos de 5 até 121
     * @return numeros correspondentes aos lugares vagos
     */
    public static void procurarEstacionamento(int max){
        int somatorio = 0;

        for (int i = 1; somatorio < max; i++) {
            somatorio += i;
            if (somatorio <= max) {
                if (somatorio % 5 == 0) {
                    System.out.print("\uD83D\uDE98 ");
                    System.out.print(somatorio + " | ");
                }
            }
        }
        System.out.println();
    }


    /** Opção 4
     * Apresenta o menu de catalogos e imprime o selecionado
     * @throws FileNotFoundException
     */
    public static void menuCatalogos() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        // Ficheiros dos jogos
        String file_cod = "src/Ficheiros/CatalogoGrafico/callOfDuty.txt";
        String file_fifa = "src/Ficheiros/CatalogoGrafico/fifa.txt";
        String file_hollow = "src/Ficheiros/CatalogoGrafico/hollowKnight.txt";
        String file_minecraft = "src/Ficheiros/CatalogoGrafico/minecraft.txt";
        String file_mortal = "src/Ficheiros/CatalogoGrafico/mortalKombat.txt";
        String file_over = "src/Ficheiros/CatalogoGrafico/overcooked.txt";
        String file_witcher = "src/Ficheiros/CatalogoGrafico/witcher3.txt";


        // Menu dos catalogos a imprimir
       do {
           System.out.println("""
                          
                          **** Catálogos Gráficos ****
                   1. Call of Duty
                   2. Fifa
                   3. Hollow Knight
                   4. Minecraft
                   5. Mortal Kombat
                   6. Overcooked
                   7. Witcher
                   8. Sair 👋
                   """);
           opcao = input.nextInt();

           switch (opcao){
               case 1:
                   imprimir(file_cod);
                   break;
               case 2:
                   imprimir(file_fifa);
                   break;
               case 3:
                   imprimir(file_hollow);
                   break;
               case 4:
                   imprimir(file_minecraft);
                   break;
               case 5:
                   imprimir(file_mortal);
                   break;
               case 6:
                   imprimir(file_over);
                   break;
               case 7:
                   imprimir(file_witcher);
                   break;
               case 8:
                   break;
               default:
                   System.out.println("Opção inválida digite novamente!");
                   opcao = input.nextInt();
           }
       } while(opcao != 8);
    }

    /** Opção 5 / Opção 6
     * Função que recebe uma categoria ou uma editora inserida pelo utilizador
     * e mostrar o jogo relacionado com os 2 parametros
     */
    public static void imprimirPorEditoraOuCategoria(String[][] matrizVendas, String parametro) {
        System.out.println("\n\s\s\s\s\s\s\s\s\s\s----> " + parametro.toUpperCase() + " <----");


    }


    public static void jogoMaisRecente(String [][] matriz_file){
        String jogo_mais_recente = "";

        for (int l = 0; l < matriz_file.length; l++) {
            String jogo = matriz_file[l][4]; // Guardar o primeiro jogo
            boolean repetido = false;  // Controlar as repetições

            for (int i = 0; i < l; i++) {
                if (matriz_file[i][4].equalsIgnoreCase(jogo)) { // Comparar o jogo atual com os jogos anteriores
                    repetido = true;
                    break;
                }
            }

            if (!repetido) { // Se não for repetido, atualiza o jogo
                jogo_mais_recente = jogo;
            }
        }

        // Retornar o jogo mais recente em um array de string
        System.out.println("\n\s\s\s\s\s\s **** Jogo mais recente ****");
        System.out.println(jogo_mais_recente);
    }


}
