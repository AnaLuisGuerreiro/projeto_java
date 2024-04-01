package GameStart;

import java.util.Scanner;

import static GameStart.functions_general.*;

public class functions_admin {
    /**
     * Login
     * Função para verificar username e password de acesso
     *
     * @param admins
     * @return dados corretos / dados incorretos
     */
    public static boolean login(String[][] admins) {
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

            if (!correto) {
                System.out.println("Username e/ou password errada.\n");
            }

        } while (!correto);


        return correto;
    }

    /**
     * Opção 1
     * Menu com os respetivos ficheiros a imprimir
     *
     * @param vendas
     * @param categorias
     * @param clientes
     */
    public static void menuFicheiros(String[][] vendas, String[][] categorias, String[][] clientes) {
        Scanner input = new Scanner(System.in);

        int opcao;
        do {

            // Opções do Admin
            System.out.print("""
                                        
                               **** Consulta de ficheiros ****
                    1. Vendas
                    2. Clientes
                    3. Categorias
                    4. Voltar ⬅
                    """);
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    imprimirMatriz(vendas);
                    break;
                case 2:
                    imprimirMatriz(clientes);
                    break;
                case 3:
                    imprimirMatriz(categorias);
            }
        } while (opcao != 4);
    }

    /**
     * Opção 2
     * Metodo para calcular a quantidade de vendas e o valor total em €
     *
     * @param vendas
     */
    public static void vendasTotal(String[][] vendas) {
        int count = 0;
        double somatorio = 0.0;

        for (int i = 0; i < vendas.length; i++) {
            String primeira_venda = vendas[i][5];
            double valor_venda = Double.parseDouble(primeira_venda);
            somatorio += valor_venda;
            count++;
        }


        System.out.println("############################");
        System.out.println("       Vendas: " + String.format("%.2f€", somatorio));
        System.out.println("       Faturas: " + count);
        System.out.println("############################");

    }

    /**
     * Opção 3
     * Função para calcular o lucro total das vendas
     *
     * @param vendas
     * @return total de lucro
     */
    public static double lucros(String[][] vendas, String[][] categorias) {
        double lucro_total = 0;
        double lucro = 0; // Lucro por categoria

        for (int i = 0; i < vendas.length; i++) {
            double valor = Double.parseDouble(vendas[i][5]);
            String categoria_vendas = vendas[i][3];

            for (int t = 0; t < categorias.length; t++) {
                double margem = Double.parseDouble(categorias[t][1]);
                String categoria = categorias[t][0];

                if (categoria.equalsIgnoreCase(categoria_vendas)) {
                    lucro = valor * (margem / 100);
                    lucro_total += lucro;
                }
            }
        }

        return lucro_total;
    }

    /**
     * Opção 4
     * Metodo para pesquisar um cliente pelo id
     * e mostrar as suas informações
     */
    public static void pesquisaCliente(String[][] clientes, String id) {

        System.out.println("----------------------------------------------------------------");

        for (int l = 0; l < clientes.length; l++) {
            for (int c = 0; c < clientes[0].length; c++) {
                if (clientes[l][0].equalsIgnoreCase(id)) {
                    System.out.print(clientes[l][c] + "\s | ");
                }
            }

        }
        System.out.println();
        System.out.println("----------------------------------------------------------------");


    }

    /**
     * Opção 5
     * Função para retornar o jogo mais caro do sistema
     *
     * @param vendas (ficheiro)
     */
    public static void jogoMaisCaro(String[][] vendas, String[][] clientes) {

        // Guardar os primeiros valores
        Double valor, valor_mais_caro = Double.parseDouble(vendas[0][5]);
        String nome_jogo = vendas[0][4];

        for (int l = 0; l < vendas.length; l++) {
            valor = Double.parseDouble(vendas[l][5]); // String para double
            if (valor > valor_mais_caro) { // Comparação do maior
                valor_mais_caro = valor;
                nome_jogo = vendas[l][4];
            }

        }

        System.out.println("\n\s\s\s\s\s\s **** Jogo mais caro ****");
        System.out.println(" JOGO: " + nome_jogo + " | " + valor_mais_caro + "0€\n");
        System.out.println("            CLIENTES QUE COMPRARAM O : " + nome_jogo.toUpperCase());

        for (int t = 0; t < vendas.length; t++) {
            String jogo_vendas = vendas[t][4];
            if (nome_jogo.equalsIgnoreCase(jogo_vendas)) {
                String id_cliente = vendas[t][1];

                for (int f = 0; f < clientes.length; f++) {
                    String cliente = clientes[f][0];
                    if (id_cliente.equalsIgnoreCase(cliente)) {
                        pesquisaCliente(clientes, id_cliente);
                    }
                }
            }


        }


    }

    /**
     * Opção 6
     * Função que retorna o melhor cliente, o total das compras e quais os jogos comprados
     *
     * @param vendas
     * @param clientes
     */
    public static void melhorCliente(String[][] vendas, String[][] clientes) {

        System.out.println("\n\s\s\s\s\s\s **** Melhor Cliente ****");

        String melhor_cliente = "";
        double valor_maior = 0;
        String jogos_comprados = "";


        for (int k = 0; k < clientes.length; k++) { // Ficheiro clientes
            String id_cliente = clientes[k][0];
            double somatorio = 0; // Incremento das compras

            for (int l = 0; l < vendas.length; l++) { // Ficheiro vendas
                String id_vendas = vendas[l][1];
                Double compras = Double.parseDouble(vendas[l][5]); // Valor de compra por linha

                if (id_cliente.equalsIgnoreCase(id_vendas)) { // identificar o cliente nas compras
                    somatorio += compras; // Somar as diferentes compras de 1 cliente
                }

                if (somatorio > valor_maior) {
                    melhor_cliente = id_cliente;
                    valor_maior = somatorio;
                }

            }
        }


        for (int l = 0; l < vendas.length; l++) { // Iterar as vendas de novo
            String id_vendas = vendas[l][1];

            if (melhor_cliente.equalsIgnoreCase(id_vendas)) { // Verificar o melhor cliente
                jogos_comprados += vendas[l][4] + "\n";
            }
        }

        // Dados do cliente
        pesquisaCliente(clientes, melhor_cliente);

        // Dinheiro gasto na loja
        System.out.println("\nCOMPRAS TOTAIS: " + String.format("%.2f€", valor_maior));

        // Jogos comprados
        System.out.println("\n - JOGOS COMPRADOS -");
        System.out.println(jogos_comprados);

    }

    /**
     * Opção 7
     * Função para retornar a melhor categoria e o seu lucro individual
     */
    public static void melhorCategoria(String[][] vendas, String[][] categorias) {

        double maior_lucro = 0;
        String melhor_categoria = "";

        for (int i = 0; i < categorias.length; i++) {
            String categoria = categorias[i][0];
            double margem = Double.parseDouble(categorias[i][1]);
            double lucro_individual = 0;

            for (int x = 0; x < vendas.length; x++) {
                String categoria_vendas = vendas[x][3];
                double valor = Double.parseDouble(vendas[x][5]);

                if (categoria.equalsIgnoreCase(categoria_vendas)) {
                    double lucro = valor * (margem / 100);
                    lucro_individual += lucro;
                }

            }

            if (lucro_individual > maior_lucro) {
                maior_lucro = lucro_individual;
                melhor_categoria = categoria;
            }


        }

        System.out.println("\n\s\s\s\s\s\s **** Melhor Categoria ****\n");
        System.out.println(melhor_categoria + " -> " + String.format("%.2f€", maior_lucro));

    }


    /**
     * Opção 8
     * Função que retorna os clientes que compraram um determinado jogo
     *
     * @param vendas
     * @param clientes
     * @param jogo
     */
    public static void pesquisaVendas(String[][] vendas, String[][] clientes, String jogo) {

        System.out.println("\n\s\s\s\s\s\s\s**** Clientes que compraram o " + jogo.toUpperCase() + " ****");

        for (int t = 0; t < vendas.length; t++) {
            String jogos = vendas[t][4];
            String cliente_comprou = vendas[t][1];

            if (jogo.equalsIgnoreCase(jogos)) {

                for (int x = 0; x < clientes.length; x++) {
                    String id_clientes = clientes[x][0];

                    if (cliente_comprou.equalsIgnoreCase(id_clientes)) {
                        pesquisaCliente(clientes, id_clientes);
                    }
                }

            }
        }

    }

    /**
     * Opção 9
     *
     * @param vendas
     */
    public static void top5(String[][] vendas, String[][] categorias) {

        double [] lucro_venda = new double[vendas.length];

        for (int i = 0; i < vendas.length; i++) {
            String categoria_venda = vendas[i][3];
            double preco_venda = Double.parseDouble(vendas[i][5]);
            boolean repetido = false;

            for (int x = 0; x < categorias.length; x++){
                String categoria = categorias[x][0];

                if(categoria_venda.equalsIgnoreCase(categoria)){
                    double margem_lucro = Double.parseDouble(categorias[x][1]);

                    lucro_venda[x] = preco_venda * (margem_lucro / 100);

                }
            }
        }
    }
}



























