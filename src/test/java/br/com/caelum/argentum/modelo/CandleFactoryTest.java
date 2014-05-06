package br.com.caelum.argentum.modelo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by buzaga on 5/1/14.
 */
public class CandleFactoryTest {

    @Test
    public void testSequenciaSimplesDeNegociacoes() throws Exception {
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandleFactory factory = new CandleFactory();
        Candle candle = factory.constroiCandleParaData(hoje, negociacoes);

        assertEquals(40.5, candle.getAbertura(), 0.0001);
        assertEquals(42.3, candle.getFechamento(), 0.0001);
        assertEquals(39.8, candle.getMinimo(), 0.0001);
        assertEquals(45.0, candle.getMaximo(), 0.0001);
        assertEquals(16760.0, candle.getVolume(), 0.0001);
    }

    @Test
    public void testVolumeIsRight() throws Exception {
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(10, 1, hoje); //10
        Negociacao negociacao2 = new Negociacao(20, 3, hoje); //60
        List<Negociacao> negociacaoList = Arrays.asList(negociacao1, negociacao2);

        CandleFactory factory = new CandleFactory();
        Candle candle = factory.constroiCandleParaData(hoje, negociacaoList);
        assertEquals(factory.constroiCandleParaData(hoje, negociacaoList).getVolume(), 70.0, 0.0001);

    }

    @Test
    public void testSemNegociacoesGeraCandleComZeros() throws Exception {
        Calendar hoje = Calendar.getInstance();

        List<Negociacao> negociacoes = Arrays.asList();

        CandleFactory factory = new CandleFactory();
        Candle candle = factory.constroiCandleParaData(hoje, negociacoes);

        assertEquals(0.0, candle.getVolume(), 0.0001);
    }

    @Test
    public void testUmaSoNegociacaoGeraCandleComValoresIguais() throws Exception {
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao = new Negociacao(40.5, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao);

        CandleFactory factory = new CandleFactory();

        Candle candle = factory.constroiCandleParaData(hoje, negociacoes);

        assertEquals(40.5, candle.getAbertura(), 0.0001);
        assertEquals(40.5, candle.getFechamento(), 0.0001);
        assertEquals(40.5, candle.getMinimo(), 0.0001);
        assertEquals(40.5, candle.getMaximo(), 0.0001);
        assertEquals(4050.0, candle.getVolume(), 0.0001);
    }

    @Test
    public void testNegociacoesEm3DiasDistintosGera3Candles() throws Exception {
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(45, 100, hoje);
        Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

        Calendar amanha = (Calendar) hoje.clone();
        amanha.add(Calendar.DAY_OF_MONTH, 1);

        Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
        Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);

        Calendar depois = (Calendar) hoje.clone();
        depois.add(Calendar.DAY_OF_MONTH, 2);

        Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
        Negociacao negociacao8 = new Negociacao(52.3, 100, depois);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5, negociacao6, negociacao7, negociacao8);

        CandleFactory factory = new CandleFactory();
        List<Candle> candles = factory.constroiCandles(negociacoes);

        assertEquals(3, candles.size());
        assertEquals(40.5, candles.get(0).getAbertura(), 0.0001);
        assertEquals(42.3, candles.get(0).getFechamento(), 0.0001);
        assertEquals(48.8, candles.get(1).getAbertura(), 0.0001);
        assertEquals(49.3, candles.get(1).getFechamento(), 0.0001);
        assertEquals(51.8, candles.get(2).getAbertura(), 0.0001);
        assertEquals(52.3, candles.get(2).getFechamento(), 0.0001);

    }
}
