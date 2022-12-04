package arreglouni;

/**
 * @author Francisco Delgado Martínez. TI41BIS.
*
 */
public class ArregloUni {

    private static int[][] matrizBidimensionalDeNumeros;
    private static int[] arrayNumerosPares;
    private static int[] arrayNumerosImpares;

    public static void main(String[] args) {

        inicializarArrays(5, 5);
        llenarMatrizConNumerosAleatorios(500);
        creaArrayDeParesEImpares();

        mostarArray(arrayNumerosPares);
        mostarArray(arrayNumerosImpares);

        mostrarPromedioArray(arrayNumerosPares);
        mostrarPromedioArray(arrayNumerosImpares);
    }

// Inicializamos el array bidimensional asignándole el valor de las filas
// i el valor de las columnas
// Aprovechamos para inicializar los arrays para los números pares y los números impares.
// el tamaño de estos arrays será igual al tamaño total del array bidimensional.
    public static void inicializarArrays(int valorFilas, int valorColumnas) {
        matrizBidimensionalDeNumeros = new int[valorFilas][valorColumnas];
        arrayNumerosPares = new int[valorFilas * valorColumnas];
        arrayNumerosImpares = new int[valorFilas * valorColumnas];
    }

// llenamos el array bidimensional con números aleatorios
// con el límite de rango que queramos
// si queremos números aleatorios hasta el numero 500, el limite de rango será de 0 a 500
// si quieres que el rango de números no incluya el 0 añadele +1 al métodp 
// (Math.random() * limiteDeRango + 1)
    public static void llenarMatrizConNumerosAleatorios(int limiteDeRango) {
        for (int i = 0; i < matrizBidimensionalDeNumeros.length; i++) {
            for (int j = 0; j < matrizBidimensionalDeNumeros[i].length; j++) {
                matrizBidimensionalDeNumeros[i][j] = (int) (Math.random() * limiteDeRango);
            }
        }
    }

// creamos los arrays de número pares e impares
// recorremos el array bidimensional y vamos separando los números 
// según sean pares o impares
// para asegurarnos de que no hay espacios vacíos en los arrays creados
// utilizamos el medoto eliminarIndicesVaciosArray() para eliminar dichos índices
    public static void creaArrayDeParesEImpares() {

        int contadorIndicesArrayDePares = 0;
        int contadorIndicesArrayDeImpares = 0;

        for (int i = 0; i < matrizBidimensionalDeNumeros.length; i++) {
            for (int j = 0; j < matrizBidimensionalDeNumeros[i].length; j++) {
                if (matrizBidimensionalDeNumeros[i][j] % 2 == 0) {
                    arrayNumerosPares[contadorIndicesArrayDePares] = matrizBidimensionalDeNumeros[i][j];
                    contadorIndicesArrayDePares++;
                } else {
                    arrayNumerosImpares[contadorIndicesArrayDeImpares] = matrizBidimensionalDeNumeros[i][j];
                    contadorIndicesArrayDeImpares++;
                }
            }
        }

        arrayNumerosPares = eliminaIndicesVaciosArray(arrayNumerosPares, contadorIndicesArrayDePares);
        arrayNumerosImpares = eliminaIndicesVaciosArray(arrayNumerosImpares, contadorIndicesArrayDeImpares);
    }

// el método retorna un array con los índices vacíos eliminados
// en este caso los arrays para número pares e impares tienen un tamaño de 25,
// con este metodo eliminamos los valores vacios. 
// Ojo! vacio no significa valor 0. Por eso el valor de indiceFinalValido es igual
// al contador de índices utilizados en el método creaArrayDeParesEImpares()
    public static int[] eliminaIndicesVaciosArray(int[] arrayAModificar, int indiceFinalValido) {

        int[] arrayTemporal = new int[indiceFinalValido];

        for (int i = 0; i < indiceFinalValido; i++) {
            arrayTemporal[i] = arrayAModificar[i];
        }

        return arrayTemporal;

    }

//mostramos un array
    public static void mostarArray(int[] arrayAMostrar) {

        System.out.println("Valores del array " + tipoDeValoresArray(arrayAMostrar) + ": ");
        System.out.print("|");
        for (int i = 0; i < arrayAMostrar.length; i++) {
            System.out.print(arrayAMostrar[i] + "|");
        }

        System.out.println();
    }

//calcula y retorna el promedio de un array de enteros
    public static double calcularPromedioArray(int[] arrayAProcesar) {
        int sumaNumeros = 0;

        for (int i = 0; i < arrayAProcesar.length; i++) {
            sumaNumeros += arrayAProcesar[i];
        }

        return (double) sumaNumeros / arrayAProcesar.length;
    }

// muestra el promedio de un array de enteros
// con printf (%.2f) limitamos el numero a mostrar a 2 decimales
    public static void mostrarPromedioArray(int[] arrayAProcesar) {
        System.out.printf("El promedio del array %s es %.2f \n", tipoDeValoresArray(arrayAProcesar), calcularPromedioArray(arrayAProcesar));

    }

// genera un String con el tipo de array
    public static String tipoDeValoresArray(int[] arrayAProcesar) {
        String tipoArray = "Impar";
        if (arrayAProcesar[0] % 2 == 0) {
            tipoArray = "Par";
        }

        return tipoArray;
    }
}
