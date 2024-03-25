package GameStart;

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

        for (int l = 0; l < matrizVendas.length; l++) {
            String categoria = matrizVendas[l][3]; // Guardar os 3 paramentros de uma linha
            String jogo = matrizVendas[l][4];
            String editora = matrizVendas[l][2];

            // Verificar se a linha corresponde ao parâmetro fornecido
            if (editora.equalsIgnoreCase(parametro) || categoria.equalsIgnoreCase(parametro)) {

                boolean repetido = false;  // Permite controlar os repetidos
                for (int c = 0; c < l; c++) {
                    if (matrizVendas[c][2].equalsIgnoreCase(editora) && matrizVendas[c][3].equalsIgnoreCase(categoria) && matrizVendas[c][4].equalsIgnoreCase(jogo)) {
                        repetido = true;
                    }
                }

                if (!repetido) { // Se não estiver repetido, imprime
                    if(editora.equalsIgnoreCase(parametro)){  // Consoante o parametro imprimir os relacionados
                        System.out.println("\n++++++++++++++++++++++++++++++++++++++");
                        System.out.println("CATEGORIA: " + categoria);
                    } else{
                        System.out.println("\n++++++++++++++++++++++++++++++++++++++");
                        System.out.println("EDITORA: " + editora);
                    }
                    System.out.println("JOGO: " + jogo);
                    System.out.println("\s\s\s\s\s\s\s\s\s\s\s\s\s\s+++++++++++");
                }
            }
        }
    }

    public static String[][] lerUltimaLinha(String [][] matriz){
        // Criar matriz de 1 linha
        String [][] ultima_linha = new String[1][matriz[0].length];

        // Preencher a ultima linha da matriz
        for (int l = 0; l < matriz[0].length; l++){
            ultima_linha[0][l] = matriz[matriz.length -1][l];
        }

        return ultima_linha;
    }


}
