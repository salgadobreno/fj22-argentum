package br.com.caelum.argentum.modelo;

import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by buzaga on 5/4/14.
 */
public class MediaMovelPonderadaTest {

    @Test
    public void testSequenciaSimplesDeCandles() throws Exception {
        SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6);
        MediaMovelPonderada mmp = new MediaMovelPonderada(new IndicadorFechamento());

        assertEquals(14.0/6, mmp.calcula(2,serie), 0.0001);
        assertEquals(20.0/6, mmp.calcula(3,serie), 0.0001);
        assertEquals(26.0/6, mmp.calcula(4,serie), 0.0001);
        assertEquals(32.0/6, mmp.calcula(5,serie), 0.0001);
    }
}
