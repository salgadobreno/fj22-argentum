package br.com.caelum.argentum.modelo;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by buzaga on 5/1/14.
 */
public class NegociacaoTest {

    @Test
    public void testDataDaNegociacaoImutavel() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        Negociacao negociacao = new Negociacao(10, 5, calendar);

        negociacao.getData().set(Calendar.DAY_OF_MONTH, 20);

        assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaoCriaNegociacaoComDataNula() throws Exception {
        new Negociacao(10, 5, null);
    }

    @Test
    public void testMesmoMilisegundoEhMesmoDia() throws Exception {
        Calendar agora = Calendar.getInstance();
        Calendar mesmoMomento = Calendar.getInstance();

        Negociacao negociacao = new Negociacao(40.0, 100, agora);
        assertTrue(negociacao.isMesmoDia(mesmoMomento));

    }

    @Test
    public void testComHorariosDiferentesEhMesmoDia() throws Exception {
        Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
        Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40, 100, manha);
        assertTrue(negociacao.isMesmoDia(tarde));
    }

    @Test
    public void testComMesesDiferentesNEhMesmoDia() throws Exception {
        Calendar um = new GregorianCalendar(2011, 10, 20, 20, 30);
        Calendar dois = new GregorianCalendar(2011, 12, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40, 100, um);
        assertFalse(negociacao.isMesmoDia(dois));
    }

    @Test
    public void testComAnosDiferentesEhMesmoDia() throws Exception {
        Calendar um = new GregorianCalendar(2012, 10, 20, 8, 30);
        Calendar dois = new GregorianCalendar(2013, 10, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40, 100, um);
        assertFalse(negociacao.isMesmoDia(dois));
    }
}
