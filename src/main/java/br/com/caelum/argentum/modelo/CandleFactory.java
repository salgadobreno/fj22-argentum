package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by buzaga on 5/1/14.
 */
public class CandleFactory {
    public Candle constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
        double maximo = 0;
        double minimo = Double.MAX_VALUE;
        double volume = 0;

        for (Negociacao negociacao : negociacoes) {
            volume += negociacao.getVolume();

            if (negociacao.getPreco() >  maximo) {
                maximo = negociacao.getPreco();
            }
            if (negociacao.getPreco() < minimo) {
                minimo = negociacao.getPreco();
            }
        }

        double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
        double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();


        return new CandleBuilder().abertura(abertura).fechamento(fechamento).maximo(maximo).minimo(minimo).volume(volume).data(data).build();
    }

    public List<Candle> constroiCandles(List<Negociacao> negociacoes) {
        List<Candle> candles = new ArrayList<Candle>();

        List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
        Calendar dataAtual = negociacoes.get(0).getData();

        for (Negociacao negociacao : negociacoes) {
            if (!negociacao.isMesmoDia(dataAtual)) {
                Candle candleDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
                candles.add(candleDia);
                negociacoesDoDia = new ArrayList<Negociacao>();
                dataAtual = negociacao.getData();
            }
            negociacoesDoDia.add(negociacao);
        }

        Candle candleDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
        candles.add(candleDia);

        return candles;
    }
}
