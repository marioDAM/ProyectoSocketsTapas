package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {
    private List<Bebida> bebidas;
    private List<Tapa> tapas;

    private double precioTotal;
    public Pedido() {
        this.bebidas = new ArrayList<Bebida>();
        this.tapas = new ArrayList<Tapa>();
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> refrescos) {
        this.bebidas = refrescos;
    }

    public List<Tapa> getTapas() {
        return tapas;
    }

    public void setTapas(List<Tapa> tapas) {
        this.tapas = tapas;
    }

    public void addBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public void addTapa(Tapa tapa) {
        tapas.add(tapa);
    }
}
