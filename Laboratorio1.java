public class Laboratorio1 {
    public static void main(String[] args) {
        // Del main nos encargamos cuando tengamos todas las funciones hechas
    }

    // 1A
    // Convertir un entero decimal a binario, especificando el ancho en bits.
    public static String convertirADecimal(int numeroDecimal, int anchoBits) {
            String binario = Integer.toBinaryString(numeroDecimal);
            // Asegura que el resultado tenga el ancho especificado
            while (binario.length() < anchoBits) {
                binario = "0" + binario;
            }
            // Si el binario excede el ancho, se cortará
            if (binario.length() > anchoBits) {
                binario = binario.substring(binario.length() - anchoBits);
            }
            return binario;
    }

    // 1B
    // Convertir un número binario a entero decimal.


    // 1C
    //Convertir un número de entero decimal a hexadecimal, especificando el ancho en dígitos hexadecimales
    public static String convertirDecimalAHexadecimal(int decimalNumber, int ancho) {
        // Convertir el número decimal a hexadecimal
        String hexNumber = Integer.toHexString(decimalNumber).toUpperCase();

        // Formatear con el ancho especificado (rellenar con ceros a la izquierda si es necesario)
        while (hexNumber.length() < ancho) {
            hexNumber = "0" + hexNumber;
        }

        return hexNumber;
    }

    // 1D
    // Convertir un número de hexadecimal a entero decimal.


    // 1E
    // Convertir un número de binario a hexadecimal.
    

    // 1F
    // Convertir un número hexadecimal a binario
    public static String convertirAHexadecimal(String numeroHexadecimal) {
        // Convierte el hexadecimal a decimal primero
        int decimal = Integer.parseInt(numeroHexadecimal, 16);
        // Luego convierte el decimal a binario
        return Integer.toBinaryString(decimal);
    }

    // 2A
    // Crear un String de un tamaño especificado.
    // El contenido será el abecedario en letras minúsculas tantas veces
    // como sea necesario hasta completar el tamaño de la cadena.
    public static String generarCadenaFija(int tamanio) {
        StringBuilder cadena = new StringBuilder();
        String abecedario = "abcdefghijklmnopqrstuvwxyz";

        // Repite el abecedario hasta alcanzar el tamaño deseado
        while (cadena.length() < tamanio) {
            cadena.append(abecedario);
        }

        // Devuelve la subcadena del tamaño especificado
        return cadena.substring(0, tamanio);
    }

    // 2B
    //Dividir la cadena con una longitud múltiplo de 16 caracteres en
    // grupos de 4, 8 y 16 caracteres. Se debe validar que el tamaño de cada
    // segmento de la cadena sea una potencia de 2.
    public static String[] dividirCadena(String cadena, int tamanioSegmento) {
        if (!esPotenciaDeDos(tamanioSegmento)) {
            throw new IllegalArgumentException("El tamaño del segmento debe ser una potencia de 2.");
        }

        int longitud = cadena.length();
        int cantidadSegmentos = longitud / tamanioSegmento;
        String[] segmentos = new String[cantidadSegmentos];

        for (int i = 0; i < cantidadSegmentos; i++) {
            int inicio = i * tamanioSegmento;
            segmentos[i] = cadena.substring(inicio, inicio + tamanioSegmento);
        }

        return segmentos;
    }

    public static boolean esPotenciaDeDos(int numero) {
        if (numero <= 0) {
            return false; // Solo consideramos números positivos
        }

        while (numero % 2 == 0) {
            numero /= 2; // Divide el número por 2
        }

        return numero == 1; // Si llegamos a 1, es potencia de 2
    }

    // 3A
    // Dada una cadena de un tamaño especificado, dividirla en dos partes,
    // separando los primeros n bits y el resto. El resultado es un String[]
    // de dos elementos: la primera parte y la segunda parte.

    // 3B
    // Dada una cadena de un tamaño especificado, dividirla en tres partes,
    // separando los primeros n bits, los siguientes m bits y el resto. El resultado
    // es un String[] de tres elementos: la primera parte y la segunda parte.

    // 3C
    // Dada una cadena de un tamaño especificado y un int[] con los tamaños de las partes,
    // separar las partes de la cadena. El resultado es un String[] de tantas partes se haya
    // especificado en el int [], más el fragmento final con el sobrante, si aplica.
    // Debe validar que la suma de los elementos del int[] sea igual o menor que la longitud total
    // del String de entrada. En caso de que no coincida, retorna null. Este valor debe ser validado en el
    // metodo principal donde prueba que funcione.

    // 4
}
