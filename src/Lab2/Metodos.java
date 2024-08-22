package src.Lab2;

import java.util.Arrays;

public class Metodos {
    public Metodos() {
    }

    // Metodo que separa una cadena por espacios
    public String[] separarCadenaPorEspacios(String texto) {
        return texto.split(" "); // Divide la cadena en partes usando el espacio como
        // delimitador y devuelve el array resultante
    }

    // Aquí irán todos los métodos de la aplicación del servidor, se
    // accederán por medio del objeto "metodo" en la clase EchoTCPServer.java

    // todo: hacer los metodos asignados en el código usando, como siempre, el metodo de separar la cadena

    //1a

    //1b

    //1c

    //2a
    // El programa cliente debe solicitar ingresar un código, el usuario digita GEN-CAD seguido de la
    // cantidad de caracteres que requiere generar. El mensaje será enviado al servidor a través de la red,
    // el cual será el encargado de generar la cadena de caracteres y devolver el resultado al cliente.
    // Crear un String de un tamaño especificado.
    // El contenido será el abecedario en letras minúsculas tantas veces
    // como sea necesario hasta completar el tamaño de la cadena.
    public String generarCadenaFija(int tamanio) {
        StringBuilder cadena = new StringBuilder();
        String abecedario = "abcdefghijklmnopqrstuvwxyz";

        // Repite el abecedario hasta alcanzar el tamaño deseado
        while (cadena.length() < tamanio) {
            cadena.append(abecedario);
        }

        // Devuelve la subcadena del tamaño especificado
        return cadena.substring(0, tamanio);
    }

    //2b
    //El programa cliente debe solicitar el ingreso de un código, el usuario digita GEN-CAD seguido de los dos
    // parámetros necesarios para realizar la operación (cantidad de caracteres y la cantidad de caracteres para
    // cada uno de los segmentos). El mensaje será enviado al servidor a través de la red, el cual será el encargado de
    // generar la cadena, segmentarla en las partes indicadas separadas por comas (,) y devolver el resultado al cliente.
    // Nota: La cadena de caracteres que se genere debe ser de longitud múltiplo de 16 caracteres.
    public   String generarCadenaSegmentada(int cantidadTotal, int segmentoLength) {
        int cantidadSegmentos = cantidadTotal / segmentoLength;
        String[] segmentos = new String[cantidadSegmentos];
        String cadena = generarCadenaFija(cantidadTotal);

        if (!esPotenciaDeDos(segmentoLength)) {
            throw new IllegalArgumentException("El tamaño del segmento debe ser una potencia de 2.");
        }



        for (int i = 0; i < cantidadSegmentos; i++) {
            int inicio = i * segmentoLength;
            segmentos[i] = cadena.substring(inicio, inicio + segmentoLength);
        }

        return Arrays.toString(segmentos);
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

    //2c
    // El programa cliente debe solicitar el ingreso de un código, el usuario digita GEN-CAD-PAR
    // seguido de los dos parámetros necesarios para realizar la operación (cantidad de caracteres y
    // la cantidad de caracteres para cada uno de los segmentos). El mensaje será enviado al servidor a
    // través de la red, el cual será el encargado realizar el cálculo de las partes que serán enviadas en
    // mensajes independientes al cliente.
    // Nota: La cadena de caracteres que se genere debe ser de longitud múltiplo de 16 caracteres.
    public   String[] generarCadenaEnArreglo(int cantidadTotal, int segmentoLength) {
        int cantidadSegmentos = cantidadTotal / segmentoLength;
        String[] segmentos = new String[cantidadSegmentos];
        String cadena = generarCadenaFija(cantidadTotal);

        if (!esPotenciaDeDos(segmentoLength)) {
            throw new IllegalArgumentException("El tamaño del segmento debe ser una potencia de 2.");
        }



        for (int i = 0; i < cantidadSegmentos; i++) {
            int inicio = i * segmentoLength;
            segmentos[i] = cadena.substring(inicio, inicio + segmentoLength);
        }

        // Llena el arreglo con las partes etiquetadas
        for (int i = 0; i < segmentos.length; i++) {
            segmentos[i] = "Parte " + i + " " + segmentos[i];
        }

        return segmentos;
    }





    //3a

    //3b

    //3c

    //4

}
