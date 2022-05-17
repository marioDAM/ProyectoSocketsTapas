package modelo;

import java.io.Serializable;
import java.util.Random;

public class Tapa implements Serializable {
    private String tipoTapa;
    private static double precios[] = new double[]{10.00, 10.5, 10.00};
    private double precio;

    public String getTipoTapa() {
        return tipoTapa;
    }

    public void setTipoTapa(String tipoTapa) {
        this.tipoTapa = tipoTapa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Tapa() {
        Random random = new Random();
        int low = 0;
        int high = 3;
        int result = random.nextInt(high - low) + low;

        switch (result) {
            case 0:
                tipoTapa = "oreja en salsa";
                precio = precios[0];
                break;
            case 1:
                tipoTapa = "oreja picantona";
                precio = precios[1];
                break;
            case 2:
                tipoTapa = "oreja a la plancha";
                precio = precios[2];
                break;
        }
    }
}
