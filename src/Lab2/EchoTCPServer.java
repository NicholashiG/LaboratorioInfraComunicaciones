package src.Lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class EchoTCPServer {
    public static final int PORT = 3400;
    private ServerSocket listener;
    private Socket serverSideSocket;
    private PrintWriter toNetwork;
    private BufferedReader fromNetwork;
    public Metodos metodos;

    public EchoTCPServer() {
        System.out.println("Echo TCP server is running on port: " + PORT);
        this.metodos = new Metodos();
    }

    public void init() throws Exception {
        listener = new ServerSocket(PORT);
        while (true) {
            serverSideSocket = listener.accept();
            createStreams(serverSideSocket);
            protocol(serverSideSocket);
        }
    }

    // todo: ajustar esta clase para llamar a los metodos
    // todo: imprimir el resultado de cada metodo pedido
    public void protocol(Socket socket) throws Exception {
        String message = fromNetwork.readLine();
        System.out.println("[Server] From client: " + message);
        String[] answer = metodos.separarCadenaPorEspacios(message);
        String mensajeFinal = "";
        switch (answer[0]) {
        // PARTE 1

        // FIN PARTE 1
        // ------------------------------------------
        // PARTE 2
            case "GEN-CAD":
                if (answer.length < 3) {
                    mensajeFinal = metodos.generarCadenaFija(Integer.parseInt(answer[1]));
                } else {
                    mensajeFinal = metodos.generarCadenaSegmentada(Integer.parseInt(answer[1]), Integer.parseInt(answer[2]));
                }
                break;
            case "GEN-CAD-PAR":
                mensajeFinal= Arrays.toString(metodos.generarCadenaEnArreglo((Integer.parseInt(answer[1])), Integer.parseInt(answer[2])));
        // FIN PARTE 2
        // ------------------------------------------
        // PARTE 3

        // FIN PARTE 3
        // ------------------------------------------
        // PARTE 4

        // FIN PARTE 4
        }

        toNetwork.println(mensajeFinal);
    }

    private void createStreams(Socket socket) throws Exception {
        toNetwork = new PrintWriter(socket.getOutputStream(), true);
        fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public static void main(String args[]) throws Exception {
        EchoTCPServer es = new EchoTCPServer();
        es.init();
    }
}