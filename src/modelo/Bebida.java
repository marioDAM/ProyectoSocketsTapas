package modelo;

import java.io.Serializable;
import java.util.Random;

public class Bebida implements Serializable {
    private static final double[] precios = new double[]{2.50, 2.00, 1.50};
    private String tipoBebida;

    private double precio;

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Bebida() {
        Random random = new Random();
        int low = 0;
        int high = 3;
        int result = random.nextInt(high - low) + low;

        switch (result) {
            case 0:
                tipoBebida = "Refresco";
                precio = precios[0];
                break;
            case 1:
                tipoBebida = "Tercio";
                precio = precios[1];
                break;
            case 2:
                tipoBebida = "Botellin";
                precio = precios[2];
                break;
        }
    }
}
