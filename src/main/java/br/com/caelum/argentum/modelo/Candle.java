package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by buzaga on 5/1/14.
 */
public class Candle {
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volume;
    private final Calendar data;

    public Candle(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
        if (data == null) throw new IllegalArgumentException("data cant be null");
        if (abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0) throw new IllegalArgumentException("values cant be negative");
        if (minimo > maximo) throw new IllegalArgumentException("minimo cant be greater than maximo");

        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
    }

    public boolean isAlta(){
        return this.abertura <= this.fechamento;
    }

    public boolean isBaixa(){
        return this.abertura > this.fechamento;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Candle{")
            .append("abertura=")
            .append(abertura)
            .append(", fechamento=")
            .append(fechamento)
            .append(", minimo=")
            .append(minimo)
            .append(", maximo=")
            .append(maximo)
            .append(", volume=")
            .append(volume)
            .append(", data=").append(new SimpleDateFormat("dd/MM/yyyy").format(data.getTime())).append('}').toString();
    }

    public double getAbertura() {
        return abertura;
    }

    public double getFechamento() {
        return fechamento;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getVolume() {
        return volume;
    }

    public Calendar getData() {
        return data;
    }
}
