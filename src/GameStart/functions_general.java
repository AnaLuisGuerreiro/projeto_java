package GameStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class functions_general {

    /**
     * Função para contar linhas de um ficheiro
     * @param file (caminho do ficheiro)
     * @return numero de linhas
     * @throws FileNotFoundException
     */
    public static int contarLinhas(String file) throws FileNotFoundException {

        int num_linhas = 0;

        Scanner leitura = new Scanner(new File(file));

        while (leitura.hasNextLine()) {
            num_linhas++;
            leitura.nextLine();
        }

        return num_linhas;

    }

    /**
     * Função para contar colunas de um ficheiro
     * @param file (caminho do ficheiro)
     * @param delimitador (, / ; / .)
     * @return numero de colunas
     * @throws FileNotFoundException
     */
    public static int contarColunas(String file, String delimitador) throws FileNotFoundException {
        Scanner leitura = new Scanner(new File(file));

        String linha = leitura.nextLine();
        String[] linha_dividida = linha.split(delimitador);

        int num_colunas = linha_dividida.length;

        return num_colunas;
    }

    /**
     * Converter um ficheiro numa matriz
     * @param file (caminho do ficheiro
     * @param delimitador (,/;/.)
     * @return matriz com a info do ficheiro
     * @throws FileNotFoundException
     */
    public static String [][] ficheiroParaMatriz(String file, String delimitador) throws FileNotFoundException {
        // Declarar matriz à medida
        String[][] matriz_ficheiro = new String[contarLinhas(file) - 1][contarColunas(file, delimitador)];
        Scanner leitura = new Scanner(new File(file));

        // Linha atual
        String linha = leitura.nextLine();
        int count_linha = 0;

        while (leitura.hasNextLine()) {
            linha = leitura.nextLine();
            String[] linha_dividida = linha.split(delimitador); // Array com info dividida

            // Preencher matriz
            for (int i = 0; i < matriz_ficheiro[0].length; i++) {
                matriz_ficheiro[count_linha][i] = linha_dividida[i];
            }

            count_linha++;

        }

        return matriz_ficheiro;
    }

    public static String[][] imprimirMatriz(String [][] file){

        for (int l = 0; l < file.length; l++) {
            for (int c = 0; c < file[0].length; c++) {
                System.out.print(file[l][c] + "\s");
            }
            System.out.println();
        }
        return file;
    }

    /**
     * Metodo para imprimir os ficheiros gráficos
     * @param file
     * @throws FileNotFoundException
     */
    public static void imprimir(String file) throws FileNotFoundException {

        // Iniciar Scanner no ficheiro
        Scanner leitorFicheiro = new Scanner(new File(file));

        while (leitorFicheiro.hasNextLine()) {  // Verificar se existe mais linhas
            String linha = leitorFicheiro.nextLine();
            System.out.println(linha);  // imprimir linha
        }

        leitorFicheiro.close();
    }

    /**
     * Função para retirar informação duplicada
     *
     * @param matriz_file
     * @return
     */
    public static String[][] imprimirSemDuplicados(String[][] matriz_file) {

        // Criação de outra matriz
        String [][] matriz_sem_duplicados = new String[matriz_file.length][matriz_file[0].length];

        // Transferir os dados para a nova matriz
        for (int l = 0; l < matriz_file.length; l++) {
            for (int c = 0; c < matriz_file[0].length; c++) {
                matriz_sem_duplicados[l][c] = matriz_file[l][c];
            }
        }

        for (int l= 0; l < matriz_file.length; l++) {
            String jogo = matriz_file[l][4]; // Guardar o primeiro jogo da lista
            boolean repetido = false;  // Controlar as repetições

            for (int i = 0; i < l; i++) {
                if (matriz_file[i][4].equalsIgnoreCase(jogo)) { // Comparar o primeiro jogo com o jogo das linhas seguintes
                    repetido = true;
                }
            }

            if (repetido) { // Se repetido, preenche matriz em branco.
                matriz_sem_duplicados[l][4] = "";
            } else {
                System.out.println(jogo); // Se não repetido, imprime o jogo
            }

        }
        return matriz_sem_duplicados;
    }



}



