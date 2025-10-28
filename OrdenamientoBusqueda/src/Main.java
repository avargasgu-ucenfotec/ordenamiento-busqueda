import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        System.out.print("Digite la cantidad de palabras que desea ingresar: ");

        String[] palabras = new String[scannerInt.nextInt()];

        for (int i = 0; i < palabras.length; i++) {
            System.out.print("Digite la siguiente palabra: ");
            String palabra = scannerString.nextLine();
            palabras[i] = palabra;
        }

        for (String palabra : palabras) {
            System.out.print(palabra + " ");
        }
    }
}