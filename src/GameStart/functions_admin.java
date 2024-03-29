package GameStart;

import java.text.DecimalFormat;
import java.util.Scanner;

import static GameStart.functions_general.imprimir;
import static GameStart.functions_general.imprimirMatriz;

public class functions_admin {
    /**
     * Função para verificar username e password de acesso
     * @param admins
     * @return dados corretos / dados incorretos
     */
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

    /** Opção 1
     * Menu com os respetivos ficheiros a imprimir
     * @param file_vendas
     * @param file_categorias
     * @param file_clientes
     */
    public static void menuFicheiros(String[][] file_vendas, String [][] file_categorias, String [][] file_clientes){
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
                    imprimirMatriz(file_vendas);
                    break;
                case 2:
                    imprimirMatriz(file_clientes);
                    break;
                case 3:
                    imprimirMatriz(file_categorias);
            }
        }while (opcao != 4) ;
    }

    /** Opção 2
     * Metodo para calcular a quantidade de vendas e o valor total em €
     * @param file_vendas
     */
    public static void vendasTotal(String [][] file_vendas){
        int count = 0;
       double somatorio = 0.0;

        for(int i = 0; i < file_vendas.length; i++){
                String primeira_venda = file_vendas[i][5];
                double valor_venda = Double.parseDouble(primeira_venda);
                somatorio += valor_venda;
                count++;
        }


        System.out.println("############################");
        System.out.println("       Vendas: " + String.format("%.2f€",somatorio));
        System.out.println("       Faturas: " + count);
        System.out.println("############################");

    }

    public static double lucros ( String [][] file_vendas){
        double lucro_total = 0.0;
        // 8572,47€
        for (int i = 0; i < file_vendas.length; i++){
        }

        return lucro_total;
    }




}

