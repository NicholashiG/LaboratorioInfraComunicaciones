public class Laboratorio1 {
    public static void main(String[] args) {

        System.out.println(convertirADecimal(10, 5));

        int decimalNumber = 255; // Número decimal a convertir
        int ancho = 4; // Ancho en dígitos hexadecimales

        // Llamada al metodo para convertir y formatear el número
        String hexNumber = convertirToHexadecimal(decimalNumber, ancho);

        System.out.println("El número " + decimalNumber + " en hexadecimal es: " + hexNumber);


    }

    //Convertir un número de entero decimal a hexadecimal, especificando el ancho en dígitos hexadecimales
    public static String convertirToHexadecimal(int decimalNumber, int ancho) {
        // Convertir el número decimal a hexadecimal
        String hexNumber = Integer.toHexString(decimalNumber).toUpperCase();

        // Formatear con el ancho especificado (rellenar con ceros a la izquierda si es necesario)
        while (hexNumber.length() < ancho) {
            hexNumber = "0" + hexNumber;
        }

        return hexNumber;
    }


}
