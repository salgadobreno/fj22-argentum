package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

/**
 * Created by buzaga on 5/5/14.
 */
public interface Indicador {
    public abstract double calcula(int posicao, SerieTemporal serie);
}
