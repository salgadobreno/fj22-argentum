package br.com.caelum.argentum.modelo;

import org.junit.Test;

import java.util.Calendar;

/**
 * Created by buzaga on 5/1/14.
 */
public class CandleBuilderTest {
    @Test(expected = IllegalStateException.class)
    public void testTodosOsSettersSaoNecessarios() throws Exception {
        new CandleBuilder().data(Calendar.getInstance()).abertura(10).build();
        new CandleBuilder().data(Calendar.getInstance()).abertura(10).fechamento(10).build();
        new CandleBuilder().data(Calendar.getInstance()).abertura(10).fechamento(10).maximo(10).build();
        new CandleBuilder().data(Calendar.getInstance()).abertura(10).fechamento(10).maximo(10).minimo(10).build();
        new CandleBuilder().data(Calendar.getInstance()).abertura(10).fechamento(10).maximo(10).minimo(10).volume(10).build();
        new CandleBuilder().data(Calendar.getInstance()).build();
    }
}
