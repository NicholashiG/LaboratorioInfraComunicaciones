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

    // 1F
    // Convertir un número hexadecimal a binario
    public static String convertirAHexadecimal(String numeroHexadecimal) {
        // Convierte el hexadecimal a decimal primero
        int decimal = Integer.parseInt(numeroHexadecimal, 16);
        // Luego convierte el decimal a binario
        return Integer.toBinaryString(decimal);
    }
}
