package ControleEstoquePOO;

import java.util.Scanner;

public class InputUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static int readIntNumbers(String message) {
        while (true) {
            System.out.println(message);

            String entrada = scanner.nextLine();

            try {
                int number = Integer.parseInt(entrada);
                return number;

            }catch (NumberFormatException e) {
                System.err.println("❌ENTER ONLY NUMBERS PLEASE❌");
            }
        }
    }

    public static double readDoubleNumbers(String message) {
        while (true) {
            System.out.println(message);

            String entrada = scanner.nextLine();

            try {
                double converterEntrada = Double.parseDouble(entrada);
                return converterEntrada;

            }catch (NumberFormatException e) {
                System.err.println("❌ENTER ONLY NUMBERS PLEASE❌");
            }
        }
    }

    public static String readNames(String message) {
        while (true) {
            System.out.println(message);
            String entrada = scanner.nextLine();
            if (entrada.matches("[a-zA-Z ]+")) {
                return entrada;
            }else {
                System.err.println("❌ ONLY LETTERS ARE ALLOWED HERE❌");
            }
        }
    }

    public static String readDates(String message) {
        while (true) {
            System.out.println(message);
            String entrada = scanner.nextLine();
            if (entrada.matches("[0-9/]+")) {
                return entrada;
            }else {
                System.out.println("❌ INVALID DATE ❌");
            }
        }
    }

    public static String readCPF(String message) {

        while (true) {
            System.out.println(message);
            String entrada = scanner.nextLine();

            if (entrada.matches("[0-9.-]+")) {
                if (entrada.length() <= 14) {
                    return entrada;
                }else {
                    System.err.println("❌CHARACTER LIMIT EXCEEDED (MAX 14)❌");
                }
            }else {
                System.err.println("❌ INVALID INPUT, ONLY NUMBERS AND '-' '.' ");
            }
        }
    }


}
