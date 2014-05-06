package br.com.caelum.argentum.modelo;

import java.util.Calendar;

/**
 * Created by buzaga on 5/1/14.
 */
public class CandleBuilder {

    private Double abertura;
    private Double fechamento;
    private Double minimo;
    private Double maximo;
    private Double volume;
    private Calendar data;

    public Candle build(){
        if (abertura == null || fechamento == null || minimo == null || maximo == null || volume == null || data == null) throw new IllegalStateException("missing values");
        return new Candle(abertura, fechamento, minimo, maximo, volume, data);
    }

    public CandleBuilder abertura(double abertura) {
        this.abertura = abertura;
        return this;
    }

    public CandleBuilder fechamento(double fechamento) {
        this.fechamento = fechamento;
        return this;
    }

    public CandleBuilder minimo(double minimo) {
        this.minimo = minimo;
        return this;
    }

    public CandleBuilder maximo(double maximo) {
        this.maximo = maximo;
        return this;
    }

    public CandleBuilder volume(double volume) {
        this.volume = volume;
        return this;
    }

    public CandleBuilder data(Calendar data) {
        this.data = data;
        return this;
    }
}
