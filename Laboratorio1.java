public class Laboratorio1 {
    public static void main(String[] args) {
        System.out.println(convertirADecimal(10, 5));
    }

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


}
