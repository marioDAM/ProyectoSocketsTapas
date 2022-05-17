package servidor;

import modelo.Bebida;
import modelo.Tapa;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends Thread {
    private List<Tapa> tapas;
    private List<Bebida> bebidas;

    private ServerSocket serverSocket;

    public Servidor() {
        tapas = new ArrayList<Tapa>();
        bebidas = new ArrayList<Bebida>();
        for (int i = 1; i < 101; i++) {
            tapas.add(new Tapa());
            bebidas.add(new Bebida());

        }
        System.out.println("Tapas y bebidas creadas");
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(5555);
            System.out.println("Esperando conexiones");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado");
                HiloCliente hilo = new HiloCliente(socket, tapas, bebidas);
                hilo.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
