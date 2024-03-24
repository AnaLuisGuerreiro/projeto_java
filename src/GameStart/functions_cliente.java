package GameStart;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static GameStart.functions_general.*;

public class functions_cliente {

    /**
     * Apresentação do menu com 8 opções para o cliente
     */
    public static void menuCliente() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        // Ficheiros
        String file_categorias = "src/Ficheiros/GameStart_Categorias.csv";
        String file_vendas = "src/Ficheiros/GameStart_Vendas.csv";

        // Colocar os ficheiros em matrizes
        String[][] matriz_vendas = ficheiroParaMatriz(file_vendas, ";");

        int opcao=0;
        String editora;

        do {

            // Opções do cliente
            System.out.print("""
                    
                    ------------- Menu Cliente -------------
                    1. Novo registo 📝
                    2. Procurar estacionamento 🚗
                    3. Imprimir catálogo 📗
                    4. Imprimir catálogos gráficos 📕
                    5. Imprimir catálogo editora 📘
                    6. Imprimir catálogo por categoria 📊
                    7. Imprimir jogo mais recente 📅
                    8. Sair 👋
                    """);
            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    novoRegisto();
                    break;
                case 2:
                    System.out.print("""
                                   **** Lugares Vagos ****
                    """);
                    procurarEstacionamento(121);
                    break;
                case 3:
                    imprimirSemDuplicados(matriz_vendas,4);
                    break;
                case 4:
                    menuCatalogos();
                    break;
                case 5:
                    System.out.println("\s\s\s\s\s\s\s**** Pesquisar por editora **** ");
                    System.out.print("Insira a editora: ");
                    editora = input.next();
                    imprimirEditora(matriz_vendas,editora);
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


        // Menu dos catalogos
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

    /** Opção 5
     *
     */
    private static void imprimirEditora(String[][] matrizVendas, String editora) {
        System.out.println("\n----> " + editora + " <----");


    }



}
