package GameStart;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static GameStart.functions_admin.*;
import static GameStart.functions_cliente.*;
import static GameStart.functions_general.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        // Variaveis cliente
        int user;
        int opcao_cliente = 0;
        String editora, categoria;
        Double total_vendas;

        // Variaveis admin
        int opcao_admin = 0;
        double lucro_total;
        String id_cliente, jogo;

        // Ficheiros
        String file_categorias = "src/Ficheiros/GameStart_Categorias.csv";
        String file_vendas = "src/Ficheiros/GameStart_Vendas.csv";
        String file_copyright = "src/Ficheiros/GameStart_Copyright.txt";
        String file_admins = "src/Ficheiros/GameStart_Admins.csv";
        String file_clientes = "src/Ficheiros/GameStart_Clientes.csv";


        // Colocar os ficheiros em matrizes
        String[][] matriz_vendas = ficheiroParaMatriz(file_vendas, ";");
        String[][] matriz_admins = ficheiroParaMatriz(file_admins, ";");
        String[][] matriz_categorias = ficheiroParaMatriz(file_categorias, ";");
        String[][] matriz_clientes = ficheiroParaMatriz(file_clientes, ";");
        String[][] vendas_sem_duplicados = matrizSemDuplicados(matriz_vendas);

        // Inicio do programa | LOGIN
        do {
            System.out.print("""
                    #### \uD83C\uDFAE GAMESTART \uD83C\uDFAE ####
                    ##########################
                    Utilizador:
                     1. Cliente 🧑
                     2. Admin 🤴
                    """);
            user = input.nextInt();
        } while (user != 1 && user != 2);

        // ###################################### MENU CLIENTE #######################################################
        // Validação e apresentação de menu Cliente
        if (user == 1) {

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
                opcao_cliente = input.nextInt();

                switch (opcao_cliente) {
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
                        imprimirColuna(vendas_sem_duplicados, 4);
                        break;
                    case 4:
                        menuCatalogos();
                        break;
                    case 5:
                        System.out.println("\s\s\s\s\s\s\s**** Pesquisar por editora **** ");
                        System.out.print("Insira a editora: ");
                        editora = input.next();
                        imprimirPorEditoraOuCategoria(vendas_sem_duplicados, matriz_categorias, editora, true);
                        break;
                    case 6:
                        System.out.println("\s\s\s\s\s\s\s**** Pesquisar por categoria **** ");
                        System.out.print("Insira uma categoria: ");
                        categoria = input.next();
                        imprimirPorEditoraOuCategoria(vendas_sem_duplicados, matriz_categorias, categoria, false);
                        break;
                    case 7:
                        jogoMaisRecente(vendas_sem_duplicados);
                        break;
                    case 8:
                        imprimir(file_copyright);
                        break;
                    default:
                        System.out.println("Opção inválida. Digite novamente:");
                        opcao_cliente = input.nextInt();
                }


            } while (opcao_cliente != 8);

        }

        // ############################################ MENU ADMIN ##################################################
        // Validação e apresentação de menu Admin
        if (user == 2) {

          //  if (login(matriz_admins)) { // Sistema login, aceder só com credenciais
                do {

                    // Opções do Admin
                    System.out.print("""
                                                
                            ------------- Menu Admin -------------
                            1. Consulta de ficheiros
                            2. Total de vendas
                            3. Total de lucro
                            4. Pesquisa de cliente
                            5. Jogo mais caro
                            6. Melhores clientes
                            7. Melhor categoria
                            8. Pesquisa Vendas
                            9. Top 5 jogos
                            10. Bottom 5 jogos
                            11. Sair 👋
                            """);
                    opcao_admin = input.nextInt();

                    switch (opcao_admin) {
                        case 1:
                            menuFicheiros(matriz_vendas, matriz_categorias, matriz_clientes);
                            break;
                        case 2:
                            vendasTotal(matriz_vendas);
                            break;
                        case 3:
                            System.out.println("\n\s\s\s\s\s\s **** Total de lucro ****\n");
                            lucro_total = lucros(matriz_vendas,matriz_categorias); // Calcular lucro
                            System.out.println("💵💵💵💵💵💵💵💵💵💵💵💵💵💵💵");
                            System.out.println("\s\s\s\s\s\s\s\s\s\sLUCRO: " + String.format("%.2f€",lucro_total));
                            System.out.println("💵💵💵💵💵💵💵💵💵💵💵💵💵💵💵");
                            break;
                        case 4:
                            System.out.println("\n\s\s\s\s\s\s **** Pesquisar Cliente ****");
                            System.out.print("Insira o codigo: ");
                            id_cliente = input.next();
                            pesquisaCliente(matriz_clientes, id_cliente);
                            break;
                        case 5:
                            jogoMaisCaro(matriz_vendas,matriz_clientes);
                            break;
                        case 6:
                            melhoresClientes(matriz_vendas, matriz_clientes);
                            break;
                        case 7:
                            melhorCategoria(matriz_vendas,matriz_categorias);
                            break;
                        case 8:
                            System.out.println("Jogo a pesquisar: ");
                            jogo = input.next();
                            pesquisaVendas(matriz_vendas, matriz_clientes, jogo);
                            break;
                        case 9:
                            top5(matriz_vendas);
                            break;
                        case 10:
                            break;
                        case 11:
                            imprimir(file_copyright);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            opcao_admin = input.nextInt();
                            break;

                    }

                } while (opcao_admin != 11);
            }

      //  }
    }
}