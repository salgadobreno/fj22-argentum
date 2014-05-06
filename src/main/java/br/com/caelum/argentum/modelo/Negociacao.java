package br.com.caelum.argentum.modelo;

import java.util.Calendar;

/**
 * Created by buzaga on 5/1/14.
 */
public final class Negociacao {
    private final double preco;

    private final int quantidade;

    private final Calendar data;

    public Negociacao(double preco, int quantidade, Calendar data) {
        if (data == null) throw new IllegalArgumentException("data não pode ser nula");
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double getVolume(){
        return preco * quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Calendar getData() {
        return (Calendar) this.data.clone();
    }

    public boolean isMesmoDia(Calendar calendar) {
        return this.data.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) &&
            this.data.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
            this.data.get(Calendar.YEAR) == calendar.get(Calendar.YEAR);
    }
}
