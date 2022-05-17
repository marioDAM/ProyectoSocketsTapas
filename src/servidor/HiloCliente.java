package servidor;

import modelo.Bebida;
import modelo.Comanda;
import modelo.Pedido;
import modelo.Tapa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class HiloCliente extends Thread {
    private List<Tapa> tapas;
    private List<Bebida> bebidas;
    private Socket cliente;

    public HiloCliente(Socket cliente, List<Tapa> tapas, List<Bebida> bebidas) {
        this.cliente = cliente;
        this.tapas = tapas;
        this.bebidas = bebidas;
    }

    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            System.out.println("Hilo cliente preparado");

            Comanda comanda = (Comanda) ois.readObject();
            Pedido pedido = new Pedido();

            System.out.println(comanda.getBebidasSolicitadas());
            System.out.println(comanda.getTapasSolicitadas());

            //Rellenamos las bebidas
            for (int i = 0; i < comanda.getBebidasSolicitadas(); i++) {
                //Quitamos las bebidas solicitadas de las bebidas y las añadimos a la comanda
                Bebida b = bebidas.remove(0);
                pedido.setPrecioTotal(pedido.getPrecioTotal() + b.getPrecio());
                pedido.addBebida(b);
            }

            //Rellenamos las tapas
            for (int i = 0; i < comanda.getTapasSolicitadas(); i++) {
                Tapa tapa = tapas.remove(0);
                pedido.setPrecioTotal(pedido.getPrecioTotal() + tapa.getPrecio());
                pedido.addTapa(tapa);
            }

            oos.writeObject(pedido);

            ois.close();
            oos.close();

            System.out.println(tapas.size());
            System.out.println(bebidas.size());

            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
