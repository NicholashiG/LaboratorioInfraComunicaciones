package src.Lab2;

import java.util.Arrays;

import javax.print.DocFlavor.STRING;

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

    // 1a El programa cliente debe solicitar el ingreso de un código, el usuario digita CONV-DEC-BIN 
    // seguido de los dos parámetros necesarios para realizar la conversión. El mensaje será enviado al 
    // servidor a través de la red, el cual será el encargado de realizar la conversión y devolver el resultado 
    // al cliente
    public String convertirEnteroDecimal (String [] answer)
     {
        int decimal = Integer.parseInt(answer[1]);
        int bits = Integer.parseInt(answer[2]);
        String conversion = Integer.toBinaryString(decimal);
        String binarioFinal = String.format("%" + bits + "s", conversion).replace(' ', '0');
        
        return binarioFinal;
     }

    // 1b El programa cliente debe solicitar el ingreso de un código, el usuario digita CONV-DEC-HEX 
    // seguido de los dos parámetros necesarios para realizar la conversión. El mensaje será enviado al 
    // servidor a través de la red, el cual será el encargado de realizar la conversión y devolver el 
    // resultado al cliente.
    public String convertiDecimalHexadecimal (String [] answer)
    {
       int decimal = Integer.parseInt(answer[1]);
       int bits = Integer.parseInt(answer[2]);
       String hex = Integer.toHexString(decimal).toUpperCase();
       String hexaFinal = String.format("%" + bits + "s", hex).replace(' ', '0');

       return hexaFinal;
    }

    // 1cEl programa cliente debe solicitar el ingreso de un código, el usuario digita CONV-BIN-HEXA
    //  seguido del parámetro necesario para realizar la conversión. El mensaje será enviado al servidor
    //  a través de la red, el cual será el encargado de realizar la conversión y devolver el resultado
    //  al cliente.

    public String convertiBinarioHexadecimal(String [] answer)
    {
       String binario = answer[1];
       int decimal = Integer.parseInt(binario, 2);
       String hex = Integer.toHexString(decimal).toUpperCase();
       return hex;
    }

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



    //3a). El programa cliente debe solicitar el ingreso de un código, el usuario digita CAD-SEG seguido de los parámetros
    // necesarios para realizar la operación (cantidad de caracteres y los tamaños de las partes para separar la cadena).
    // El mensaje será enviado al servidor a través de la red, el cual será el encargado de generar la cadena, segmentarla en
    // las partes con los tamaños indicados y devolver el resultado al cliente separados por comas.

    public boolean verificarTamanio (String cadena[], int tam)
    {
        int contador = 0;
        boolean isTamanio = false;
        for (int i =2; i<cadena.length; i ++)
        {
            contador = contador + Integer.parseInt(cadena[i]);
        }

        if (tam == contador)
        {
            isTamanio = true;
        }

        return isTamanio;
    }

    public String segmentarCadena(String cadena[]) {
        String abecedario = generarCadenaFija(Integer.parseInt(cadena[1]));
        int inicio = 0;
        int cadTamanio = Integer.parseInt(cadena[1]);
        boolean isVerdad = verificarTamanio(cadena, cadTamanio);

        if (isVerdad) {
            StringBuilder resultado = new StringBuilder();
            for (int i = 2; i < cadena.length; i++) {
                int longitudSegmento = Integer.parseInt(cadena[i]);
                if (i > 2) {
                    resultado.append(", ");
                }
                resultado.append(abecedario.substring(inicio, inicio + longitudSegmento));
                inicio += longitudSegmento;
            }
            return resultado.toString();
        } else {
            return "La división de la cadena no es igual a la cantidad pedida";
        }
    }


    //3b



    public static boolean esMultiploDe16(int x) {

        return x % 16 == 0;
    }

    public String segmentarCadenaPR(String cadena[]) {
        String abecedario = generarCadenaFija(Integer.parseInt(cadena[1]));
        int inicio = 0;
        int cadTamanio = Integer.parseInt(cadena[1]);
        boolean isVerdadTamanio = verificarTamanio(cadena, cadTamanio);
        boolean isVerdadMultiplo = esMultiploDe16(Integer.parseInt(cadena[1]));
        StringBuilder resultado = new StringBuilder();

        if (isVerdadTamanio && isVerdadMultiplo) {
            for (int i = 2; i < cadena.length; i++) {
                int longitudSegmento = Integer.parseInt(cadena[i]);
                resultado.append("Parte ").append(i - 1).append(": ");
                resultado.append(abecedario.substring(inicio, inicio + longitudSegmento)).append("\n");
                inicio += longitudSegmento; // Avanzar el índice de inicio
            }

        } else
            {
                resultado.append("La división de la cadena no es igual a la cantidad pedida");
            }

        return resultado.toString();
    }

    //3c

    //4
    public String unirCadena (String [] parts)
    {
        StringBuilder concatenatedString = new StringBuilder();

        // Usar un ciclo for para unir las partes de la cadena
        for (int i = 1; i < parts.length; i++) {
            concatenatedString.append(parts[i]);
        }
        return concatenatedString.toString();
    }

}
