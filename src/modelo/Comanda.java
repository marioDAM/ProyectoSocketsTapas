package modelo;

import java.io.Serializable;

public class Comanda implements Serializable {


    private int tapasSolicitadas;

    private int bebidasSolicitadas;

    public int getTapasSolicitadas() {
        return tapasSolicitadas;
    }


    public void setTapasSolicitadas(int tapasSolicitadas) {
        this.tapasSolicitadas = tapasSolicitadas;
    }

    public int getBebidasSolicitadas() {
        return bebidasSolicitadas;
    }

    public void setBebidasSolicitadas(int bebidasSolicitadas) {
        this.bebidasSolicitadas = bebidasSolicitadas;
    }

    public Comanda() {

    }


}
