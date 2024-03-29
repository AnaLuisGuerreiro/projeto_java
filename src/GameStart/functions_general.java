package GameStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class functions_general {

    /**
     * Função para contar linhas de um ficheiro
     *
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
     *
     * @param file        (caminho do ficheiro)
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
     *
     * @param file        (caminho do ficheiro
     * @param delimitador (,/;/.)
     * @return matriz com a info do ficheiro
     * @throws FileNotFoundException
     */
    public static String[][] ficheiroParaMatriz(String file, String delimitador) throws FileNotFoundException {
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

    public static String[][] imprimirMatriz(String[][] file) {

        for (int l = 0; l < file.length; l++) {
            for (int c = 0; c < file[0].length; c++) {
                System.out.print(file[l][c] + " | ");
            }
            System.out.println();
        }
        return file;
    }

    /**
     * Metodo para imprimir os ficheiros gráficos
     *
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
     * @param matriz_vendas
     * @return
     */
    public static String[][] matrizSemDuplicados(String[][] matriz_vendas) {
        // Criação de outra matriz
        String[][] matriz_sem_duplicados = new String[matriz_vendas.length][matriz_vendas[0].length];

        int linha_count = 0;

        // Preencher a primeira linha da nova matriz com a antiga
        for (int c = 0; c < matriz_vendas[0].length; c++) {
            matriz_sem_duplicados[0][c] = matriz_vendas[0][c];
        }
        linha_count++; // Contar linha (para atualizar matriz final)

        for (int l = 1; l < matriz_vendas.length; l++) { // Linha seguinte
            boolean repetido = false; // Controlar repetidos
            for (int c = 0; c < linha_count; c++) { // Verificação linha a linha de cada vez
                if (matriz_vendas[l][4].equals(matriz_sem_duplicados[c][4])) { // Verificação de repetidos por jogo
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                // Se não for repetido, copia a linha toda
                for (int c = 0; c < matriz_vendas[0].length; c++) {
                    matriz_sem_duplicados[linha_count][c] = matriz_vendas[l][c];
                }
                linha_count++;
            }
        }

        // Criar matriz nova para ajustar tamanho e retirar linhas vazias
        String[][] matrizFinal = new String[linha_count][matriz_vendas[0].length];
        for (int l = 0; l < linha_count; l++) {
            for (int c = 0; c < matriz_vendas[0].length; c++) {
                matrizFinal[l][c] = matriz_sem_duplicados[l][c];
            }
        }

        return matrizFinal;
    }


    }





