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
            desplegarMenuSecundario();
            obtenerOpcionBusqueda(arregloPalabras);
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

    public void desplegarMenuSecundario() {
        System.out.println("\nMenú de búsqueda binaria");
        System.out.print("¿Desea buscar una palabra en el arreglo ordenado? [S/N]: ");
    }

    public void obtenerOpcion(String[] arreglo) {
        Scanner scanner = new Scanner(System.in);
        String seleccion = scanner.nextLine();
        switch (seleccion) {
            case "1":
                System.out.println("\nAlgoritmo de selección");
                ordenamientoSeleccion(arreglo);
                System.out.print("Arreglo ordenado: ");
                System.out.println(Arrays.toString(arreglo));
                break;
            case "2":
                System.out.println("\nAlgoritmo de inserción");
                ordenamientoInsercion(arreglo);
                System.out.print("Arreglo ordenado: ");
                System.out.println(Arrays.toString(arreglo));
                break;
            case "3":
                System.out.println("\nAlgoritmo de burbuja");
                ordenamientoBurbuja(arreglo);
                System.out.print("Arreglo ordenado: ");
                System.out.println(Arrays.toString(arreglo));
                break;
            case "4":
                System.out.println("\nAlgoritmo de mezcla");
                ordenamientoMezcla(arreglo, 0,arreglo.length - 1);
                System.out.print("Arreglo ordenado: ");
                System.out.println(Arrays.toString(arreglo));
                break;
            case "5":
                System.out.println("\nAlgoritmo rápido");
                ordenamientoMezcla(arreglo, 0,arreglo.length + 1);
                System.out.print("Arreglo ordenado: ");
                System.out.println(Arrays.toString(arreglo));
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

    public void obtenerOpcionBusqueda(String[] arreglo) {
        Scanner scanner = new Scanner(System.in);
        String seleccion = scanner.nextLine();
        switch (seleccion) {
            case "S":
            case "s":
                System.out.println("\nBúsqueda binaria");
                break;
            case "N":
            case "n":
                System.out.println("\nCerrando el programa...");
                estaCorriendo = false;
                break;
            default:
                System.out.println("\nOpción no válida, por favor intente de nuevo.");
        }
    }

    /*
     * Complejidad temporal: O(n^2), debido a que tiene dos bucles anidados
     */
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

    /*
     * Complejidad temporal: O(n^2), debido a que tiene dos bucles anidados
     */
    public void ordenamientoInsercion(String[] arreglo) {
        //Crear nuevo arreglo del mismo tamaño que el ingresado
        int n = arreglo.length;
        String[] nuevoArreglo = new String[n];

        //Declarar variables de control
        int posicionInsertar = 0;
        int cantidadInsertados = 0;

        //Recorrer el arreglo completo
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nuevoArreglo[i] = arreglo[i];
            } else {
                //Determinar la casilla del arreglo nuevo en la que se debe insertar el siguiente dato
                for (int j = 0; j <= cantidadInsertados; j++) {
                    if ((arreglo[i].compareTo(nuevoArreglo[j]) < 0) || (arreglo[i].compareTo(nuevoArreglo[j]) == 0)) {
                        posicionInsertar = j;
                        break;
                    }
                    posicionInsertar = cantidadInsertados;
                }
                //Desplazar hacia adelante las casillas del arreglo nuevo cuyo valor es menor que el siguiente dato a
                //insertar
                for (int k = n - 1; k >= posicionInsertar + 1; k--) {
                    nuevoArreglo[k] = nuevoArreglo[k - 1];
                }
                //Insertar dato nuevo
                nuevoArreglo[posicionInsertar] = arreglo[i];
            }
            //Actualizar las variables de control
            posicionInsertar = 0;
            cantidadInsertados++;
        }
        //Sustituir cada casilla del arreglo original por la casilla correspondiente del nuevo arreglo, actualizando la
        //original
        for (int c = 0; c < arreglo.length; c++) {
            arreglo[c] = nuevoArreglo[c];
        }
    }

    /*
     * Complejidad temporal: O(n^2), debido a que tiene dos bucles anidados
     */
    public void ordenamientoBurbuja(String[] arreglo) {
        //Declarar variables de control
        int n = arreglo.length;

        //Recorrer el arreglo completo
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j].compareTo(arreglo[j + 1]) > 0) {
                    //Reemplazar variable temporal por elemento actual
                    String temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    /*
     * Complejidad temporal: O(n log n), debido al tiempo asociado a, recursivamente, ordenar las dos secciones del
     *                       arreglo y, al tiempo asociado a unir las dos secciones ordenadas.
     */
    public void ordenamientoMezcla(String[] arreglo, int desde, int hasta) {
        //Corroborar si el arreglo ha sido analizado en su totalidad
        if (desde == hasta) {
            return;
        }

        //Declarar la variable que divide el arreglo en dos secciones
        int medio = (desde + hasta) / 2;

        //Ordenar recursivamente las dos secciones
        ordenamientoMezcla(arreglo, desde, medio);
        ordenamientoMezcla(arreglo, medio + 1, hasta);

        //Unir las dos secciones
        mezcla(arreglo, desde, medio, hasta);
    }

    /*
     * Complejidad temporal: O(n log n), debido al tiempo asociado a, recursivamente, ordenar las dos secciones del
     *                       arreglo y, al tiempo asociado a unir las dos secciones ordenadas.
     */
    public void ordenamientoRapido(String[] arreglo, int limiteInferior, int limiteSuperior) {
        //Corroborar si el arreglo ha sido analizado en su totalidad
        if (limiteSuperior <= limiteInferior)
            return;

        //Declarar la variable que divide el arreglo en dos secciones
        int j = particion(arreglo, limiteInferior, limiteSuperior);

        //Ordenar recursivamente las dos secciones
        ordenamientoRapido(arreglo, limiteInferior, j-1);
        ordenamientoRapido(arreglo, j+1, limiteSuperior);
    }

    //Funciones auxiliares - ordenamientoMezcla
    public void mezcla(String[] arreglo, int desde, int medio, int hasta) {
        int n = arreglo.length;
        String[] nuevoArreglo = new String[n];  //Arreglo auxiliar para almacenar las dos secciones ordenadas

        int i1 = desde;                         //Próximo elemento a considerar en el primer rango
        int i2 = medio + 1;                     //Próximo elemento a considerar en el segundo rango
        int j = 0;                              //Próxima posición libre en el arreglo auxiliar

        //Mientras i1 & i2 no lleguen al final, mover el String menor al arreglo auxiliar
        while (i1 <= medio && i2 <= hasta) {
            if (arreglo[i1].compareTo(arreglo[i2]) < 0) {
                nuevoArreglo[j] = arreglo[i1];
                i1++;
            } else {
                nuevoArreglo[j] = arreglo[i2];
                i2++;
            }
            j++;
        }

        //Agregar los elementos pendientes de la primer sección
        while (i1 <= medio) {
            nuevoArreglo[j] = arreglo[i2];
            i1++;
            j++;
        }

        //Agregar los elementos pendientes de la segunda sección
        while (i2 <= hasta) {
            nuevoArreglo[j] = arreglo[i2];
            i2++;
            j++;
        }

        //Copiar los elementos del arreglo auxiliar al arreglo original
        for (j = 0; j < n; j++) {
            arreglo[desde + j] = nuevoArreglo[j];
        }
    }


    //Funciones auxiliares - ordenamientoRapido
    private static boolean less(String v, String w) {
        //Resultado de preguntar si el String v es menor que el String w
        if (v.equals(w))
            return false;
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        //Intercambiar los valores de las posiciones a[i] y a[j]
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public int particion(String[] arreglo, int limiteInferior, int limiteSuperior) {
        //Hacer una partición del arreglo original de manera que haya un elemento central que divide al arreglo en dos
        //secciones
        int i = limiteInferior;
        int j = limiteSuperior + 1;
        String v = arreglo[limiteInferior];

        while (true) {
            while (less(arreglo[++i], v)) {
                if (i == limiteSuperior)
                    break;
            }

            while (less(v, arreglo[--j])) {
                if (j == limiteInferior)
                    break;
            }

            if (i >= j)
                break;

            exch(arreglo, i, j);
        }
        exch(arreglo, i, j);

        return j;
    }
}
