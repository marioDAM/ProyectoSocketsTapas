package cliente;

import modelo.Comanda;
import modelo.Pedido;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread {
    private Socket socket;

    public Cliente() {

    }

    public void run() {
        try {
            socket = new Socket("localhost", 5555);
            System.out.println("Conectado con el servidor");
            ObjectOutputStream bufferObjetosSalida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream bufferObjetosEntrada = new ObjectInputStream(socket.getInputStream());
            Comanda comanda = new Comanda();

            System.out.println("Cuantas bebidas quieres ?");
            Scanner teclado = new Scanner(System.in);
            Integer nBebidas;
            nBebidas = teclado.nextInt();
            comanda.setBebidasSolicitadas(nBebidas);
            System.out.println("Cuantas raciones quiere ?");
            Integer nRaciones = teclado.nextInt();

            comanda.setTapasSolicitadas(nRaciones);

            bufferObjetosSalida.writeObject(comanda);

            Pedido pedido = (Pedido) bufferObjetosEntrada.readObject();

            for (int i = 0; i < pedido.getTapas().size(); i++) {
                System.out.println("Cliente ha recibido una tàpa de " + pedido.getTapas().get(i).getTipoTapa());
            }

            for (int i = 0; i < pedido.getBebidas().size(); i++) {
                System.out.println("Cliente ha recibido una bebida de " + pedido.getBebidas().get(i).getTipoBebida());
            }
            System.out.println("El precio del pedido es " + pedido.getPrecioTotal());
            bufferObjetosSalida.close();
            bufferObjetosEntrada.close();

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
