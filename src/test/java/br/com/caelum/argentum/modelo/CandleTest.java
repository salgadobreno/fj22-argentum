package br.com.caelum.argentum.modelo;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by buzaga on 5/1/14.
 */
public class CandleTest {
    @Test(expected = IllegalArgumentException.class)
    public void testPrecoMaximoNaoPodeSerMenorQueOMinimo() throws Exception {
        Calendar hoje = Calendar.getInstance();
        new Candle(10, 10, Double.MAX_VALUE, Double.MIN_VALUE, 0, hoje);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDataCantBeNull() throws Exception {
        new Candle(10, 10, 0, 1, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValoresNaoPodemSerNegativos() throws Exception {
        new Candle(-1, -1, -1, -1, -1, Calendar.getInstance());
        new Candle(-1, -1, -1, -1, 10, Calendar.getInstance());
        new Candle(-1, -1, -1, 10, 10, Calendar.getInstance());
        new Candle(-1, -1, 10, 10, 10, Calendar.getInstance());
        new Candle(-1, 10, 10, 10, 10, Calendar.getInstance());
    }

    @Test
    public void testIsAltaQdoAberturaIgualFechamento() throws Exception {
        Candle c = new Candle(10, 10, 10, 10, 10, Calendar.getInstance());
        assertTrue(c.isAlta());
        assertFalse(c.isBaixa());
    }
}
