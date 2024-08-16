import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Laboratorio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1a - Convertir un entero decimal a binario");
            System.out.println("1b - Convertir un número binario a entero decimal");
            System.out.println("1c - Convertir un decimal a hexadecimal");
            System.out.println("1d - Convertir un número hexadecimal a entero decimal");
            System.out.println("1e - Convertir un número binario a hexadecimal");
            System.out.println("1f - Convertir un número hexadecimal a binario");
            System.out.println("2a - Crear un String de un tamaño especificado");
            System.out.println("2b - Dividir la cadena en grupos");
            System.out.println("3a - Dividir una cadena en dos partes");
            System.out.println("3b - Dividir una cadena en tres partes");
            System.out.println("3c - Separar una cadena según tamaños especificados");
            System.out.println("4 - Unir partes para conformar una cadena completa");
            System.out.println("q - Salir");
            System.out.print("Escribe tu opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1a":
                    System.out.print("Introduce un número decimal: ");
                    int numeroDecimal = scanner.nextInt();
                    System.out.print("Introduce el ancho en bits: ");
                    int anchoBits = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println("Binario: " + convertirADecimal(numeroDecimal, anchoBits));
                    break;

                case "1b":
                    System.out.print("Introduce un número binario: ");
                    String binario = scanner.nextLine();
                    System.out.println("Decimal: " + binarioADecimal(binario));
                    break;

                case "1c":
                    System.out.print("Introduce un número decimal: ");
                    int decimalNumber = scanner.nextInt();
                    System.out.print("Introduce el ancho en dígitos hexadecimales: ");
                    int anchoHex = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println("Hexadecimal: " + convertirDecimalAHexadecimal(decimalNumber, anchoHex));
                    break;

                case "1d":
                    System.out.print("Introduce un número hexadecimal: ");
                    String hex = scanner.nextLine();
                    System.out.println("Decimal: " + hexToDecimal(hex));
                    break;

                case "1e":
                    System.out.print("Introduce un número binario: ");
                    String hexadecimal = scanner.nextLine();
                    System.out.println("Hexadecimal: " + binarioAHexadecimal(hexadecimal));
                    break;

                case "1f":
                    System.out.print("Introduce un número hexadecimal: ");
                    String numeroHexadecimal = scanner.nextLine();
                    System.out.println("Binario: " + convertirAHexadecimal(numeroHexadecimal));
                    break;

                case "2a":
                    System.out.print("Introduce el tamaño de la cadena: ");
                    int tamanio = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println("Cadena generada: " + generarCadenaFija(tamanio));
                    break;

                case "2b":
                    System.out.print("Introduce la cadena: ");
                    String cadena = scanner.nextLine();
                    System.out.print("Introduce el tamaño del segmento (potencia de 2): ");
                    int tamanioSegmento = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    String[] segmentos = dividirCadena(cadena, tamanioSegmento);
                    System.out.println("Segmentos: " + java.util.Arrays.toString(segmentos));
                    break;

                case "3a":
                    System.out.print("Introduce la cadena: ");
                    String cadena1 = scanner.nextLine();
                    System.out.print("Introduce el indice de separacion de la cadena : ");
                    int indiceSeparacion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    String[] partes2 = separarCadena(cadena1, indiceSeparacion);
                    System.out.println("Segmento 1: " + (partes2[0]));
                    System.out.println("Segmento 2: " + (partes2[1]));
                    break;

                case "3b":
                    System.out.print("Introduce la cadena: ");
                    String cadena2 = scanner.nextLine();
                    System.out.print("Introduce el indice de separacion 1 : ");
                    int indiceSeparacion2 = scanner.nextInt();
                    System.out.print("Introduce el indice de separacion 2 : ");
                    int indiceSeparacion3 = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    String[] partes3 = separarCadena2(cadena2, indiceSeparacion2,indiceSeparacion3);
                    System.out.println("Segmento 1: " + (partes3[0]));
                    System.out.println("Segmento 2: " + (partes3[1]));
                    System.out.println("Segmento 3: " + (partes3[2]));
                    break;
                    

                case "3c":
                    System.out.print("Introduce la cadena: ");
                    String cadenaParaSeparar = scanner.nextLine();
                    System.out.print("Introduce los tamaños de las partes (separados por espacios): ");
                    String[] tamanosString = scanner.nextLine().split(" ");
                    int[] tamanos = new int[tamanosString.length];
                    for (int i = 0; i < tamanosString.length; i++) {
                        tamanos[i] = Integer.parseInt(tamanosString[i]);
                    }
                    String[] partes = separarCadena(cadenaParaSeparar, tamanos);
                    System.out.println("Partes: " + java.util.Arrays.toString(partes));
                    break;

                case "4":
                    System.out.print("Introduce las partes (separadas por comas): ");
                    String[] partesString = scanner.nextLine().split(",");
                    List<String> partesList = new ArrayList<>();
                    for (String parte : partesString) {
                        partesList.add(parte.trim());
                    }
                    System.out.println("Cadena unida: " + unirCadenas(partesList));
                    break;

                case "q":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (!opcion.equals("q"));

        scanner.close();
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

    // // 1B
    // // Convertir un número binario a entero decimal.
    // public static int binarioADecimal(String binario) {
    //     int decimal = 0;
    //     int base = 1; // Valor inicial de la base (2^0)

    //     // Convertir el string binario a decimal desde el último dígito al primero
    //     for (int i = binario.length() - 1; i >= 0; i--) {
    //         if (binario.charAt(i) == '1') {
    //             decimal += base; // Sumar el valor de la base si el dígito es '1'
    //         }
    //         base *= 2; // Multiplicar la base por 2 en cada iteración
    //     }

    //     return decimal;
    // }

    // // 1B
    // // Convertir un número binario a entero decimal.
    // En este método, Integer.parseInt(binario, 2) convierte el número binario 
    //(representado como una cadena) a un entero decimal usando la base 2.
    public static int binarioADecimal(String binario) {
        return Integer.parseInt(binario, 2);
    }
    

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
    public static int hexToDecimal(String hex) {
        int decimal = 0;
        int base = 1; // Valor de la base (16^0)

        // Convertir el string hexadecimal a decimal desde el último dígito al primero
        for (int i = hex.length() - 1; i >= 0; i--) {
            char hexChar = hex.charAt(i);

            // Si el carácter es un dígito (0-9)
            if (hexChar >= '0' && hexChar <= '9') {
                decimal += (hexChar - '0') * base;
            }
            // Si el carácter es una letra (A-F)
            else if (hexChar >= 'A' && hexChar <= 'F') {
                decimal += (hexChar - 'A' + 10) * base;
            }

            // Incrementar la base (16^1, 16^2, ...)
            base *= 16;
        }

        return decimal;
    }

    // 1E
    // Convertir un número de binario a hexadecimal.
    public static String binarioAHexadecimal(String binario) {
        // Convertir binario a decimal
        int decimal = Integer.parseInt(binario, 2);
        // Convertir decimal a hexadecimal
        return Integer.toHexString(decimal).toUpperCase();
        // Integer.toHexString(decimal) convierte el número decimal a una cadena hexadecimal. 
        // Luego usamos toUpperCase() para asegurarnos de que los dígitos hexadecimales estén en mayúsculas.
    }


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

    public static String[] separarCadena(String cadena, int n) {
        // Verificar que n no sea mayor que la longitud de la cadena
        if (n > cadena.length()) {
            throw new IllegalArgumentException("El valor de n es mayor que la longitud de la cadena");
        }
        
        // Dividir la cadena en dos partes
        String primeraParte = cadena.substring(0, n);
        String segundaParte = cadena.substring(n);
        
        return new String[] { primeraParte, segundaParte };
    }


    // 3B
    // Dada una cadena de un tamaño especificado, dividirla en tres partes,
    // separando los primeros n bits, los siguientes m bits y el resto. El resultado
    // es un String[] de tres elementos: la primera parte y la segunda parte.
    public static String[] separarCadena2(String cadena, int n, int m) {
        // Verificar que n y m no excedan la longitud de la cadena
        if (n + m > cadena.length()) {
            throw new IllegalArgumentException("La suma de n y m es mayor que la longitud de la cadena");
        }

        // Dividir la cadena en tres partes
        String primeraParte = cadena.substring(0, n);
        String segundaParte = cadena.substring(n, n + m);
        String terceraParte = cadena.substring(n + m);

        return new String[] { primeraParte, segundaParte, terceraParte };
    }


    // 3C
    // Dada una cadena de un tamaño especificado y un int[] con los tamaños de las partes,
    // separar las partes de la cadena. El resultado es un String[] de tantas partes se haya
    // especificado en el int [], más el fragmento final con el sobrante, si aplica.
    // Debe validar que la suma de los elementos del int[] sea igual o menor que la longitud total
    // del String de entrada. En caso de que no coincida, retorna null. Este valor debe ser validado en el
    // metodo principal donde prueba que funcione.

    // Metodo para generar una cadena de una longitud específica (puede ser cualquier implementación)
    public static String generarCadena(int longitud) {
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            sb.append((char) ('a' + (i % 26))); // Generar secuencia de 'a' a 'z'
        }
        return sb.toString();
    }

    // Metodo para separar la cadena en partes según los tamaños especificados
    public static String[] separarCadena(String cadena, int[] tamanos) {
        // Validar que la suma de los tamaños sea igual o menor que la longitud de la cadena
        int sumaTamanos = 0;
        for (int tam : tamanos) {
            sumaTamanos += tam;
        }
        if (sumaTamanos > cadena.length()) {
            return null; // Retorna null si la suma es mayor que la longitud de la cadena
        }

        String[] partes = new String[tamanos.length + 1]; // Arreglo de partes
        int inicio = 0;

        // Separar la cadena en partes según los tamaños especificados
        for (int i = 0; i < tamanos.length; i++) {
            partes[i] = cadena.substring(inicio, inicio + tamanos[i]);
            inicio += tamanos[i];
        }

        // Agregar el sobrante si hay alguno
        if (inicio < cadena.length()) {
            partes[tamanos.length] = cadena.substring(inicio);
        } else {
            partes = java.util.Arrays.copyOf(partes, tamanos.length); // Eliminar el espacio extra si no hay sobrante
        }

        return partes;
    }



    // 4
    // Dadas las partes que conforman cada cadena, unirlas para conformarla completamente.
    public static String unirCadenas(List<String> partes) {
        StringBuilder cadenaCompleta = new StringBuilder();
        for (String parte : partes) {
            cadenaCompleta.append(parte);
        }
        return cadenaCompleta.toString();
    }
}
