package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

/**
 * Created by buzaga on 5/5/14.
 */
public class IndicadorFechamento implements Indicador {
    @Override
    public double calcula(int posicao, SerieTemporal serie) {
        return serie.getCandle(posicao).getFechamento();
    }

    @Override
    public String toString() {
        return "Fechamento";
    }
}
