package view;

import java.util.Scanner;

public class CapturadorDeEntrada {

    private static final Scanner scanner = new Scanner(System.in);

    public static String capturarString(String nomeDoCampo) {
        System.out.printf("Informar %s: ", nomeDoCampo);
        return  scanner.nextLine();
    }
}
