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
                    4. Sair 👋
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


        String profit = String.format("%.2f",somatorio);
        System.out.println("Vendas: " + profit + "€");
        System.out.println("Faturas: " + count);

    }

    public static double lucroTotal( String [][] file_vendas){
        double lucro_total = 0.0;
        // 8572,47€
        for (int i = 0; i < file_vendas.length; i++){
        }

        return lucro_total;
    }

    /**
     * Metodo para pesquisar um cliente pelo id
     * e mostrar as suas informações
     */
    public static void pesquisaCliente(String [][] clientes , String id){

        System.out.println("Nº | Nome \s\s\s\s\s\s\s\s | Telemóvel  | E-mail                  |");
        System.out.println("------------------------------------------------------------");

        for (int l = 0; l < clientes.length; l++){
          for (int c = 0; c < clientes[0].length; c++){
              if (clientes[l][0].equalsIgnoreCase(id)){
                  System.out.print(clientes[l][c] + "\s | ");
              }
          }

        }
        System.out.println();
        System.out.println("------------------------------------------------------------");


    }

    /**
     * Função para retornar o jogo mais caro do sistema
     * @param vendas (ficheiro)
     */
    public static void jogoMaisCaro(String [][] vendas){

        // Guardar os primeiros valores
        Double valor, valor_mais_caro = Double.parseDouble(vendas[0][5]);
        String nome_jogo = vendas[0][4];

        for (int l = 0 ; l < vendas.length; l++){
            valor = Double.parseDouble(vendas[l][5]); // String para double
            if(valor > valor_mais_caro){ // Comparação do maior
                valor_mais_caro = valor;
                nome_jogo = vendas[l][4];
            }

        }

         System.out.println("\n\s\s\s\s\s\s **** Jogo mais caro ****");
         System.out.println(" JOGO: " + nome_jogo + " | " + valor_mais_caro + "0€");


}

    public static void melhoresClientes(String[][] vendas, String[][] clientes){

        String melhor_cliente = "";
        double valor_maior = 0;


        for (int k = 0; k < clientes.length; k++){ // Ficheiro clientes
            String id_cliente = clientes[k][0];
            double somatorio = 0; // incremento das compras

            for (int l = 0; l < vendas.length; l++){ // Ficheiro vendas
                String id_vendas = vendas[l][1];
                Double compras = Double.parseDouble(vendas[l][5]); // Valor de compra por linha

                if(id_cliente.equalsIgnoreCase(id_vendas)){ // identificar o cliente nas compras
                    somatorio += compras; // Somar as diferentes compras de 1 cliente

                }

                if(somatorio > valor_maior){
                    melhor_cliente = id_cliente;
                    valor_maior = somatorio;
                }

            }
        }

        pesquisaCliente(clientes,melhor_cliente);





        System.out.println(melhor_cliente + " " + String.format("%.2f",valor_maior));
    }

   public static void top5(String [][] vendas){

        boolean repetido = false;

        for (int l = 0; l < vendas.length; l++){
            String jogo = vendas[l][4];
            double valor = Double.parseDouble(vendas[l][5]);
            double somatorio=0;

            if(vendas[l][4].equalsIgnoreCase(jogo)){
                repetido = true;
                if(repetido){
                    somatorio += valor;
                }
            }


                System.out.println(jogo + " " + somatorio);

        }
   }

   public static void pesquisaVendas(String [][] vendas, String [][] clientes, String jogo){

        for (int l = 0; l < vendas.length; l++){
            String jogo_atual = vendas[l][4];
            if(jogo_atual.equalsIgnoreCase(jogo)){
                String id_cliente = vendas[l][1];
                for(int x = 0; x < clientes.length;x++){
                    System.out.println(clientes[l][x] + " ");
                }
            }
        }
   }
    public static void main(String[] args) {

    }

}

