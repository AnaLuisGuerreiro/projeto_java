package GameStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class general_functions {

    public static int contarLinhas(String file_vendas) throws FileNotFoundException {

        int numeroLinhas = 0;

        Scanner leitura = new Scanner(new File(file_vendas));

        while (leitura.hasNextLine()) {
            numeroLinhas++;
            leitura.nextLine();
        }

        return numeroLinhas;

    }

    public static int contarColunas(String path, String delimitador) throws FileNotFoundException {
        Scanner leitura = new Scanner(new File(path));

        String linha = leitura.nextLine();
        String[] linhaDividida = linha.split(delimitador);

        int numeroColunas = linhaDividida.length;

        return numeroColunas;
    }
    public static String [][] ficheiroParaMatriz(String file_vendas) throws FileNotFoundException {
        String matriz_ficheiro = Arrays.toString(new String[contarLinhas(file_vendas)][contarColunas(file_vendas,",")]);
    }
}
