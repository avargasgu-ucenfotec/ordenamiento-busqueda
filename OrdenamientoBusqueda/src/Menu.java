import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    //Clase "Menu" que despliega un mensaje de bienvenida, solicita información al usuario y muetra un menú en consola
    //que permite al usuario elegir entre cinco algoritmos de ordenamiento.

    //Atributos
    private boolean estaCorriendo;  //Bandera que indica si el menú está corriendo.

    //Métodos
    //Constructor
    public Menu() {
        estaCorriendo = true;
    }

    //Funcionales
    public void correrMenu() {
        int cantidad = capturarCantidad();
        String[] arregloPalabras = generarArreglo(cantidad);
        while (estaCorriendo) {
            desplegarMenu();
            obtenerOpcion(arregloPalabras);
        }
    }

    public int capturarCantidad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEstrategia de aprendizaje - Algoritmos de ordenamiento y búsqueda");
        System.out.print("Digite la cantidad de palabras que desea ingresar: ");
        return scanner.nextInt();
    }

    public String[] generarArreglo(int cantidadElementos) {
        Scanner scanner = new Scanner(System.in);
        String[] arreglo = new String[cantidadElementos];
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Digite una palabra: ");
            String palabra = scanner.nextLine();
            arreglo[i] = palabra;
        }
        return arreglo;
    }

    public void desplegarMenu() {
        System.out.println("\nMenú de algoritmos de ordenamiento");
        System.out.println("[1] Selección");
        System.out.println("[2] Inserción");
        System.out.println("[3] Burbuja");
        System.out.println("[4] Mezcla");
        System.out.println("[5] Rápido");
        System.out.println("[6] Imprimir arreglo de palabras");
        System.out.println("[7] Salir");
        System.out.print("Seleccione una opción del menú: ");
    }

    public void obtenerOpcion(String[] arreglo) {
        Scanner scanner = new Scanner(System.in);
        String seleccion = scanner.nextLine();
        switch (seleccion) {
            case "1":
                System.out.println("\nAlgoritmo de selección\n");
                ordenamientoSeleccion(arreglo);
                break;
            case "2":
                System.out.println("\nAlgoritmo de inserción\n");
                break;
            case "3":
                System.out.println("\nAlgoritmo de burbuja\n");
                break;
            case "4":
                System.out.println("\nAlgoritmo de mezcla\n");
                break;
            case "5":
                System.out.println("\nAlgoritmo rápido\n");
                break;
            case "6":
                System.out.print("\nArreglo: ");
                System.out.println(Arrays.toString(arreglo));
                break;
            case "7":
                System.out.println("\nCerrando el programa...");
                estaCorriendo = false;
                break;
            default:
                System.out.println("\nOpción no válida, por favor intente de nuevo.");
        }
    }

    public void ordenamientoSeleccion(String[] arreglo) {
        //Declarar variables de control
        int n = arreglo.length;
        int menor;
        String temp;

        //Recorrer el arreglo completo
        for (int i = 0; i < n - 1; i++) {
            menor = i;
            //Recorrer parcialmente el arreglo, omitiendo las casillas ordenadas, para buscar el dato mínimo
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j].compareTo(arreglo[menor]) < 0) {
                    menor = j;
                }
            }
            //Sustituir la casilla considerada durante la iteración actual del ciclo por el valor mínimo encontrado
            temp = arreglo[i];
            arreglo[i] = arreglo[menor];
            arreglo[menor] = temp;
        }

    }
}
